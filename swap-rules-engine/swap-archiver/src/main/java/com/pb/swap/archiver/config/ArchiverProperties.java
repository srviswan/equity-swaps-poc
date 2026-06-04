package com.pb.swap.archiver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Externalised runtime knobs. Everything that decides <em>what</em> is archived (criteria,
 * table list, windows) lives in the {@code archive.*} control tables as data, so changing it
 * needs no redeploy. This file only carries connection / mode / pacing configuration.
 */
@ConfigurationProperties(prefix = "archiver")
public record ArchiverProperties(
        @DefaultValue("basket-archive") String jobName,
        @DefaultValue("ARCHIVE") String mode,
        String asOfDate,
        Endpoint control,
        Endpoint source,
        Endpoint target,
        Restore restore,
        Throttle throttle) {

    /** A database endpoint plus how to authenticate to it. */
    public record Endpoint(String url, @DefaultValue("kerberos") String auth, Credential credential) {

        /** The {@code databaseName} from the JDBC URL — needed for cross-DB 3-part naming. */
        public String databaseName() {
            if (url == null) {
                return null;
            }
            for (String part : url.split(";")) {
                int eq = part.indexOf('=');
                if (eq > 0 && "databaseName".equalsIgnoreCase(part.substring(0, eq).trim())) {
                    return part.substring(eq + 1).trim();
                }
            }
            return null;
        }
    }

    /** How to obtain credentials for an endpoint. */
    public record Credential(
            @DefaultValue("ambient-kerberos") String provider,
            String keytab,
            CyberArk cyberark,
            Env env) {}

    /** Plain username/password from config/env. Dev and CI only — never production secrets. */
    public record Env(String username, String password) {}

    /** CyberArk Central Credential Provider (REST) settings; used only for SQL auth. */
    public record CyberArk(
            String baseUrl,
            String appId,
            String safe,
            String objectName,
            String clientCertAlias,
            @DefaultValue("300") int cacheTtlSeconds) {}

    /**
     * Restore (investigation) settings. Scope is given as a CSV of {@code baskets} (resolved to the
     * batch(es) that archived them) and/or {@code batchIds} ({@code archive_batch_id} = the archive
     * {@code run_id}). At least one must be set for a RESTORE run.
     */
    public record Restore(
            @DefaultValue("archive_investigation") String targetDb,
            @DefaultValue("false") boolean allowRestoreToSource,
            String baskets,
            String batchIds) {}

    /** Pacing knobs for the adaptive controller. */
    public record Throttle(
            @DefaultValue("30000") long targetChunkMillis,
            @DefaultValue("5000") long pollPauseMillis) {}
}
