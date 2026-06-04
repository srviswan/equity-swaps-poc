package com.pb.swap.archiver.restore;

import com.pb.swap.archiver.auth.ConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * Investigative restore: the reverse pipeline. Pulls a basket's (or batch's) rows from the archive
 * back into a separate investigation DB (never live source by default — a dead surrogate would
 * confuse BAU), in reverse FK order (parents → children), located by {@code basket_key} /
 * {@code archive_batch_id}. Every restore is audited in {@code archive_restore_log}.
 */
@Component
public class RestoreService {

    private final ConnectionFactory connections;

    public RestoreService(ConnectionFactory connections) {
        this.connections = connections;
    }

    public long restoreBasket(long basketKey, String targetDb) {
        // TODO(phase 7): select archived rows by basketKey, insert into investigation DB in
        // parent->child order; record archive_restore_log. Guard restore-to-source behind config.
        throw new UnsupportedOperationException("scaffold: restore not yet implemented");
    }
}
