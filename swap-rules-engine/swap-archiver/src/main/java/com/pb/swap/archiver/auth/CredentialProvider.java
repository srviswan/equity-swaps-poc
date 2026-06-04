package com.pb.swap.archiver.auth;

import java.util.Arrays;

/**
 * Resolves credentials at runtime. Implementations must never persist or log secrets. The
 * returned secret is held in a {@code char[]} and should be {@link Credential#clear() cleared}
 * after use.
 */
public interface CredentialProvider {

    /** Fetch the credential for a logical id (e.g. a CyberArk object name). */
    Credential fetch(String credentialId);

    /** A username plus a mutable secret buffer that callers must zero after use. */
    final class Credential {
        private final String username;
        private final char[] secret;

        public Credential(String username, char[] secret) {
            this.username = username;
            this.secret = secret;
        }

        public String username() {
            return username;
        }

        public char[] secret() {
            return secret;
        }

        /** Zero the secret buffer. Call in a finally block once the connection is open. */
        public void clear() {
            if (secret != null) {
                Arrays.fill(secret, '\0');
            }
        }
    }
}
