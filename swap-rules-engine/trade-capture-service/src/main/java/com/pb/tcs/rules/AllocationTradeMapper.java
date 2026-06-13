package com.pb.tcs.rules;

import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.tcs.ingress.EnrichedAllocation;
import com.pb.tcs.proto.allocation.v1.AllocationMessage;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Stage-4 input adapter (F3): maps the persisted {@link EnrichedAllocation} onto the rules
 * engine's {@link RawHedgeTrade}. First-class engine dimensions (book, currency, clientTier)
 * come from the allocation or its extended attributes; everything else rides in the
 * {@code attributes} bag and is addressable in rule criteria as {@code attributes.<key>}.
 *
 * <p>Field coverage is the FR-204 subset until E8 (GCAM mapping workbook) lands; extended
 * attributes flow through untouched so new GCAM fields are immediately rule-addressable.
 */
public final class AllocationTradeMapper {

    /** Engine-level product family for everything TCS captures. */
    public static final String PRODUCT_TYPE = "EQUITY_SWAP";

    private AllocationTradeMapper() {}

    public static RawHedgeTrade toRawHedgeTrade(EnrichedAllocation enriched) {
        AllocationMessage m = enriched.message();
        Map<String, String> extended = m.getExtendedAttributesMap();

        Map<String, Object> attributes = new LinkedHashMap<>();
        putIfText(attributes, "allocationType", m.getType().name());
        putIfText(attributes, "clientAccount", m.getClientAccount());
        putIfText(attributes, "direction", m.getDirection());
        putIfText(attributes, "exchange", m.getExchange());
        putIfText(attributes, "assetType", m.getAssetType());
        putIfText(attributes, "location", m.getLocation());
        putIfText(attributes, "clientMasterNo", m.getClientMasterNo());
        attributes.put("b2bLeg", m.getB2BLeg());
        putIfText(attributes, "washBookRef", enriched.washBookRef());
        // Explicit fields win over the overflow bag on key collision.
        extended.forEach(attributes::putIfAbsent);

        return new RawHedgeTrade(
                enriched.correlationId(),
                PRODUCT_TYPE,
                m.getBook(),
                textOrNull(extended.get("currency")),
                textOrNull(extended.get("clientTier")),
                enriched.envelope().getSource().name(),
                notionalOf(m, extended),
                tradeDateOf(m),
                m.getSecurityId(),
                attributes);
    }

    /** Explicit notional (extended attribute) wins; otherwise fall back to quantity. */
    private static BigDecimal notionalOf(AllocationMessage m, Map<String, String> extended) {
        String explicit = extended.get("notional");
        if (explicit != null && !explicit.isBlank()) {
            return new BigDecimal(explicit.trim());
        }
        return BigDecimal.valueOf(m.getQuantity());
    }

    private static LocalDate tradeDateOf(AllocationMessage m) {
        return m.getTradeDate().isEmpty() ? null : LocalDate.parse(m.getTradeDate());
    }

    private static void putIfText(Map<String, Object> attributes, String key, String value) {
        if (value != null && !value.isEmpty()) {
            attributes.put(key, value);
        }
    }

    private static String textOrNull(String value) {
        return value == null || value.isBlank() ? null : value;
    }
}
