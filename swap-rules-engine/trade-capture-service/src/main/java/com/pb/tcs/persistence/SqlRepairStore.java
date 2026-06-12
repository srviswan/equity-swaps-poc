package com.pb.tcs.persistence;

import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.repair.RepairStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

/**
 * JDBC adapter over {@code repair_quarantine} (DDL: V001 + V003) for the FR-209 blotter repair
 * workflow. Status transitions are guarded in SQL ({@code WHERE status='OPEN'}) so concurrent ops
 * actions cannot double-resolve an item.
 */
public final class SqlRepairStore implements RepairStore {

    private static final String COLUMNS =
            "quarantine_id, category, correlation_id, detail, payload_json, status, edited_by";

    private final DataSource dataSource;

    public SqlRepairStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public long open(String category, String correlationId, String detail, String payloadJson) {
        String sql =
                "INSERT INTO dbo.repair_quarantine"
                        + " (gcam_message_id, category, correlation_id, detail, payload_json)"
                        + " OUTPUT INSERTED.quarantine_id VALUES (?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correlationId); // blotter quarantines key on the D4 correlation id
            ps.setString(2, category);
            ps.setString(3, correlationId);
            ps.setString(4, detail);
            ps.setString(5, payloadJson);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw wrap("quarantine open failed", e);
        }
    }

    @Override
    public Optional<RepairItem> find(long quarantineId) {
        String sql =
                "SELECT " + COLUMNS + " FROM dbo.repair_quarantine WHERE quarantine_id=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, quarantineId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(item(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw wrap("repair lookup failed", e);
        }
    }

    @Override
    public List<RepairItem> openItems(String category) {
        String sql =
                "SELECT "
                        + COLUMNS
                        + " FROM dbo.repair_quarantine WHERE status='OPEN' AND category=?"
                        + " ORDER BY quarantine_id";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, category);
            try (ResultSet rs = ps.executeQuery()) {
                List<RepairItem> items = new ArrayList<>();
                while (rs.next()) {
                    items.add(item(rs));
                }
                return items;
            }
        } catch (SQLException e) {
            throw wrap("repair list failed", e);
        }
    }

    @Override
    public void saveEdit(long quarantineId, String payloadJson, String editedBy) {
        String sql =
                "UPDATE dbo.repair_quarantine SET payload_json=?, edited_by=?,"
                        + " edited_at=SYSUTCDATETIME() WHERE quarantine_id=? AND status='OPEN'";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, payloadJson);
            ps.setString(2, editedBy);
            ps.setLong(3, quarantineId);
            if (ps.executeUpdate() == 0) {
                throw new IngestionStoreException(
                        "repair edit rejected — item %d not OPEN".formatted(quarantineId));
            }
        } catch (SQLException e) {
            throw wrap("repair edit failed", e);
        }
    }

    @Override
    public void resolve(long quarantineId, String status, String resolvedBy) {
        String sql =
                "UPDATE dbo.repair_quarantine SET status=?, resolved_by=?,"
                        + " resolved_at=SYSUTCDATETIME() WHERE quarantine_id=? AND status='OPEN'";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setString(2, resolvedBy);
            ps.setLong(3, quarantineId);
            if (ps.executeUpdate() == 0) {
                throw new IngestionStoreException(
                        "repair resolve rejected — item %d not OPEN".formatted(quarantineId));
            }
        } catch (SQLException e) {
            throw wrap("repair resolve failed", e);
        }
    }

    private static RepairItem item(ResultSet rs) throws SQLException {
        return new RepairItem(
                rs.getLong("quarantine_id"),
                rs.getString("category"),
                rs.getString("correlation_id"),
                rs.getString("detail"),
                rs.getString("payload_json"),
                rs.getString("status"),
                rs.getString("edited_by"));
    }

    private static IngestionStoreException wrap(String message, SQLException e) {
        return new IngestionStoreException(message + ": " + e.getMessage(), e);
    }
}
