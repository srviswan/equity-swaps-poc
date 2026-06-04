package com.pb.swap.archiver.copy;

import com.pb.swap.archiver.copy.CopyStrategy.TableConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Per-chunk key-set staging and join construction, shared by every {@link CopyStrategy}. The chunk's
 * eligible basket keys are turned into the set of rows each table must move, and an indexed temp
 * table ({@code #archive_keys}) is staged so the (possibly 1 TB) fact joins by seek, never a scan.
 *
 * <ul>
 *   <li><b>DIRECT</b> — the fact carries the basket key in one column (any name). The basket keys are
 *       staged into {@code #archive_keys(k0 BIGINT)} and the fact joins {@code fact.[joinCol]=k0}.
 *   <li><b>BRIDGE</b> — the fact is keyed by something else (e.g. {@code swap_key}); eligible baskets
 *       are resolved <em>on the source</em> to this fact's key tuples through the bridge table
 *       ({@code DISTINCT}), staged into {@code #archive_keys(k0..kn)}, and the fact joins on its own
 *       {@code joinColumns}.
 * </ul>
 *
 * <p>{@link #resolveOnSource} must run before {@link #stage}; for cross-server moves the same staged
 * tuples are written to both the source and target connections.
 */
final class ChunkKeys {

    private static final String KEYS = "#archive_keys";

    private final TableConfig table;
    private final List<Long> baskets;
    private List<String> keyTypes;
    private List<Object[]> rows;

    ChunkKeys(TableConfig table, List<Long> baskets) {
        this.table = table;
        this.baskets = baskets;
    }

    /** Build the row set: identity (DIRECT) or bridge-resolved tuples queried on {@code src}. */
    void resolveOnSource(Connection src) throws SQLException {
        if (!table.isBridge()) {
            keyTypes = List.of("BIGINT");
            rows = new ArrayList<>(baskets.size());
            for (Long b : baskets) {
                rows.add(new Object[] {b});
            }
            return;
        }
        String[] parts = table.bridgeTable().split("\\.", 2);
        String bSchema = parts.length == 2 ? parts[0] : "dbo";
        String bTable = parts.length == 2 ? parts[1] : parts[0];
        List<String> bridgeCols = table.bridgeJoinColumns();
        keyTypes = new ArrayList<>(bridgeCols.size());
        for (String c : bridgeCols) {
            keyTypes.add(SameDbCopyStrategy.columnTypeDdl(src, bSchema, bTable, c));
        }
        stageBaskets(src);
        StringBuilder select = new StringBuilder();
        for (String c : bridgeCols) {
            if (select.length() > 0) {
                select.append(", ");
            }
            select.append("b.").append(q(c));
        }
        String sql =
                "SELECT DISTINCT " + select + " FROM " + q(bSchema) + "." + q(bTable) + " b"
                        + " JOIN #bk z ON b." + q(table.bridgeBasketColumn()) + " = z.basket_key";
        rows = new ArrayList<>();
        try (Statement st = src.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Object[] tuple = new Object[bridgeCols.size()];
                for (int i = 0; i < tuple.length; i++) {
                    tuple[i] = rs.getObject(i + 1);
                }
                rows.add(tuple);
            }
        }
        try (Statement st = src.createStatement()) {
            st.execute("DROP TABLE #bk");
        }
    }

    /** Stage {@code #archive_keys} on a connection from the resolved rows. */
    void stage(Connection conn) throws SQLException {
        StringBuilder ddl = new StringBuilder();
        StringBuilder pk = new StringBuilder();
        StringBuilder cols = new StringBuilder();
        StringBuilder qs = new StringBuilder();
        for (int i = 0; i < keyTypes.size(); i++) {
            if (i > 0) {
                ddl.append(", ");
                pk.append(", ");
                cols.append(", ");
                qs.append(", ");
            }
            ddl.append("k").append(i).append(" ").append(keyTypes.get(i)).append(" NOT NULL");
            pk.append("k").append(i);
            cols.append("k").append(i);
            qs.append("?");
        }
        try (Statement st = conn.createStatement()) {
            st.execute("IF OBJECT_ID('tempdb.." + KEYS + "') IS NOT NULL DROP TABLE " + KEYS);
            st.execute("CREATE TABLE " + KEYS + " (" + ddl + ", PRIMARY KEY (" + pk + "))");
        }
        try (PreparedStatement ps =
                conn.prepareStatement("INSERT INTO " + KEYS + " (" + cols + ") VALUES (" + qs + ")")) {
            for (Object[] tuple : rows) {
                for (int i = 0; i < tuple.length; i++) {
                    ps.setObject(i + 1, tuple[i]);
                }
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    /** {@code " JOIN #archive_keys kz ON alias.[fc0]=kz.[k0] AND ..."} */
    String joinClause(String factAlias) {
        List<String> factCols = table.joinColumns();
        StringBuilder on = new StringBuilder();
        for (int i = 0; i < factCols.size(); i++) {
            if (on.length() > 0) {
                on.append(" AND ");
            }
            on.append(factAlias).append(".").append(q(factCols.get(i))).append(" = kz.").append(q("k" + i));
        }
        return " JOIN " + KEYS + " kz ON " + on;
    }

    private void stageBaskets(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("IF OBJECT_ID('tempdb..#bk') IS NOT NULL DROP TABLE #bk");
            st.execute("CREATE TABLE #bk (basket_key BIGINT NOT NULL PRIMARY KEY)");
        }
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO #bk (basket_key) VALUES (?)")) {
            for (Long b : baskets) {
                ps.setLong(1, b);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private static String q(String identifier) {
        return "[" + identifier.replace("]", "]]") + "]";
    }
}
