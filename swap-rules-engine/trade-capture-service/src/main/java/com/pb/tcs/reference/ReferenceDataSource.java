package com.pb.tcs.reference;

import java.util.Optional;

/**
 * Authoritative upstream provider (external DB or API, E2). The caching proxy sits in front;
 * pipeline code never talks to this directly. Payloads are reference-data JSON snapshots.
 */
public interface ReferenceDataSource {

    Optional<String> fetchSecurity(String securityId);

    /** Status-critical field group — read-through per cache-policy.yml (D16). */
    Optional<String> fetchSecurityStatus(String securityId);

    Optional<String> fetchClientAccount(String clientAccount);

    Optional<String> fetchBook(String book);

    Optional<String> fetchWashBook(String clientAccount, String exchange, boolean b2bLeg);
}
