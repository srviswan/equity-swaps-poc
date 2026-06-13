package com.pb.tcs.reference;

import java.util.Optional;

/** Always-resolving ref-data stub for local demo runs (no external services). */
public final class DemoReferenceData implements ReferenceDataProxy {

    @Override
    public Optional<String> lookupSecurity(String securityId) {
        return Optional.of("{\"securityId\":\"" + securityId + "\",\"status\":\"ACTIVE\"}");
    }

    @Override
    public Optional<String> lookupClientAccount(String clientAccount) {
        return Optional.of("{\"clientAccount\":\"" + clientAccount + "\"}");
    }

    @Override
    public Optional<String> lookupBook(String book) {
        return Optional.of("{\"book\":\"" + book + "\"}");
    }

    @Override
    public Optional<String> lookupWashBook(String clientAccount, String exchange, boolean b2bLeg) {
        return Optional.of("{\"washBook\":\"WASH-" + clientAccount + "\"}");
    }
}
