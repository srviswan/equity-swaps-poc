package com.pb.swap.archiver.copy;

import com.microsoft.sqlserver.jdbc.SQLServerBulkCopy;
import com.microsoft.sqlserver.jdbc.SQLServerBulkCopyOptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Different server and database: rows are streamed from the source {@code ResultSet} straight into
 * the target via {@code SQLServerBulkCopy} (two direct connections — no {@code bulkadmin}, no MSDTC,
 * no Kerberos delegation). A transaction cannot span the two instances, so correctness comes from a
 * checkpointed <b>copy → verify → delete</b> state machine that is idempotent on restart:
 *
 * <ol>
 *   <li><b>copy</b> — first delete any rows a prior crashed attempt left in the target for this
 *       batch (idempotent), then bulk-copy the chunk's source slice;
 *   <li><b>verify</b> — target row count (and optional {@code CHECKSUM_AGG}) must match the source
 *       slice; on mismatch we throw and a restart re-cleans + re-copies;
 *   <li><b>delete</b> — only after the target is proven, the {@code COPIED} checkpoint is written and
 *       the source rows are deleted in one atomic statement.
 * </ol>
 *
 * <p>A crash after {@code COPIED} resumes via the delete-only branch, so the verified target is
 * never re-cleaned or re-copied. For columnstore targets, the batch size lands compressed rowgroups.
 */
@Component
public class CrossServerBulkCopyStrategy implements CopyStrategy {

    private static final Logger log = LoggerFactory.getLogger(CrossServerBulkCopyStrategy.class);

    /** Rows per bulk-copy batch; ≥102,400 lands directly-compressed columnstore rowgroups. */
    private static final int BULK_BATCH_ROWS = 102_400;

    private final JdbcTemplate controlJdbc;

    public CrossServerBulkCopyStrategy(JdbcTemplate controlJdbc) {
        this.controlJdbc = controlJdbc;
    }

    @Override
    public String topology() {
        return "CROSS_SERVER";
    }

    @Override
    public MoveResult move(MoveContext ctx) throws SQLException {
        TableConfig t = ctx.table();
        String srcName = SameDbCopyStrategy.qName(t.sourceSchema(), t.sourceTable());
        String tgtName = SameDbCopyStrategy.qName(t.targetSchema(), t.targetTable());
        try (Connection src = ctx.connections().open(ctx.props().source());
                Connection tgt = ctx.connections().open(ctx.props().target())) {
            src.setAutoCommit(true);
            tgt.setAutoCommit(true);
            String keyType = SameDbCopyStrategy.columnTypeDdl(src, t.sourceSchema(), t.sourceTable(), t.keyColumn());

            // Resume: the target is already verified (COPIED). Only finish the source delete; never
            // re-clean or re-copy, which would destroy the trusted archive copy.
            if ("COPIED".equals(ctx.priorState())) {
                stageKeys(src, ctx, t.keyColumn(), keyType);
                long deleted = deleteSource(src, ctx, t, srcName);
                long copied = readRowsCopied(ctx);
                log.info(
                        "CROSS_SERVER chunk {} table {} resume@COPIED: deleted {} source row(s)",
                        ctx.chunkNo(), t.sourceName(), deleted);
                return new MoveResult(copied, deleted, null, null);
            }

            Set<String> srcCols = SameDbCopyStrategy.columns(src, null, t.sourceSchema(), t.sourceTable());
            Set<String> tgtCols = SameDbCopyStrategy.columns(tgt, null, t.targetSchema(), t.targetTable());
            if (!srcCols.stream().anyMatch(c -> c.equalsIgnoreCase(t.keyColumn()))) {
                throw new SQLException("key column '" + t.keyColumn() + "' not found on " + t.sourceName());
            }
            List<String> dataColumns = SameDbCopyStrategy.dataColumns(srcCols, tgtCols);
            if (dataColumns.isEmpty()) {
                throw new SQLException("no shared data columns between " + t.sourceName() + " and " + t.targetName());
            }
            List<String> lineageColumns = SameDbCopyStrategy.lineageColumns(srcCols, tgtCols);
            boolean hasBatchLineage = lineageColumns.contains("archive_batch_id");

            stageKeys(src, ctx, t.keyColumn(), keyType);
            stageKeys(tgt, ctx, t.keyColumn(), keyType);

            cleanupTarget(tgt, ctx, t, tgtName, hasBatchLineage);

            long srcCount = countJoined(src, ctx, t, srcName, false, false);
            bulkCopy(src, tgt, ctx, t, tgtName, dataColumns, lineageColumns);
            long tgtCount = countJoined(tgt, ctx, t, tgtName, true, hasBatchLineage);
            if (srcCount != tgtCount) {
                throw new SQLException(
                        "cross-server row mismatch on " + t.sourceName() + ": source=" + srcCount
                                + " target=" + tgtCount);
            }

            Long sourceChecksum = null;
            Long targetChecksum = null;
            if (t.checksumVerify() && srcCount > 0) {
                sourceChecksum = checksum(src, ctx, t, dataColumns, srcName, false, false);
                targetChecksum = checksum(tgt, ctx, t, dataColumns, tgtName, true, hasBatchLineage);
                if (!Objects.equals(sourceChecksum, targetChecksum)) {
                    throw new SQLException(
                            "cross-server checksum mismatch on " + t.sourceName() + ": source=" + sourceChecksum
                                    + " target=" + targetChecksum + " (delete blocked)");
                }
            }

            // Persist COPIED *before* deleting the source: a crash between here and the delete resumes
            // via the delete-only branch above instead of re-copying.
            markCopied(ctx, srcCount, sourceChecksum, targetChecksum);

            long rowsDeleted = deleteSource(src, ctx, t, srcName);
            log.info(
                    "CROSS_SERVER chunk {} table {} copied {} / deleted {} row(s)",
                    ctx.chunkNo(), t.sourceName(), srcCount, rowsDeleted);
            return new MoveResult(srcCount, rowsDeleted, sourceChecksum, targetChecksum);
        }
    }

