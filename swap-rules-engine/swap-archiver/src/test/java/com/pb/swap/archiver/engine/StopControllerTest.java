package com.pb.swap.archiver.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pb.swap.archiver.config.ArchiverProperties;
import com.pb.swap.archiver.engine.StopController.Signal;
import java.sql.Statement;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

class StopControllerTest {

    private static ArchiverProperties props() {
        return new ArchiverProperties("basket-archive", "ARCHIVE", null, null, null, null, null, null);
    }

    @Test
    void localStopWinsAndCancelsActiveStatement() throws Exception {
        StopController sc = new StopController(mock(JdbcTemplate.class), props());
        Statement st = mock(Statement.class);
        sc.register(st);

        sc.requestLocalStop("emergency");

        verify(st).cancel();
        assertEquals(Signal.STOP, sc.current());
        assertTrue(sc.shouldHalt());
        assertEquals("emergency", sc.reason());
    }

    @Test
    void readsSignalFromControlTable() {
        JdbcTemplate jdbc = mock(JdbcTemplate.class);
        when(jdbc.queryForObject(anyString(), eq(String.class), any())).thenReturn("PAUSE");
        StopController sc = new StopController(jdbc, props());

        assertEquals(Signal.PAUSE, sc.current());
        assertTrue(sc.shouldHalt());
    }

    @Test
    void runMeansProceed() {
        JdbcTemplate jdbc = mock(JdbcTemplate.class);
        when(jdbc.queryForObject(anyString(), eq(String.class), any())).thenReturn("RUN");
        StopController sc = new StopController(jdbc, props());

        assertEquals(Signal.RUN, sc.current());
        assertFalse(sc.shouldHalt());
    }

    @Test
    void failsOpenToRunWhenControlUnreadable() {
        JdbcTemplate jdbc = mock(JdbcTemplate.class);
        when(jdbc.queryForObject(anyString(), eq(String.class), any()))
                .thenThrow(new RuntimeException("control table missing"));
        StopController sc = new StopController(jdbc, props());

        assertEquals(Signal.RUN, sc.current());
    }

    @Test
    void writeSignalUpdatesControlTable() {
        JdbcTemplate jdbc = mock(JdbcTemplate.class);
        StopController sc = new StopController(jdbc, props());

        sc.writeSignal(Signal.STOP, "ad-hoc STOP via CLI");

        verify(jdbc)
                .update(anyString(), eq("STOP"), eq("ad-hoc STOP via CLI"), eq("basket-archive"));
    }
}
