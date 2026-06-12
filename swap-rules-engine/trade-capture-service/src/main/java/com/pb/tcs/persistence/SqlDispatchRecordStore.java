package com.pb.tcs.persistence;

import com.pb.tcs.dispatch.DispatchRecord;
import com.pb.tcs.dispatch.DispatchRecordStore;
import com.pb.tcs.dispatch.DispatchStatus;
import com.pb.tcs.dispatch.DispatchStatus;
import com.pb.tcs.ingress.IngestionStoreException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;

/** JDBC adapter over {@code dispatch_record} (V001 + V005). */
public final class SqlDispatchRecordStore implements DispatchRecordStore {

    private final DataSource dataSource;

    public SqlDispatchRecordStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createPending(UUID ingestionId, String correlationId, List<String> destinationIds) {
        String sql =
                "INSERT INTO dbo.dispatch_record (ingestion_id, correlation_id, destination_id, status)"
                        + " VALUES (?,?,?,'PENDING')";
        try (Connection conn = dataSource.getConnection()) {
            for (String dest : destinationIds) {
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, ingestionId.toString());
                    ps.setString(2, correlationId);
                    ps.setString(3, dest);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    if (e.getMessage() != null && e.getMessage().contains("uq_dispatch")) {
                        continue;
                    }
                    throw wrap("dispatch create failed", e);
                }
            }
        } catch (SQLException e) {
            throw wrap("dispatch create connection failure", e);
        }
    }

    @Override
    public List<DispatchRecord> claimBatch(int limit, Instant now) {
        String sql =
                """
                ;WITH to_claim AS (
                  SELECT TOP (%d) dispatch_id FROM dbo.dispatch_record
                  WHERE status = 'PENDING' AND next_attempt_at <= ?
                  ORDER BY dispatch_id
                )
                UPDATE dr SET status = 'CLAIMED'
                OUTPUT INSERTED.dispatch_id, INSERTED.ingestion_id, INSERTED.correlation_id,
                       INSERTED.destination_id, INSERTED.status, INSERTED.attempt_count,
                       INSERTED.next_attempt_at, INSERTED.last_error, INSERTED.envelope_hash,
                       INSERTED.sent_at
                FROM dbo.dispatch_record dr
                INNER JOIN to_claim c ON dr.dispatch_id = c.dispatch_id
                """
                        .formatted(Math.max(1, limit));
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.from(now));
            try (ResultSet rs = ps.executeQuery()) {
                List<DispatchRecord> claimed = new ArrayList<>();
                while (rs.next()) {
                    claimed.add(row(rs));
                }
                return claimed;
            }
        } catch (SQLException e) {
            throw wrap("dispatch claim failed", e);
        }
    }

    @Override
    public void markSent(long dispatchId, String envelopeHash, Instant sentAt) {
        String sql =
                "UPDATE dbo.dispatch_record SET status='SENT', envelope_hash=?, sent_at=?"
                        + " WHERE dispatch_id=? AND status='CLAIMED'";
        update(sql, ps -> {
            ps.setString(1, envelopeHash);
            ps.setTimestamp(2, Timestamp.from(sentAt));
            ps.setLong(3, dispatchId);
        }, dispatchId);
    }

    @Override
    public void scheduleRetry(long dispatchId, int attemptCount, Instant nextAttemptAt, String lastError) {
        String sql =
                "UPDATE dbo.dispatch_record SET status='PENDING', attempt_count=?,"
                        + " next_attempt_at=?, last_error=? WHERE dispatch_id=? AND status='CLAIMED'";
        update(sql, ps -> {
            ps.setInt(1, attemptCount);
            ps.setTimestamp(2, Timestamp.from(nextAttemptAt));
            ps.setString(3, lastError);
            ps.setLong(4, dispatchId);
        }, dispatchId);
    }

    @Override
    public void markFailed(long dispatchId, String lastError) {
        String sql =
                "UPDATE dbo.dispatch_record SET status='FAILED', last_error=?"
                        + " WHERE dispatch_id=? AND status IN ('CLAIMED','SENT')";
        update(sql, ps -> {
            ps.setString(1, lastError);
            ps.setLong(2, dispatchId);
        }, dispatchId);
    }

    @Override
    public List<DispatchRecord> findByCorrelationId(String correlationId) {
        String sql =
                "SELECT dispatch_id, ingestion_id, correlation_id, destination_id, status,"
                        + " attempt_count, next_attempt_at, last_error, envelope_hash, sent_at"
                        + " FROM dbo.dispatch_record WHERE correlation_id=? ORDER BY destination_id";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correlationId);
            try (ResultSet rs = ps.executeQuery()) {
                List<DispatchRecord> rows = new ArrayList<>();
                while (rs.next()) {
                    rows.add(row(rs));
                }
                return rows;
            }
        } catch (SQLException e) {
            throw wrap("dispatch lookup failed", e);
        }
    }

    @Override
    public Optional<DispatchRecord> findByDestination(String correlationId, String destinationId) {
        return findByCorrelationId(correlationId).stream()
                .filter(r -> r.destinationId().equals(destinationId))
                .findFirst();
    }

    private static DispatchRecord row(ResultSet rs) throws SQLException {
        Timestamp next = rs.getTimestamp("next_attempt_at");
        Timestamp sent = rs.getTimestamp("sent_at");
        Object ingestionRaw = rs.getObject("ingestion_id");
        UUID ingestionId =
                ingestionRaw instanceof UUID u
                        ? u
                        : UUID.fromString(ingestionRaw.toString());
        return new DispatchRecord(
                rs.getLong("dispatch_id"),
                ingestionId,
                rs.getString("correlation_id"),
                rs.getString("destination_id"),
                DispatchStatus.valueOf(rs.getString("status")),
                rs.getInt("attempt_count"),
                next.toInstant(),
                rs.getString("last_error"),
                rs.getString("envelope_hash"),
                sent == null ? null : sent.toInstant());
    }

    private void update(String sql, SqlBinder binder, long dispatchId) {
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            binder.bind(ps);
            if (ps.executeUpdate() == 0) {
                throw new IngestionStoreException("dispatch update rejected for id " + dispatchId);
            }
        } catch (SQLException e) {
            throw wrap("dispatch update failed", e);
        }
    }

    @FunctionalInterface
    private interface SqlBinder {
        void bind(PreparedStatement ps) throws SQLException;
    }

    private static IngestionStoreException wrap(String message, SQLException e) {
        return new IngestionStoreException(message + ": " + e.getMessage(), e);
    }
}
