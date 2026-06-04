package com.pb.swap.archiver.auth;

import com.pb.swap.archiver.config.ArchiverProperties.CyberArk;

/**
 * CyberArk Central Credential Provider (REST + mTLS + AppID) implementation. Default secret
 * source for SQL authentication (phases B/C). A short-TTL in-memory cache avoids hammering the
 * safe per chunk; on an {@code 18456} login failure the engine should evict and re-fetch
 * (rotation self-healing).
 *
 * <p>Swap to the AIM/local-agent ({@code javapasswordsdk.jar}) by providing an alternate
 * {@link CredentialProvider} bound to the same logical id — no other code changes.
 */
public class CyberArkCcpCredentialProvider implements CredentialProvider {

    private final CyberArk config;

    public CyberArkCcpCredentialProvider(CyberArk config) {
        this.config = config;
    }

    @Override
    public Credential fetch(String credentialId) {
        // TODO(phase B): mTLS GET {baseUrl}?AppID=&Safe=&Object=, parse Content/UserName,
        // return as char[]; cache with config.cacheTtlSeconds(); never log the response body.
        throw new UnsupportedOperationException(
                "scaffold: CyberArk CCP fetch for object " + credentialId + " not yet implemented");
    }
}