    private void stageKeys(Connection conn, MoveContext ctx, String keyColumn, String keyType) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("IF OBJECT_ID('tempdb..#archive_keys') IS NOT NULL DROP TABLE #archive_keys");
            st.execute("CREATE TABLE #archive_keys (" + q(keyColumn) + " " + keyType + " NOT NULL PRIMARY KEY)");
        }
        try (PreparedStatement ps =
                conn.prepareStatement("INSERT INTO #archive_keys (" + q(keyColumn) + ") VALUES (?)")) {
            for (Long key : ctx.basketKeys()) {
                ps.setLong(1, key);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void cleanupTarget(Connection tgt, MoveContext ctx, TableConfig t, String tgtName, boolean byBatch)
            throws SQLException {
        String sql =
                "DELETE x FROM " + tgtName + " x JOIN #archive_keys k ON x." + q(t.keyColumn()) + " = k."
                        + q(t.keyColumn()) + (byBatch ? " WHERE x." + q("archive_batch_id") + " = ?" : "");
        try (PreparedStatement ps = tgt.prepareStatement(sql)) {
            if (byBatch) {
                ps.setLong(1, ctx.runId());
            }
            ctx.stop().register(ps);
            try {
                ps.executeUpdate();
            } finally {
                ctx.stop().clear(ps);
            }
        }
    }

    private void bulkCopy(
            Connection src,
            Connection tgt,
            MoveContext ctx,
            TableConfig t,
            String tgtName,
            List<String> dataColumns,
            List<String> lineageColumns)
            throws SQLException {
        StringBuilder select = new StringBuilder();
        for (String c : dataColumns) {
            append(select, "s." + q(c) + " AS " + q(c));
        }
        for (String c : lineageColumns) {
            switch (c.toLowerCase(Locale.ROOT)) {
                case "archived_at_utc" -> append(select, "SYSUTCDATETIME() AS " + q(c));
                case "archive_batch_id" -> append(select, "CAST(" + ctx.runId() + " AS BIGINT) AS " + q(c));
                case "archived_period_key" -> append(select, ctx.archivedPeriodKey() + " AS " + q(c));
                default -> append(select, "CAST(NULL AS SQL_VARIANT) AS " + q(c));
            }
        }
        String sql =
                "SELECT " + select + " FROM " + SameDbCopyStrategy.qName(t.sourceSchema(), t.sourceTable())
                        + " s JOIN #archive_keys k ON s." + q(t.keyColumn()) + " = k." + q(t.keyColumn());
        try (PreparedStatement ps = src.prepareStatement(sql)) {
            ctx.stop().register(ps);
            try (ResultSet rs = ps.executeQuery();
                    SQLServerBulkCopy bulk = new SQLServerBulkCopy(tgt)) {
                SQLServerBulkCopyOptions opts = new SQLServerBulkCopyOptions();
                opts.setBatchSize(BULK_BATCH_ROWS);
                opts.setBulkCopyTimeout(0);
                bulk.setBulkCopyOptions(opts);
                bulk.setDestinationTableName(tgtName);
                for (String c : dataColumns) {
                    bulk.addColumnMapping(c, c);
                }
                for (String c : lineageColumns) {
                    bulk.addColumnMapping(c, c);
                }
                bulk.writeToServer(rs);
            } finally {
                ctx.stop().clear(ps);
            }
        }
    }

    private long countJoined(
            Connection conn, MoveContext ctx, TableConfig t, String tableName, boolean target, boolean byBatch)
            throws SQLException {
        String sql =
                "SELECT COUNT_BIG(*) FROM " + tableName + " x JOIN #archive_keys k ON x." + q(t.keyColumn())
                        + " = k." + q(t.keyColumn())
                        + (target && byBatch ? " WHERE x." + q("archive_batch_id") + " = ?" : "");
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (target && byBatch) {
                ps.setLong(1, ctx.runId());
            }
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getLong(1) : 0L;
            }
        }
    }

    private Long checksum(
            Connection conn,
            MoveContext ctx,
            TableConfig t,
            List<String> dataColumns,
            String tableName,
            boolean target,
            boolean byBatch)
            throws SQLException {
        StringBuilder cols = new StringBuilder();
        for (String c : dataColumns) {
            if (cols.length() > 0) {
                cols.append(", ");
            }
            cols.append("x.").append(q(c));
        }
        boolean filterByBatch = target && byBatch;
        String sql =
                "SELECT CHECKSUM_AGG(CHECKSUM(" + cols + ")) FROM " + tableName + " x JOIN #archive_keys k ON x."
                        + q(t.keyColumn()) + " = k." + q(t.keyColumn())
                        + (filterByBatch ? " WHERE x." + q("archive_batch_id") + " = ?" : "");
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (filterByBatch) {
                ps.setLong(1, ctx.runId());
            }
            try (ResultSet rs = ps.executeQuery()) {
                long v = rs.next() ? rs.getLong(1) : 0L;
                return rs.wasNull() ? Long.valueOf(0L) : v;
            }
        }
    }

    private long deleteSource(Connection src, MoveContext ctx, TableConfig t, String srcName) throws SQLException {
        String sql =
                "DELETE s FROM " + srcName + " s JOIN #archive_keys k ON s." + q(t.keyColumn()) + " = k."
                        + q(t.keyColumn());
        try (PreparedStatement ps = src.prepareStatement(sql)) {
            ctx.stop().register(ps);
            try {
                return ps.executeUpdate();
            } finally {
                ctx.stop().clear(ps);
            }
        }
    }

    private void markCopied(MoveContext ctx, long rowsCopied, Long sourceChecksum, Long targetChecksum) {
        int updated =
                controlJdbc.update(
                        "UPDATE archive_chunk_log SET state = 'COPIED', rows_copied = ?, source_checksum = ?,"
                                + " target_checksum = ?, updated_at_utc = SYSUTCDATETIME()"
                                + " WHERE run_id = ? AND chunk_no = ? AND source_table = ?",
                        rowsCopied,
                        sourceChecksum,
                        targetChecksum,
                        ctx.runId(),
                        ctx.chunkNo(),
                        ctx.table().sourceName());
        if (updated == 0) {
            controlJdbc.update(
                    "INSERT INTO archive_chunk_log (run_id, chunk_no, source_table, state, rows_copied,"
                            + " source_checksum, target_checksum) VALUES (?, ?, ?, 'COPIED', ?, ?, ?)",
                    ctx.runId(),
                    ctx.chunkNo(),
                    ctx.table().sourceName(),
                    rowsCopied,
                    sourceChecksum,
                    targetChecksum);
        }
    }

    private long readRowsCopied(MoveContext ctx) {
        Long rows =
                controlJdbc.query(
                        "SELECT rows_copied FROM archive_chunk_log WHERE run_id = ? AND chunk_no = ? AND source_table = ?",
                        rs -> rs.next() ? (Long) rs.getLong("rows_copied") : 0L,
                        ctx.runId(),
                        ctx.chunkNo(),
                        ctx.table().sourceName());
        return rows == null ? 0L : rows;
    }

    private static void append(StringBuilder sb, String token) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(token);
    }

    private static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }
}
