package com.pb.swap.archiver.auth;

import com.pb.swap.archiver.config.ArchiverProperties.Env;

/**
 * Credentials from configuration / environment variables. For local Docker dev and CI only — never
 * a source of production secrets (use {@link CyberArkCcpCredentialProvider} there).
 */
public class EnvCredentialProvider implements CredentialProvider {

    private final Env env;

    public EnvCredentialProvider(Env env) {
        this.env = env;
    }

    @Override
    public Credential fetch(String credentialId) {
        if (env == null || env.username() == null || env.password() == null) {
            throw new IllegalStateException(
                    "env credential provider requires archiver.<endpoint>.credential.env.username/password");
        }
        return new Credential(env.username(), env.password().toCharArray());
    }
}
