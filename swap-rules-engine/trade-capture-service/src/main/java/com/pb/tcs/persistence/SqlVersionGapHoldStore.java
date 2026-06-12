package com.pb.tcs.persistence;

import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.ingress.VersionGapHoldStore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.sql.DataSource;

/**
 * JDBC adapter over {@code version_gap_hold} (DDL: V001) — holds survive restart (NFR-6).
 * Deadlines are stored as UTC {@code DATETIME2}.
 */
public final class SqlVersionGapHoldStore implements VersionGapHoldStore {

    private final DataSource dataSource;

    public SqlVersionGapHoldStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void hold(HoldRow row) {
        String sql =
                "INSERT INTO dbo.version_gap_hold (block_id, allocation_id, held_version,"
                        + " expected_version, book, deadline_at, raw_proto) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, row.blockId());
            ps.setString(2, row.allocationId());
            ps.setInt(3, row.heldVersion());
            ps.setInt(4, row.expectedVersion());
            ps.setString(5, row.book());
            ps.setObject(6, LocalDateTime.ofInstant(row.deadlineAt(), ZoneOffset.UTC));
            ps.setBytes(7, row.rawProto());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new IngestionStoreException("hold insert failed: " + e.getMessage(), e);
        }
    }

    @Override
    public SortedSet<Integer> heldVersions(String blockId, String allocationId) {
        String sql =
                "SELECT held_version FROM dbo.version_gap_hold WHERE block_id=?"
                        + " AND allocation_id=?";
        SortedSet<Integer> versions = new TreeSet<>();
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    versions.add(rs.getInt(1));
                }
            }
            return versions;
        } catch (SQLException e) {
            throw new IngestionStoreException("held-versions query failed: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<HoldRow> claim(String blockId, String allocationId, int version) {
        // DELETE ... OUTPUT is atomic: exactly one claimer wins even with a concurrent sweeper.
        String sql =
                "DELETE FROM dbo.version_gap_hold OUTPUT DELETED.block_id,"
                        + " DELETED.allocation_id, DELETED.held_version,"
                        + " DELETED.expected_version, DELETED.book, DELETED.deadline_at,"
                        + " DELETED.raw_proto WHERE block_id=? AND allocation_id=?"
                        + " AND held_version=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            ps.setInt(3, version);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapRow(rs)) : Optional.empty();
            }
        } catch (SQLException e) {
            throw new IngestionStoreException("hold claim failed: " + e.getMessage(), e);
        }
    }

    @Override
    public List<HoldRow> expiredHolds(Instant now) {
        String sql =
                "SELECT block_id, allocation_id, held_version, expected_version, book,"
                        + " deadline_at, raw_proto FROM dbo.version_gap_hold WHERE deadline_at < ?";
        List<HoldRow> expired = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, LocalDateTime.ofInstant(now, ZoneOffset.UTC));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    expired.add(mapRow(rs));
                }
            }
            return expired;
        } catch (SQLException e) {
            throw new IngestionStoreException("expired-holds query failed: " + e.getMessage(), e);
        }
    }

    @Override
    public void remove(String blockId, String allocationId, int version) {
        String sql =
                "DELETE FROM dbo.version_gap_hold WHERE block_id=? AND allocation_id=?"
                        + " AND held_version=?";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            ps.setInt(3, version);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new IngestionStoreException("hold remove failed: " + e.getMessage(), e);
        }
    }

    private static HoldRow mapRow(ResultSet rs) throws SQLException {
        return new HoldRow(
                rs.getString("block_id"),
                rs.getString("allocation_id"),
                rs.getInt("held_version"),
                rs.getInt("expected_version"),
                rs.getString("book"),
                rs.getObject("deadline_at", LocalDateTime.class).toInstant(ZoneOffset.UTC),
                rs.getBytes("raw_proto"));
    }
}
