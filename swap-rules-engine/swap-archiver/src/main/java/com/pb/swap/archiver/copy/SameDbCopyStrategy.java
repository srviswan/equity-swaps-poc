package com.pb.swap.archiver.copy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Same database: the archive table lives in the source DB. Copy + delete run as one local
 * transaction ({@code INSERT…SELECT} then {@code DELETE}), so a crash rolls back atomically and
 * restart simply re-runs the chunk.
 *
 * <p>The chunk's basket keys are staged into an indexed {@code #archive_keys} temp table; both the
 * insert and the delete seek the source via {@code JOIN #archive_keys} — no scan, no giant IN-list.
 *
 * <p>Note: in the source's FULL recovery + AG, this logs and ships <em>both</em> the copy and the
 * delete (~2× volume). Prefer a non-AG archive DB (CROSS_DB/CROSS_SERVER) for steady state.
 */
@Component
public class SameDbCopyStrategy implements CopyStrategy {

    private static final Logger log = LoggerFactory.getLogger(SameDbCopyStrategy.class);

    /** Engine-owned lineage columns; populated only when present on the target table. */
    private static final List<String> LINEAGE =
            List.of("archive_batch_id", "archived_at_utc", "archived_period_key");

    @Override
    public String topology() {
        return "SAME_DB";
    }

    /**
     * Database that qualifies the <em>target</em> table name. {@code null} for SAME_DB (target lives
     * in the connected DB); CROSS_DB overrides this to emit {@code [db].[schema].[table]} 3-part
     * names against the same instance.
     */
    protected String targetDatabase(MoveContext ctx) {
        return null;
    }

    @Override
    public MoveResult move(MoveContext ctx) throws SQLException {
        TableConfig t = ctx.table();
        String targetDb = targetDatabase(ctx);
        Connection conn = ctx.connections().open(ctx.props().source());
        boolean committed = false;
        try {
            conn.setAutoCommit(false);

            Set<String> srcCols = columns(conn, null, t.sourceSchema(), t.sourceTable());
            Set<String> tgtCols = columns(conn, targetDb, t.targetSchema(), t.targetTable());
            if (!containsIgnoreCase(srcCols, t.keyColumn())) {
                throw new SQLException("key column '" + t.keyColumn() + "' not found on " + t.sourceName());
            }
            List<String> dataColumns = dataColumns(srcCols, tgtCols);
            if (dataColumns.isEmpty()) {
                throw new SQLException("no shared data columns between " + t.sourceName() + " and " + t.targetName());
            }
            List<String> lineageColumns = lineageColumns(srcCols, tgtCols);

            stageKeys(conn, ctx, t.keyColumn());

            long rowsCopied = insertSelect(conn, ctx, t, targetDb, dataColumns, lineageColumns);

            // Content verification BEFORE the delete: a column-aware CHECKSUM_AGG over the source
            // slice must equal the just-inserted target slice, so we never delete an imperfect copy.
            // Skipped when nothing was copied (rowsCopied==0): a restart re-running an already-moved
            // chunk finds no source rows, and one local transaction keeps source/target disjoint.
            boolean hasBatchLineage = lineageColumns.contains("archive_batch_id");
            Long sourceChecksum = null;
            Long targetChecksum = null;
            if (t.checksumVerify() && rowsCopied > 0) {
                sourceChecksum = checksum(conn, ctx, t, null, dataColumns, false, hasBatchLineage);
                targetChecksum = checksum(conn, ctx, t, targetDb, dataColumns, true, hasBatchLineage);
                if (!java.util.Objects.equals(sourceChecksum, targetChecksum)) {
                    throw new SQLException(
                            "checksum mismatch on " + t.sourceName() + ": source=" + sourceChecksum
                                    + " target=" + targetChecksum + " (delete blocked)");
                }
            }

            long rowsDeleted = deleteSource(conn, ctx, t);
            if (rowsCopied != rowsDeleted) {
                throw new SQLException(
                        "row mismatch on " + t.sourceName() + ": copied=" + rowsCopied + " deleted=" + rowsDeleted);
            }

            conn.commit();
            committed = true;
            log.debug(
                    "SAME_DB chunk {} table {} moved {} rows", ctx.chunkNo(), t.sourceName(), rowsCopied);
            return new MoveResult(rowsCopied, rowsDeleted, sourceChecksum, targetChecksum);
        } catch (SQLException | RuntimeException e) {
            safeRollback(conn);
            throw e;
        } finally {
            close(conn);
        }
    }

    /** Stage the chunk's basket keys into an indexed temp table for seekable joins. */
    private void stageKeys(Connection conn, MoveContext ctx, String keyColumn) throws SQLException {
        String keyType = columnTypeDdl(conn, ctx.table().sourceSchema(), ctx.table().sourceTable(), keyColumn);
        try (Statement st = conn.createStatement()) {
            st.execute("IF OBJECT_ID('tempdb..#archive_keys') IS NOT NULL DROP TABLE #archive_keys");
            st.execute(
                    "CREATE TABLE #archive_keys (" + q(keyColumn) + " " + keyType + " NOT NULL PRIMARY KEY)");
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

    private long insertSelect(
            Connection conn,
            MoveContext ctx,
            TableConfig t,
            String targetDb,
            List<String> dataColumns,
            List<String> lineageColumns)
            throws SQLException {
        StringBuilder cols = new StringBuilder();
        StringBuilder exprs = new StringBuilder();
        List<Object> binds = new ArrayList<>();
        for (String c : dataColumns) {
            append(cols, q(c));
            append(exprs, "s." + q(c));
        }
        for (String c : lineageColumns) {
            append(cols, q(c));
            switch (c.toLowerCase(Locale.ROOT)) {
                case "archived_at_utc" -> append(exprs, "SYSUTCDATETIME()");
                case "archive_batch_id" -> {
                    append(exprs, "?");
                    binds.add(ctx.runId());
                }
                case "archived_period_key" -> {
                    append(exprs, "?");
                    binds.add(ctx.archivedPeriodKey());
                }
                default -> append(exprs, "NULL");
            }
        }
        String sql =
                "INSERT INTO " + qName(targetDb, t.targetSchema(), t.targetTable()) + " (" + cols + ") SELECT " + exprs
                        + " FROM " + qName(t.sourceSchema(), t.sourceTable()) + " s "
                        + "JOIN #archive_keys k ON s." + q(t.keyColumn()) + " = k." + q(t.keyColumn());
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < binds.size(); i++) {
                ps.setObject(i + 1, binds.get(i));
            }
            return runCancellable(ctx, ps);
        }
    }

    /**
     * Order-independent content hash of the chunk's data columns. {@code CHECKSUM_AGG(CHECKSUM(...))}
     * over either the source slice (joined to the staged keys) or the just-inserted target slice
     * (this run's lineage), so the two are comparable before the source rows are deleted.
     */
    private Long checksum(
            Connection conn,
            MoveContext ctx,
            TableConfig t,
            String targetDb,
            List<String> dataColumns,
            boolean target,
            boolean hasBatchLineage)
            throws SQLException {
        StringBuilder cols = new StringBuilder();
        for (String c : dataColumns) {
            if (cols.length() > 0) {
                cols.append(", ");
            }
            cols.append("x.").append(q(c));
        }
        String tableName =
                target ? qName(targetDb, t.targetSchema(), t.targetTable()) : qName(t.sourceSchema(), t.sourceTable());
        boolean filterByBatch = target && hasBatchLineage;
        String sql =
                "SELECT CHECKSUM_AGG(CHECKSUM(" + cols + ")) FROM " + tableName + " x JOIN #archive_keys k ON x."
                        + q(t.keyColumn()) + " = k." + q(t.keyColumn())
                        + (filterByBatch ? " WHERE x." + q("archive_batch_id") + " = ?" : "");
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (filterByBatch) {
                ps.setLong(1, ctx.runId());
            }
            ctx.stop().register(ps);
            try (ResultSet rs = ps.executeQuery()) {
                long v = rs.next() ? rs.getLong(1) : 0L;
                return rs.wasNull() ? Long.valueOf(0L) : v;
            } finally {
                ctx.stop().clear(ps);
            }
        }
    }

    private long deleteSource(Connection conn, MoveContext ctx, TableConfig t) throws SQLException {
        String sql =
                "DELETE s FROM " + qName(t.sourceSchema(), t.sourceTable()) + " s "
                        + "JOIN #archive_keys k ON s." + q(t.keyColumn()) + " = k." + q(t.keyColumn());
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            return runCancellable(ctx, ps);
        }
    }

    /** Execute an update, registering the statement so break-glass can cancel it mid-flight. */
    private long runCancellable(MoveContext ctx, PreparedStatement ps) throws SQLException {
        ctx.stop().register(ps);
        try {
            return ps.executeUpdate();
        } finally {
            ctx.stop().clear(ps);
        }
    }

    static List<String> dataColumns(Set<String> srcCols, Set<String> tgtCols) {
        Set<String> tgtLower = lower(tgtCols);
        List<String> out = new ArrayList<>();
        for (String c : srcCols) {
            String lc = c.toLowerCase(Locale.ROOT);
            if (tgtLower.contains(lc) && !LINEAGE.contains(lc)) {
                out.add(c);
            }
        }
        return out;
    }

    static List<String> lineageColumns(Set<String> srcCols, Set<String> tgtCols) {
        Set<String> srcLower = lower(srcCols);
        Set<String> tgtLower = lower(tgtCols);
        List<String> out = new ArrayList<>();
        for (String c : LINEAGE) {
            if (tgtLower.contains(c) && !srcLower.contains(c)) {
                out.add(c);
            }
        }
        return out;
    }

    /** Columns of a table; {@code db} qualifies {@code INFORMATION_SCHEMA} for cross-DB lookups. */
    static Set<String> columns(Connection conn, String db, String schema, String table) throws SQLException {
        Set<String> cols = new LinkedHashSet<>();
        String infoSchema = (db == null ? "" : q(db) + ".") + "INFORMATION_SCHEMA.COLUMNS";
        String sql =
                "SELECT COLUMN_NAME FROM " + infoSchema
                        + " WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ? ORDER BY ORDINAL_POSITION";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            ps.setString(2, table);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cols.add(rs.getString(1));
                }
            }
        }
        return cols;
    }

    /** Build a DDL type string for one column so the staged temp key matches the source type. */
    static String columnTypeDdl(Connection conn, String schema, String table, String column)
            throws SQLException {
        String sql =
                "SELECT DATA_TYPE, CHARACTER_MAXIMUM_LENGTH, NUMERIC_PRECISION, NUMERIC_SCALE "
                        + "FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ? AND COLUMN_NAME = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            ps.setString(2, table);
            ps.setString(3, column);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    throw new SQLException("column metadata not found for " + schema + "." + table + "." + column);
                }
                String type = rs.getString("DATA_TYPE").toLowerCase(Locale.ROOT);
                return switch (type) {
                    case "char", "varchar", "nchar", "nvarchar", "binary", "varbinary" -> {
                        int len = rs.getInt("CHARACTER_MAXIMUM_LENGTH");
                        yield type + "(" + (len == -1 ? "max" : len) + ")";
                    }
                    case "decimal", "numeric" ->
                            type + "(" + rs.getInt("NUMERIC_PRECISION") + "," + rs.getInt("NUMERIC_SCALE") + ")";
                    default -> type;
                };
            }
        }
    }

    private static Set<String> lower(Set<String> in) {
        Set<String> out = new LinkedHashSet<>();
        for (String s : in) {
            out.add(s.toLowerCase(Locale.ROOT));
        }
        return out;
    }

    private static boolean containsIgnoreCase(Set<String> cols, String name) {
        return lower(cols).contains(name.toLowerCase(Locale.ROOT));
    }

    private static void append(StringBuilder sb, String token) {
        if (sb.length() > 0) {
            sb.append(", ");
        }
        sb.append(token);
    }

    static String qName(String schema, String table) {
        return q(schema) + "." + q(table);
    }

    /** Two- or three-part quoted name; {@code db} non-null emits {@code [db].[schema].[table]}. */
    static String qName(String db, String schema, String table) {
        return (db == null ? "" : q(db) + ".") + q(schema) + "." + q(table);
    }

    static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }

    private static void safeRollback(Connection conn) {
        try {
            if (conn != null && !conn.getAutoCommit()) {
                conn.rollback();
            }
        } catch (SQLException e) {
            log.debug("rollback failed", e);
        }
    }

    private static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.debug("close failed", e);
        }
    }
}
