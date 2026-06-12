package com.pb.tcs.persistence;

import com.pb.tcs.dispatch.BusinessAckStore;
import com.pb.tcs.ingress.IngestionStoreException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;
import javax.sql.DataSource;

/** JDBC adapter over {@code business_ack} (V001 / D14). */
public final class SqlBusinessAckStore implements BusinessAckStore {

    private final DataSource dataSource;

    public SqlBusinessAckStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(BusinessAckRecord ack) {
        String sql =
                """
                INSERT INTO dbo.business_ack (
                  dispatch_id, system_id, status, swap_ref, lot_refs,
                  reject_reason, ack_payload, acked_at)
                OUTPUT INSERTED.business_ack_id
                VALUES (?,?,?,?,?,?,?,?)
                """;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, ack.dispatchId());
            ps.setString(2, ack.systemId());
            ps.setString(3, ack.status());
            ps.setString(4, ack.swapRef());
            ps.setString(5, ack.lotRefsJson());
            ps.setString(6, ack.rejectReason());
            ps.setString(7, ack.ackPayload());
            ps.setTimestamp(8, Timestamp.from(ack.ackedAt()));
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
            }
        } catch (SQLException e) {
            throw wrap("business_ack insert failed", e);
        }
    }

    @Override
    public Optional<BusinessAckRecord> findByDispatchId(long dispatchId) {
        String sql =
                "SELECT business_ack_id, dispatch_id, system_id, status, swap_ref, lot_refs,"
                        + " reject_reason, ack_payload, acked_at FROM dbo.business_ack"
                        + " WHERE dispatch_id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, dispatchId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return Optional.empty();
                }
                Timestamp acked = rs.getTimestamp("acked_at");
                return Optional.of(
                        new BusinessAckRecord(
                                rs.getLong("business_ack_id"),
                                rs.getLong("dispatch_id"),
                                rs.getString("system_id"),
                                rs.getString("status"),
                                rs.getString("swap_ref"),
                                rs.getString("lot_refs"),
                                rs.getString("reject_reason"),
                                rs.getString("ack_payload"),
                                acked.toInstant()));
            }
        } catch (SQLException e) {
            throw wrap("business_ack lookup failed", e);
        }
    }

    private static IngestionStoreException wrap(String message, SQLException e) {
        return new IngestionStoreException(message + ": " + e.getMessage(), e);
    }
}
