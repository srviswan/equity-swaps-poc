package com.pb.swap.archiver.copy;

import org.springframework.stereotype.Component;

/**
 * Same server, different database: the archive table is referenced by a 3-part name
 * {@code [db].[schema].[table]} against the <em>source</em> connection. Both databases live on the
 * same instance, so the copy + delete still run in one local transaction (crash → rollback → the
 * chunk re-runs), identical in shape to {@link SameDbCopyStrategy}; only the target gets a database
 * qualifier (taken from the target endpoint's JDBC URL).
 *
 * <p>This is the recommended steady-state target: an archive DB in SIMPLE recovery, outside the AG,
 * so the copy is not shipped across the Availability Group.
 */
@Component
public class CrossDbCopyStrategy extends SameDbCopyStrategy {

    @Override
    public String topology() {
        return "CROSS_DB";
    }

    @Override
    protected String targetDatabase(MoveContext ctx) {
        String db = ctx.props().target().databaseName();
        if (db == null) {
            throw new IllegalStateException("CROSS_DB requires a target databaseName in the target endpoint URL");
        }
        return db;
    }
}
