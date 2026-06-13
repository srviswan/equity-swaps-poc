package com.pb.tcs.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.routing.EventTypeDeriver;
import com.pb.tcs.routing.RoutingDecision;
import com.pb.tcs.routing.RoutingDecisionStore;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 * JDBC adapter over {@code routing_decision} (DDL: V004). {@link #saveAll} commits a trade's
 * full fan-out set in one transaction — a partially-persisted routing outcome is never visible.
 */
public final class SqlRoutingDecisionStore implements RoutingDecisionStore {

    private static final String INSERT =
            """
            INSERT INTO dbo.routing_decision (
              correlation_id, trade_date, rule_name, target_id, queue,
              event_type, match_key, position_as_of)
            VALUES (?,?,?,?,?,?,?,?)
            """;

    private static final ObjectMapper JSON = new ObjectMapper();
    private static final TypeReference<LinkedHashMap<String, String>> KEY_SHAPE =
            new TypeReference<>() {};

    private final DataSource dataSource;

    public SqlRoutingDecisionStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void saveAll(List<RoutingDecision> decisions) {
        if (decisions.isEmpty()) {
            return;
        }
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
                for (RoutingDecision d : decisions) {
                    ps.setString(1, d.correlationId());
                    ps.setDate(2, Date.valueOf(d.tradeDate()));
                    ps.setString(3, d.ruleName());
                    ps.setString(4, d.targetId());
                    ps.setString(5, d.queue());
                    ps.setString(6, d.eventType().name());
                    ps.setString(7, d.matchKey().isEmpty() ? null : toJson(d.matchKey()));
                    if (d.positionAsOf() != null) {
                        ps.setTimestamp(8, Timestamp.from(d.positionAsOf()));
                    } else {
                        ps.setNull(8, java.sql.Types.TIMESTAMP);
                    }
                    ps.addBatch();
                }
                ps.executeBatch();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw wrap("routing persist failed", e);
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw wrap("routing persist connection failure", e);
        }
    }

    @Override
    public List<RoutingDecision> findByCorrelationId(String correlationId) {
        String sql =
                "SELECT correlation_id, trade_date, rule_name, target_id, queue, event_type,"
                        + " match_key, position_as_of FROM dbo.routing_decision"
                        + " WHERE correlation_id=? ORDER BY target_id";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correlationId);
            try (ResultSet rs = ps.executeQuery()) {
                List<RoutingDecision> decisions = new ArrayList<>();
                while (rs.next()) {
                    Timestamp asOf = rs.getTimestamp("position_as_of");
                    String matchKey = rs.getString("match_key");
                    decisions.add(
                            new RoutingDecision(
                                    rs.getString("correlation_id"),
                                    rs.getDate("trade_date").toLocalDate(),
                                    rs.getString("rule_name"),
                                    rs.getString("target_id"),
                                    rs.getString("queue"),
                                    EventTypeDeriver.EventType.valueOf(
                                            rs.getString("event_type")),
                                    matchKey == null ? Map.of() : fromJson(matchKey),
                                    asOf == null ? null : asOf.toInstant()));
                }
                return decisions;
            }
        } catch (SQLException e) {
            throw wrap("routing lookup failed", e);
        }
    }

    private static String toJson(Map<String, String> matchKey) {
        try {
            return JSON.writeValueAsString(matchKey);
        } catch (JsonProcessingException e) {
            throw new IngestionStoreException("match key serialization failed", e);
        }
    }

    private static Map<String, String> fromJson(String json) {
        try {
            return JSON.readValue(json, KEY_SHAPE);
        } catch (JsonProcessingException e) {
            throw new IngestionStoreException("match key deserialization failed", e);
        }
    }

    private static IngestionStoreException wrap(String message, SQLException e) {
        return new IngestionStoreException(message + ": " + e.getMessage(), e);
    }
}
