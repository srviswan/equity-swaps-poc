package com.pb.tcs.persistence;

import com.pb.tcs.crossref.CrossRefRecord;
import com.pb.tcs.crossref.CrossRefStatus;
import com.pb.tcs.crossref.CrossRefStore;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.routing.EventTypeDeriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;

/** JDBC adapter over {@code cross_ref} (V001 + V006). */
public final class SqlCrossRefStore implements CrossRefStore {

    private final DataSource dataSource;

    public SqlCrossRefStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void upsertPending(CrossRefRecord record) {
        String merge =
                """
                MERGE dbo.cross_ref AS t
                USING (SELECT ? AS ingestion_id, ? AS from_system, ? AS to_system) AS s
                  ON t.ingestion_id = s.ingestion_id
                 AND t.from_system = s.from_system
                 AND t.to_system = s.to_system
                WHEN MATCHED THEN UPDATE SET
                  correlation_id = ?, swap_ref = ?, lot_refs = ?, event_type = ?,
                  status = 'PENDING', attempt_count = 0,
                  next_attempt_at = SYSUTCDATETIME(), last_error = NULL, delivered_at = NULL
                WHEN NOT MATCHED THEN INSERT (
                  ingestion_id, from_system, to_system, correlation_id, swap_ref, lot_refs,
                  event_type, status, attempt_count, next_attempt_at)
                VALUES (?, ?, ?, ?, ?, ?, ?, 'PENDING', 0, SYSUTCDATETIME());
                """;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(merge)) {
            ps.setString(1, record.ingestionId().toString());
            ps.setString(2, record.fromSystem());
            ps.setString(3, record.toSystem());
            ps.setString(4, record.correlationId());
            ps.setString(5, record.swapRef());
            ps.setString(6, record.lotRefsJson());
            ps.setString(7, eventTypeName(record.eventType()));
            ps.setString(8, record.ingestionId().toString());
            ps.setString(9, record.fromSystem());
            ps.setString(10, record.toSystem());
            ps.setString(11, record.correlationId());
            ps.setString(12, record.swapRef());
            ps.setString(13, record.lotRefsJson());
            ps.setString(14, eventTypeName(record.eventType()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("cross_ref upsert failed", e);
        }
    }

    @Override
    public List<CrossRefRecord> claimPending(int limit, Instant now) {
        String sql =
                """
                ;WITH to_claim AS (
                  SELECT TOP (%d) cross_ref_id FROM dbo.cross_ref
                  WHERE status = 'PENDING' AND next_attempt_at <= ?
                  ORDER BY cross_ref_id
                )
                UPDATE cr SET status = 'PENDING'
                OUTPUT INSERTED.cross_ref_id, INSERTED.ingestion_id, INSERTED.correlation_id,
                       INSERTED.from_system, INSERTED.to_system, INSERTED.swap_ref,
                       INSERTED.lot_refs, INSERTED.event_type, INSERTED.status,
                       INSERTED.attempt_count, INSERTED.next_attempt_at, INSERTED.last_error,
                       INSERTED.delivered_at
                FROM dbo.cross_ref cr
                INNER JOIN to_claim c ON cr.cross_ref_id = c.cross_ref_id
                """
                        .formatted(Math.max(1, limit));
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.from(now));
            try (ResultSet rs = ps.executeQuery()) {
                List<CrossRefRecord> rows = new ArrayList<>();
                while (rs.next()) {
                    rows.add(row(rs));
                }
                return rows;
            }
        } catch (SQLException e) {
            throw wrap("cross_ref claim failed", e);
        }
    }

    @Override
    public void markDelivered(long crossRefId, Instant deliveredAt) {
        updateStatus(
                crossRefId,
                "UPDATE dbo.cross_ref SET status='DELIVERED', delivered_at=?, last_error=NULL WHERE cross_ref_id=?",
                deliveredAt);
    }

    @Override
    public void scheduleRetry(long crossRefId, int attemptCount, Instant nextAttemptAt, String lastError) {
        String sql =
                "UPDATE dbo.cross_ref SET status='PENDING', attempt_count=?, next_attempt_at=?,"
                        + " last_error=? WHERE cross_ref_id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, attemptCount);
            ps.setTimestamp(2, Timestamp.from(nextAttemptAt));
            ps.setString(3, lastError);
            ps.setLong(4, crossRefId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("cross_ref retry schedule failed", e);
        }
    }

    @Override
    public void markFailed(long crossRefId, String lastError) {
        String sql = "UPDATE dbo.cross_ref SET status='FAILED', last_error=? WHERE cross_ref_id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, lastError);
            ps.setLong(2, crossRefId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("cross_ref mark failed", e);
        }
    }

    @Override
    public void resetToPending(long crossRefId) {
        String sql =
                "UPDATE dbo.cross_ref SET status='PENDING', attempt_count=0,"
                        + " next_attempt_at=SYSUTCDATETIME(), last_error=NULL, delivered_at=NULL"
                        + " WHERE cross_ref_id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, crossRefId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("cross_ref reset failed", e);
        }
    }

    @Override
    public List<CrossRefRecord> findByIngestionId(UUID ingestionId) {
        return queryInternal(null, null, null, null, ingestionId);
    }

    @Override
    public Optional<CrossRefRecord> findDirection(UUID ingestionId, String fromSystem, String toSystem) {
        List<CrossRefRecord> rows = queryInternal(null, null, fromSystem, toSystem, ingestionId);
        return rows.isEmpty() ? Optional.empty() : Optional.of(rows.get(0));
    }

    @Override
    public List<CrossRefRecord> query(CrossRefQuery query) {
        return queryInternal(query.allocationId(), query.swapRef(), query.fromSystem(), query.toSystem(), null);
    }

    private List<CrossRefRecord> queryInternal(
            String allocationId, String swapRef, String fromSystem, String toSystem, UUID ingestionId) {
        StringBuilder sql =
                new StringBuilder(
                        "SELECT cr.cross_ref_id, cr.ingestion_id, cr.correlation_id, cr.from_system,"
                                + " cr.to_system, cr.swap_ref, cr.lot_refs, cr.event_type, cr.status,"
                                + " cr.attempt_count, cr.next_attempt_at, cr.last_error, cr.delivered_at"
                                + " FROM dbo.cross_ref cr");
        List<Object> params = new ArrayList<>();
        if (allocationId != null && !allocationId.isBlank()) {
            sql.append(" INNER JOIN dbo.ingestion_record ir ON ir.ingestion_id = cr.ingestion_id");
        }
        sql.append(" WHERE 1=1");
        if (ingestionId != null) {
            sql.append(" AND cr.ingestion_id = ?");
            params.add(ingestionId.toString());
        }
        if (allocationId != null && !allocationId.isBlank()) {
            sql.append(" AND ir.allocation_id = ?");
            params.add(allocationId);
        }
        if (swapRef != null && !swapRef.isBlank()) {
            sql.append(" AND cr.swap_ref = ?");
            params.add(swapRef);
        }
        if (fromSystem != null && !fromSystem.isBlank()) {
            sql.append(" AND cr.from_system = ?");
            params.add(fromSystem);
        }
        if (toSystem != null && !toSystem.isBlank()) {
            sql.append(" AND cr.to_system = ?");
            params.add(toSystem);
        }
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            try (ResultSet rs = ps.executeQuery()) {
                List<CrossRefRecord> rows = new ArrayList<>();
                while (rs.next()) {
                    rows.add(row(rs));
                }
                return rows;
            }
        } catch (SQLException e) {
            throw wrap("cross_ref query failed", e);
        }
    }

    private void updateStatus(long crossRefId, String sql, Instant deliveredAt) {
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.from(deliveredAt));
            ps.setLong(2, crossRefId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("cross_ref status update failed", e);
        }
    }

    private static CrossRefRecord row(ResultSet rs) throws SQLException {
        Timestamp next = rs.getTimestamp("next_attempt_at");
        Timestamp delivered = rs.getTimestamp("delivered_at");
        Object ingestion = rs.getObject("ingestion_id");
        UUID ingestionId =
                ingestion instanceof UUID u ? u : UUID.fromString(ingestion.toString());
        return new CrossRefRecord(
                rs.getLong("cross_ref_id"),
                ingestionId,
                rs.getString("correlation_id"),
                rs.getString("from_system"),
                rs.getString("to_system"),
                rs.getString("swap_ref"),
                rs.getString("lot_refs"),
                parseEventType(rs.getString("event_type")),
                CrossRefStatus.valueOf(rs.getString("status")),
                rs.getInt("attempt_count"),
                next != null ? next.toInstant() : Instant.EPOCH,
                rs.getString("last_error"),
                delivered != null ? delivered.toInstant() : null);
    }

    private static EventTypeDeriver.EventType parseEventType(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return EventTypeDeriver.EventType.valueOf(value);
    }

    private static String eventTypeName(EventTypeDeriver.EventType eventType) {
        return eventType == null ? null : eventType.name();
    }

    private static IngestionStoreException wrap(String message, SQLException e) {
        return new IngestionStoreException(message + ": " + e.getMessage(), e);
    }
}
