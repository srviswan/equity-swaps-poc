package com.pb.swap.archiver.auth;

/** Supported SQL Server authentication modes. */
public enum AuthMode {
    /** {@code authenticationScheme=JavaKerberos} using an ambient ticket / infra keytab. */
    KERBEROS,
    /** {@code integratedSecurity=true} (Windows). */
    INTEGRATED,
    /** SQL login; username/password sourced from a {@link CredentialProvider}. */
    SQL;

    public static AuthMode from(String value) {
        return switch (value == null ? "" : value.trim().toLowerCase()) {
            case "kerberos" -> KERBEROS;
            case "integrated" -> INTEGRATED;
            case "sql" -> SQL;
            default -> throw new IllegalArgumentException("Unknown auth mode: " + value);
        };
    }
}
