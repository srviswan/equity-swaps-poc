package com.pb.swap.archiver.auth;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.config.ArchiverProperties.Credential;
import com.pb.swap.archiver.config.ArchiverProperties.Endpoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.springframework.stereotype.Component;

/**
 * Builds JDBC connections for the source / target / control endpoints, applying the configured
 * authentication mode. Kerberos consumes an existing ticket/keytab (no kinit, no delegation);
 * SQL auth pulls credentials from a {@link CredentialProvider} (CyberArk in prod, env in dev).
 */
@Component
public class ConnectionFactory {

    private final ArchiverProperties props;

    public ConnectionFactory(ArchiverProperties props) {
        this.props = props;
    }

    /** Open a connection to an endpoint using its configured auth mode. */
    public Connection open(Endpoint endpoint) throws SQLException {
        if (endpoint == null || endpoint.url() == null) {
            throw new IllegalArgumentException("endpoint url is not configured");
        }
        return DriverManager.getConnection(endpoint.url(), authProperties(endpoint));
    }

    /**
     * Build the JDBC properties (auth only) for an endpoint. Exposed for unit testing without a live
     * database. For SQL auth the secret is fetched, copied into the properties, then zeroed.
     */
    public Properties authProperties(Endpoint endpoint) {
        AuthMode mode = AuthMode.from(endpoint.auth());
        Properties p = new Properties();
        switch (mode) {
            case KERBEROS -> p.setProperty("authenticationScheme", "JavaKerberos");
            case INTEGRATED -> p.setProperty("integratedSecurity", "true");
            case SQL -> {
                CredentialProvider.Credential cred = providerFor(endpoint).fetch(credentialIdFor(endpoint));
                try {
                    p.setProperty("user", cred.username());
                    p.setProperty("password", new String(cred.secret()));
                } finally {
                    cred.clear();
                }
            }
        }
        return p;
    }

    /** Run a single-value query and return the first column as a String (or null). */
    public String scalar(Connection conn, String sql) throws SQLException {
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    CredentialProvider providerFor(Endpoint endpoint) {
        Credential c = endpoint.credential();
        String provider = c == null ? "ambient-kerberos" : c.provider();
        return switch (provider) {
            case "cyberark-ccp" -> new CyberArkCcpCredentialProvider(c.cyberark());
            case "env" -> new EnvCredentialProvider(c.env());
            default ->
                    throw new IllegalStateException(
                            "SQL auth requires a secret provider (cyberark-ccp|env), got: " + provider);
        };
    }

    private String credentialIdFor(Endpoint endpoint) {
        Credential c = endpoint.credential();
        if (c != null && c.cyberark() != null) {
            return c.cyberark().objectName();
        }
        return null;
    }

    public ArchiverProperties props() {
        return props;
    }
}
