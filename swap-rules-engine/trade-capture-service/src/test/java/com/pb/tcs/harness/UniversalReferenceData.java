package com.pb.tcs.harness;

import com.pb.tcs.reference.ReferenceDataProxy;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/** Resolves every lookup (load runs exercise throughput, not ref-data misses) — switchable down for the outage drill. */
final class UniversalReferenceData implements ReferenceDataProxy {

    private final AtomicBoolean available = new AtomicBoolean(true);

    void outage() {
        available.set(false);
    }

    void recover() {
        available.set(true);
    }

    @Override
    public Optional<String> lookupSecurity(String securityId) {
        return resolve("{\"securityId\":\"" + securityId + "\"}");
    }

    @Override
    public Optional<String> lookupClientAccount(String clientAccount) {
        return resolve("{\"clientAccount\":\"" + clientAccount + "\"}");
    }

    @Override
    public Optional<String> lookupBook(String book) {
        return resolve("{\"book\":\"" + book + "\"}");
    }

    @Override
    public Optional<String> lookupWashBook(String clientAccount, String exchange, boolean b2bLeg) {
        return resolve("{\"washBook\":\"WASH-" + clientAccount + "\"}");
    }

    private Optional<String> resolve(String json) {
        return available.get() ? Optional.of(json) : Optional.empty();
    }
}
