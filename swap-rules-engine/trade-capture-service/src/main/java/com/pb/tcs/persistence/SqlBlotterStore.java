package com.pb.tcs.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.rules.BlotterStore;
import com.pb.tcs.rules.RuleExplain;
import com.pb.tcs.rules.SwapBlotter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 * JDBC adapter over {@code swap_blotter} / {@code rule_explain} (DDL: V002). {@link #save} is one
 * transaction: the blotter row and every explain row commit together, so the FR-207 audit trail
 * can never lag the blotter it explains.
 */
public final class SqlBlotterStore implements BlotterStore {

    private static final String INSERT_BLOTTER =
            """
            INSERT INTO dbo.swap_blotter (
              correlation_id, block_id, allocation_id, version, allocation_type,
              book, account_id, security_id, trade_date, snapshot_version, blotter_json)
            VALUES (?,?,?,?,?,?,?,?,?,?,?)
            """;

    private static final String INSERT_EXPLAIN =
            """
            INSERT INTO dbo.rule_explain (
              correlation_id, trade_date, seq, rule_id, rule_version, category, target, narrative)
            VALUES (?,?,?,?,?,?,?,?)
            """;

    private static final ObjectMapper JSON =
            new ObjectMapper()
                    .registerModule(new JavaTimeModule())
                    .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    private final DataSource dataSource;

    public SqlBlotterStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(SwapBlotter blotter, List<RuleExplain> explains) {
        Date tradeDate = Date.valueOf(blotter.tradeDate());
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ps = conn.prepareStatement(INSERT_BLOTTER)) {
                    ps.setString(1, blotter.correlationId());
                    ps.setString(2, blotter.blockId());
                    ps.setString(3, blotter.allocationId());
                    ps.setInt(4, blotter.version());
                    ps.setString(5, blotter.allocationType());
                    ps.setString(6, blotter.book());
                    ps.setString(7, blotter.accountId());
                    ps.setString(8, blotter.securityId());
                    ps.setDate(9, tradeDate);
                    ps.setString(10, blotter.snapshotVersion());
                    ps.setString(11, toJson(blotter));
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conn.prepareStatement(INSERT_EXPLAIN)) {
                    for (RuleExplain e : explains) {
                        ps.setString(1, blotter.correlationId());
                        ps.setDate(2, tradeDate);
                        ps.setInt(3, e.seq());
                        ps.setString(4, e.ruleId());
                        ps.setInt(5, e.ruleVersion());
                        ps.setString(6, e.category());
                        ps.setString(7, e.target());
                        ps.setString(8, e.narrative());
                        ps.addBatch();
                    }
                    ps.executeBatch();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw wrap("blotter persist failed", e);
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw wrap("blotter persist connection failure", e);
        }
    }

    @Override
    public Optional<String> findBlotterJson(String correlationId) {
        String sql = "SELECT blotter_json FROM dbo.swap_blotter WHERE correlation_id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correlationId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(rs.getString(1)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw wrap("blotter lookup failed", e);
        }
    }

    @Override
    public List<RuleExplain> findExplains(String correlationId) {
        String sql =
                "SELECT seq, rule_id, rule_version, category, target, narrative"
                        + " FROM dbo.rule_explain WHERE correlation_id=? ORDER BY seq";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correlationId);
            try (ResultSet rs = ps.executeQuery()) {
                List<RuleExplain> explains = new ArrayList<>();
                while (rs.next()) {
                    explains.add(
                            new RuleExplain(
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getInt(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6)));
                }
                return explains;
            }
        } catch (SQLException e) {
            throw wrap("explain lookup failed", e);
        }
    }

    static String toJson(SwapBlotter blotter) {
        try {
            return JSON.writeValueAsString(blotter);
        } catch (JsonProcessingException e) {
            throw new IngestionStoreException("blotter serialization failed", e);
        }
    }

    private static IngestionStoreException wrap(String message, SQLException e) {
        return new IngestionStoreException(message + ": " + e.getMessage(), e);
    }
}
