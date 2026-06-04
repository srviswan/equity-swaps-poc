package com.pb.swap.archiver.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AuthModeTest {

    @Test
    void parsesAllSupportedModesCaseInsensitively() {
        assertEquals(AuthMode.KERBEROS, AuthMode.from("kerberos"));
        assertEquals(AuthMode.KERBEROS, AuthMode.from("  KERBEROS "));
        assertEquals(AuthMode.INTEGRATED, AuthMode.from("Integrated"));
        assertEquals(AuthMode.SQL, AuthMode.from("SQL"));
    }

    @Test
    void rejectsNullAndUnknown() {
        assertThrows(IllegalArgumentException.class, () -> AuthMode.from(null));
        assertThrows(IllegalArgumentException.class, () -> AuthMode.from("ldap"));
    }
}
