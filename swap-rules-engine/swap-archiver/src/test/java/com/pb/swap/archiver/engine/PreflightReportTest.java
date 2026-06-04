package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PreflightReportTest {

    @Test
    void emptyReportIsOk() {
        assertTrue(new PreflightReport().ok());
    }

    @Test
    void warningsDoNotFailButFailuresDo() {
        PreflightReport r = new PreflightReport();
        r.pass("a", "ok");
        r.warn("b", "heads up");
        assertTrue(r.ok());
        r.fail("c", "broken");
        assertFalse(r.ok());
        assertEquals(3, r.checks().size());
    }

    @Test
    void renderIncludesEachCheckAndVerdict() {
        PreflightReport r = new PreflightReport();
        r.pass("conn", "connected");
        r.fail("perm", "missing");
        String out = r.render();
        assertTrue(out.contains("conn"));
        assertTrue(out.contains("perm"));
        assertTrue(out.contains("FAIL"));
    }
}
