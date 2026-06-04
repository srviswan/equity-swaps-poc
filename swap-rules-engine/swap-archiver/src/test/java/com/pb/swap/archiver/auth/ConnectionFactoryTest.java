package com.pb.swap.archiver.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.pb.swap.archiver.config.ArchiverProperties.Credential;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import com.pb.swap.archiver.config.ArchiverProperties.Env;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class ConnectionFactoryTest {

    private final ConnectionFactory factory = new ConnectionFactory(null);

    @Test
    void kerberosUsesJavaKerberosScheme() {
        Properties p = factory.authProperties(new Endpoint("jdbc:sqlserver://h", "kerberos", null));
        assertEquals("JavaKerberos", p.getProperty("authenticationScheme"));
        assertNull(p.getProperty("user"));
    }

    @Test
    void integratedUsesIntegratedSecurity() {
        Properties p = factory.authProperties(new Endpoint("jdbc:sqlserver://h", "integrated", null));
        assertEquals("true", p.getProperty("integratedSecurity"));
    }

    @Test
    void sqlAuthFromEnvProviderSetsUserAndPassword() {
        Credential cred = new Credential("env", null, null, new Env("svc_user", "s3cret"));
        Properties p = factory.authProperties(new Endpoint("jdbc:sqlserver://h", "sql", cred));
        assertEquals("svc_user", p.getProperty("user"));
        assertEquals("s3cret", p.getProperty("password"));
    }

    @Test
    void unknownAuthModeIsRejected() {
        assertThrows(
                IllegalArgumentException.class,
                () -> factory.authProperties(new Endpoint("jdbc:sqlserver://h", "bogus", null)));
    }
}
