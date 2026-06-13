package com.pb.tcs.ingress;

import com.pb.tcs.reference.ReferenceDataProxy;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Map-backed reference data with the fixture entities the pipeline tests use. */
final class FakeReferenceData implements ReferenceDataProxy {

    private final Map<String, String> securities = new HashMap<>();
    private final Map<String, String> clientAccounts = new HashMap<>();
    private final Map<String, String> books = new HashMap<>();

    FakeReferenceData() {
        securities.put("SEC-AAPL", "{\"securityId\":\"SEC-AAPL\",\"status\":\"ACTIVE\"}");
        clientAccounts.put("CLI-9", "{\"clientAccount\":\"CLI-9\",\"status\":\"OPEN\"}");
        books.put("EQ_US_HY", "{\"book\":\"EQ_US_HY\",\"region\":\"US\"}");
    }

    @Override
    public Optional<String> lookupSecurity(String securityId) {
        return Optional.ofNullable(securities.get(securityId));
    }

    @Override
    public Optional<String> lookupClientAccount(String clientAccount) {
        return Optional.ofNullable(clientAccounts.get(clientAccount));
    }

    @Override
    public Optional<String> lookupBook(String book) {
        return Optional.ofNullable(books.get(book));
    }

    @Override
    public Optional<String> lookupWashBook(String clientAccount, String exchange, boolean b2bLeg) {
        return Optional.of(
                "{\"washBook\":\"WASH-" + exchange + "\",\"b2bLeg\":" + b2bLeg + "}");
    }

    void removeSecurity(String securityId) {
        securities.remove(securityId);
    }
}
