package com.pb.tcs.persistence;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.ingress.IngestionStore;
import com.pb.tcs.ingress.IngestionStoreException;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.OptionalInt;
import javax.sql.DataSource;

/**
 * JDBC adapter over {@code ingestion_record} / {@code enriched_allocation} / {@code audit_reject}
 * / {@code repair_quarantine} (DDL: V001). Owns the F1.4 transaction boundaries: each method is
 * one transaction; {@link #persistEnriched} writes both rows atomically so the Solace ACK that
 * follows a successful return is backed by a commit (D5).
 */
public final class SqlIngestionStore implements IngestionStore {

    private static final String INSERT_INGESTION =
            """
            INSERT INTO dbo.ingestion_record (
              block_id, allocation_id, version, gcam_message_id, allocation_type,
              source_system, entry_mode, initiated_by, sequence_key_hash, book,
              account_id, security_id, trade_date, status, raw_proto, correlation_id, acked_at)
            OUTPUT INSERTED.ingestion_id
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,'ENRICHED_ACKED',?,?,SYSUTCDATETIME())
            """;

    private static final String INSERT_ENRICHED =
            """
            INSERT INTO dbo.enriched_allocation (
              ingestion_id, trade_date, security_ref, client_ref, book_ref,
              wash_book_ref, enriched_payload)
            VALUES (?,?,?,?,?,?,?)
            """;

    private final DataSource dataSource;

    public SqlIngestionStore(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean isEnriched(String blockId, String allocationId, int version) {
        String sql =
                "SELECT 1 FROM dbo.ingestion_record WHERE block_id=? AND allocation_id=?"
                        + " AND version=? AND status='ENRICHED_ACKED'";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            ps.setInt(3, version);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw wrap("idempotency probe failed", e);
        }
    }

    @Override
    public OptionalInt lastEnrichedVersion(String blockId, String allocationId) {
        String sql =
                "SELECT MAX(version) FROM dbo.ingestion_record WHERE block_id=?"
                        + " AND allocation_id=? AND status='ENRICHED_ACKED'";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, blockId);
            ps.setString(2, allocationId);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                int max = rs.getInt(1);
                return rs.wasNull() ? OptionalInt.empty() : OptionalInt.of(max);
            }
        } catch (SQLException e) {
            throw wrap("last-version probe failed", e);
        }
    }

    @Override
    public void persistEnriched(EnrichedAllocation enriched) {
        AllocationMessage msg = enriched.message();
        TcsIngressMessage envelope = enriched.envelope();
        Date tradeDate = Date.valueOf(LocalDate.parse(msg.getTradeDate()));
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try {
                Object ingestionId;
                try (PreparedStatement ps = conn.prepareStatement(INSERT_INGESTION)) {
                    ps.setString(1, msg.getBlockId());
                    ps.setString(2, msg.getAllocationId());
                    ps.setInt(3, msg.getVersion());
                    ps.setString(4, msg.getGcamMessageId());
                    ps.setString(5, msg.getType().name());
                    ps.setString(6, envelope.getSource().name());
                    ps.setString(7, "ALLOCATION");
                    ps.setString(
                            8,
                            envelope.getInitiatedBy().isBlank()
                                    ? "SYSTEM"
                                    : envelope.getInitiatedBy());
                    ps.setLong(9, enriched.sequenceKeyHash());
                    ps.setString(10, envelope.getBook());
                    ps.setString(11, envelope.getAccountId());
                    ps.setString(12, envelope.getSecurityId());
                    ps.setDate(13, tradeDate);
                    ps.setBytes(14, enriched.rawProto());
                    ps.setString(15, enriched.correlationId());
                    try (ResultSet rs = ps.executeQuery()) {
                        rs.next();
                        ingestionId = rs.getObject(1);
                    }
                }
                try (PreparedStatement ps = conn.prepareStatement(INSERT_ENRICHED)) {
                    ps.setObject(1, ingestionId);
                    ps.setDate(2, tradeDate);
                    ps.setString(3, enriched.securityRef());
                    ps.setString(4, enriched.clientRef());
                    ps.setString(5, enriched.bookRef());
                    ps.setString(6, enriched.washBookRef());
                    ps.setString(7, enrichedPayloadJson(enriched));
                    ps.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw wrap("enriched persist failed", e);
            } finally {
                conn.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw wrap("enriched persist connection failure", e);
        }
    }

    @Override
    public void auditReject(
            String stage, String reason, int attempt, byte[] rawProto, TcsIngressMessage parsed) {
        String sql =
                "INSERT INTO dbo.audit_reject (gcam_message_id, block_id, allocation_id,"
                        + " version, stage, reason, attempt, raw_proto) VALUES (?,?,?,?,?,?,?,?)";
        AllocationMessage alloc =
                parsed != null && parsed.hasAllocation() ? parsed.getAllocation() : null;
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, alloc != null ? alloc.getGcamMessageId() : "UNPARSEABLE");
            ps.setString(2, alloc != null ? alloc.getBlockId() : null);
            ps.setString(3, alloc != null ? alloc.getAllocationId() : null);
            if (alloc != null) {
                ps.setInt(4, alloc.getVersion());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
            }
            ps.setString(5, stage);
            ps.setString(6, reason);
            ps.setInt(7, attempt);
            ps.setBytes(8, rawProto);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("audit_reject insert failed", e);
        }
    }

    @Override
    public void quarantine(String category, String detail, byte[] rawProto) {
        String sql =
                "INSERT INTO dbo.repair_quarantine (gcam_message_id, category, detail,"
                        + " raw_proto) VALUES (?,?,?,?)";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, gcamMessageIdOf(rawProto));
            ps.setString(2, category);
            ps.setString(3, detail);
            ps.setBytes(4, rawProto);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw wrap("repair_quarantine insert failed", e);
        }
    }

    private static String gcamMessageIdOf(byte[] rawProto) {
        if (rawProto == null) {
            return "UNKNOWN";
        }
        try {
            TcsIngressMessage envelope = TcsIngressMessage.parseFrom(rawProto);
            if (envelope.hasAllocation()
                    && !envelope.getAllocation().getGcamMessageId().isBlank()) {
                return envelope.getAllocation().getGcamMessageId();
            }
            return envelope.getMessageId().isBlank() ? "UNKNOWN" : envelope.getMessageId();
        } catch (InvalidProtocolBufferException e) {
            return "UNKNOWN";
        }
    }

    private static String enrichedPayloadJson(EnrichedAllocation enriched) {
        // Stable, queryable snapshot of the resolved refs; the full EnrichedAllocationMessage
        // JSON shape lands with the F3 blotter work (rule input contract).
        return """
               {"securityRef":%s,"clientRef":%s,"bookRef":%s,"washBookRef":%s}"""
                .formatted(
                        jsonOrNull(enriched.securityRef()),
                        jsonOrNull(enriched.clientRef()),
                        jsonOrNull(enriched.bookRef()),
                        jsonOrNull(enriched.washBookRef()));
    }

    private static String jsonOrNull(String json) {
        return json == null ? "null" : json;
    }

    private static IngestionStoreException wrap(String context, SQLException e) {
        return new IngestionStoreException(context + ": " + e.getMessage(), e);
    }
}
