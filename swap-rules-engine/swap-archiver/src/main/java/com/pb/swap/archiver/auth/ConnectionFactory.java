package com.pb.swap.archiver.auth;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.springframework.stereotype.Component;

/**
 * Builds JDBC connections for the source / target / control endpoints, applying the configured
 * authentication mode. Kerberos consumes an existing ticket/keytab (no kinit, no delegation);
 * SQL auth pulls credentials from a {@link CredentialProvider} (CyberArk by default).
 */
@Component
public class ConnectionFactory {

    private final ArchiverProperties props;

    public ConnectionFactory(ArchiverProperties props) {
        this.props = props;
    }

    public Connection open(Endpoint endpoint) throws SQLException {
        AuthMode mode = AuthMode.from(endpoint.auth());
        Properties p = new Properties();
        switch (mode) {
            case KERBEROS -> p.setProperty("authenticationScheme", "JavaKerberos");
            case INTEGRATED -> p.setProperty("integratedSecurity", "true");
            case SQL -> {
                CredentialProvider provider = providerFor(endpoint);
                CredentialProvider.Credential cred = provider.fetch(credentialIdFor(endpoint));
                try {
                    p.setProperty("user", cred.username());
                    p.setProperty("password", new String(cred.secret()));
                } finally {
                    cred.clear();
                }
            }
        }
        return DriverManager.getConnection(endpoint.url(), p);
    }

    private CredentialProvider providerFor(Endpoint endpoint) {
        String provider =
                endpoint.credential() == null ? "ambient-kerberos" : endpoint.credential().provider();
        return switch (provider) {
            case "cyberark-ccp" -> new CyberArkCcpCredentialProvider(endpoint.credential().cyberark());
            default ->
                    throw new IllegalStateException(
                            "SQL auth requires a secret provider (e.g. cyberark-ccp), got: " + provider);
        };
    }

    private String credentialIdFor(Endpoint endpoint) {
        return endpoint.credential() != null && endpoint.credential().cyberark() != null
                ? endpoint.credential().cyberark().objectName()
                : null;
    }

    public ArchiverProperties props() {
        return props;
    }
}
