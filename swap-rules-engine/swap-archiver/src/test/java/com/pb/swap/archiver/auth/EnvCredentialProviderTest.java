package com.pb.swap.archiver.auth;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pb.swap.archiver.auth.CredentialProvider.Credential;
import com.pb.swap.archiver.config.ArchiverProperties.Env;
import org.junit.jupiter.api.Test;

class EnvCredentialProviderTest {

    @Test
    void returnsConfiguredUsernameAndSecret() {
        EnvCredentialProvider provider = new EnvCredentialProvider(new Env("svc", "pw"));
        Credential cred = provider.fetch("ignored");
        assertEquals("svc", cred.username());
        assertArrayEquals("pw".toCharArray(), cred.secret());
    }

    @Test
    void clearZeroesTheSecretBuffer() {
        Credential cred = new EnvCredentialProvider(new Env("svc", "pw")).fetch("ignored");
        cred.clear();
        assertArrayEquals(new char[] {'\0', '\0'}, cred.secret());
    }

    @Test
    void rejectsIncompleteConfig() {
        assertThrows(
                IllegalStateException.class, () -> new EnvCredentialProvider(null).fetch("x"));
        assertThrows(
                IllegalStateException.class,
                () -> new EnvCredentialProvider(new Env("svc", null)).fetch("x"));
    }
}
