package com.pb.swap.archiver.engine;

import com.pb.swap.archiver.auth.ConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * Fail-fast checks before any data is touched: connectivity + usable Kerberos ticket, source↔target
 * schema consistency (additive evolution or strict stop), permissions
 * ({@code SELECT/DELETE/INSERT/ALTER/VIEW SERVER STATE}), capacity (data/log free space, recovery
 * model, log-backup job), topology reachability, and CyberArk safe reachability.
 */
@Component
public class PreflightValidator {

    private final ConnectionFactory connections;

    public PreflightValidator(ConnectionFactory connections) {
        this.connections = connections;
    }

    /** @return true if all checks pass; details are logged and recorded. */
    public boolean validate() {
        // TODO(phase 1): run the checks described above against source/target/control endpoints.
        throw new UnsupportedOperationException("scaffold: preflight checks not yet implemented");
    }
}
