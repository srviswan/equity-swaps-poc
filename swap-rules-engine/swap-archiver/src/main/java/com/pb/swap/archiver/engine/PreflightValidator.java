package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.auth.ConnectionFactory;
import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Fail-fast checks before any data is touched: connectivity (which also exercises the configured
 * Kerberos ticket / SQL credential), server identity + recovery model, transaction-log visibility,
 * key permissions, and source↔target schema consistency for the configured tables. Warnings are
 * tolerated; any FAIL stops the run.
 */
@Component
public class PreflightValidator {

    private static final Logger log = LoggerFactory.getLogger(PreflightValidator.class);

    private final ConnectionFactory connections;
    private final ArchiverProperties props;
    private final JdbcTemplate controlJdbc;

    public PreflightValidator(
            ConnectionFactory connections, ArchiverProperties props, JdbcTemplate controlJdbc) {
        this.connections = connections;
        this.props = props;
        this.controlJdbc = controlJdbc;
    }

    public PreflightReport validate() {
        PreflightReport report = new PreflightReport();
        checkControl(report);
        List<Map<String, Object>> tables = loadTableConfig(report);

        Connection source = checkEndpoint(report, "source", props.source());
        Connection target = checkEndpoint(report, "target", props.target());
        try {
            checkTablePermissions(report, source, target, tables);
            checkSchemaConsistency(report, source, target, tables);
        } finally {
            close(source);
            close(target);
        }
        return report;
    }

    private void checkControl(PreflightReport report) {
        try {
            String db = controlJdbc.queryForObject("SELECT DB_NAME()", String.class);
            report.pass("control.connectivity", "connected to control DB '" + db + "'");
        } catch (RuntimeException e) {
            report.fail("control.connectivity", err(e));
        }
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> loadTableConfig(PreflightReport report) {
        try {
            List<Map<String, Object>> rows =
                    controlJdbc.queryForList(
                            "SELECT source_schema, source_table, target_schema, target_table "
                                    + "FROM archive_table WHERE job_name = ? AND enabled = 1",
                            props.jobName());
            report.pass("control.config", rows.size() + " table(s) configured for job " + props.jobName());
            return rows;
        } catch (RuntimeException e) {
            report.warn("control.config", "no archive_table config readable yet: " + err(e));
            return (List<Map<String, Object>>) (List<?>) Collections.emptyList();
        }
    }

    /** Endpoint-level checks; returns the open connection (reused for table checks) or null. */
    private Connection checkEndpoint(PreflightReport report, String label, Endpoint endpoint) {
        if (endpoint == null || endpoint.url() == null) {
            report.warn(label + ".connectivity", "endpoint not configured; skipped");
            return null;
        }
        Connection conn;
        try {
            conn = connections.open(endpoint);
        } catch (SQLException | RuntimeException e) {
            report.fail(label + ".connectivity", "auth=" + endpoint.auth() + " failed: " + err(e));
            return null;
        }
        try {
            String db = connections.scalar(conn, "SELECT DB_NAME()");
            String login = connections.scalar(conn, "SELECT SUSER_SNAME()");
            report.pass(label + ".connectivity", "auth=" + endpoint.auth() + " db=" + db + " login=" + login);

            String recovery =
                    connections.scalar(conn, "SELECT CAST(DATABASEPROPERTYEX(DB_NAME(),'Recovery') AS varchar(20))");
            report.pass(label + ".recovery_model", String.valueOf(recovery));

            try {
                String pct =
                        connections.scalar(
                                conn,
                                "SELECT CAST(used_log_space_in_percent AS varchar(10)) FROM sys.dm_db_log_space_usage");
                report.pass(label + ".log_space", "used_log_space_in_percent=" + pct);
            } catch (SQLException e) {
                report.warn(
                        label + ".log_space",
                        "cannot read sys.dm_db_log_space_usage (needs VIEW SERVER STATE): " + err(e));
            }

            String hasViewState =
                    connections.scalar(conn, "SELECT HAS_PERMS_BY_NAME(NULL, NULL, 'VIEW SERVER STATE')");
            if ("1".equals(hasViewState)) {
                report.pass(label + ".perm.view_server_state", "granted");
            } else {
                report.warn(
                        label + ".perm.view_server_state",
                        "missing; adaptive log/AG throttling will degrade to fixed pacing");
            }
        } catch (SQLException e) {
            report.fail(label + ".identity", err(e));
        }
        return conn;
    }

    private void checkTablePermissions(
            PreflightReport report, Connection source, Connection target, List<Map<String, Object>> tables) {
        if (tables.isEmpty()) {
            report.warn("perm.tables", "no configured tables to check");
            return;
        }
        for (Map<String, Object> t : tables) {
            String src = t.get("source_schema") + "." + t.get("source_table");
            String tgt = t.get("target_schema") + "." + t.get("target_table");
            checkObjectPerm(report, source, "source", src, "SELECT");
            checkObjectPerm(report, source, "source", src, "DELETE");
            checkObjectPerm(report, target, "target", tgt, "INSERT");
            checkObjectPerm(report, target, "target", tgt, "ALTER");
        }
    }

    private void checkObjectPerm(
            PreflightReport report, Connection conn, String label, String object, String perm) {
        if (conn == null) {
            return;
        }
        String name = label + ".perm." + perm + "(" + object + ")";
        try {
            String granted =
                    connections.scalar(
                            conn, "SELECT HAS_PERMS_BY_NAME('" + object + "', 'OBJECT', '" + perm + "')");
            if ("1".equals(granted)) {
                report.pass(name, "granted");
            } else if (granted == null) {
                report.warn(name, "object not found yet (will be created/needed before run)");
            } else {
                report.fail(name, "missing");
            }
        } catch (SQLException e) {
            report.warn(name, err(e));
        }
    }

    private void checkSchemaConsistency(
            PreflightReport report, Connection source, Connection target, List<Map<String, Object>> tables) {
        if (source == null || target == null || tables.isEmpty()) {
            return;
        }
        for (Map<String, Object> t : tables) {
            String sSchema = String.valueOf(t.get("source_schema"));
            String sTable = String.valueOf(t.get("source_table"));
            String tSchema = String.valueOf(t.get("target_schema"));
            String tTable = String.valueOf(t.get("target_table"));
            String name = "schema(" + sSchema + "." + sTable + ")";
            try {
                Set<String> sCols = columns(source, sSchema, sTable);
                Set<String> tCols = columns(target, tSchema, tTable);
                if (tCols.isEmpty()) {
                    report.warn(name, "target table missing; engine would auto-create it");
                    continue;
                }
                Set<String> missingInTarget = new TreeSet<>(sCols);
                missingInTarget.removeAll(tCols);
                if (missingInTarget.isEmpty()) {
                    report.pass(name, sCols.size() + " columns aligned");
                } else {
                    report.warn(
                            name,
                            "additive evolution needed; add to target: " + missingInTarget);
                }
            } catch (SQLException e) {
                report.warn(name, err(e));
            }
        }
    }

    private Set<String> columns(Connection conn, String schema, String table) throws SQLException {
        Set<String> cols = new LinkedHashSet<>();
        String sql =
                "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '"
                        + schema
                        + "' AND TABLE_NAME = '"
                        + table
                        + "'";
        try (var st = conn.createStatement();
                var rs = st.executeQuery(sql)) {
            while (rs.next()) {
                cols.add(rs.getString(1).toLowerCase());
            }
        }
        return cols;
    }

    private void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.debug("error closing connection", e);
            }
        }
    }

    private static String err(Throwable e) {
        return e.getClass().getSimpleName() + ": " + e.getMessage();
    }
}
