package com.pb.tcs.boot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("demo")
class TcsApplicationTest {

    @Autowired MockMvc mockMvc;

    @Test
    void contextLoadsAndServesOpsUi() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
        mockMvc.perform(get("/actuator/health"))
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).contains("UP"));
    }

    @Test
    void demoTradeIsSearchable() throws Exception {
        mockMvc.perform(get("/api/v1/trades?allocationId=ALL-1"))
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).contains("ALL-1"));
    }

    @Test
    void runSyncCompletesTimeline() throws Exception {
        String blockId = "BLK-IT-" + System.nanoTime();
        mockMvc.perform(post("/api/v1/demo/trades/run-sync").param("blockId", blockId).param("tradeDate", "2026-06-10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalStatus").value("SENT"))
                .andExpect(jsonPath("$.downstreamPublished").value(true));

        mockMvc.perform(get("/api/v1/demo/trades/" + blockId + "/timeline"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.complete").value(true))
                .andExpect(jsonPath("$.events[?(@.stage=='COMPLETE')]").exists());
    }

    @Test
    void invalidTradeDateReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/v1/demo/trades/run-sync").param("blockId", "BLK-BAD-DATE").param("tradeDate", "not-a-date"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void duplicateBlockIdRunTerminatesTimeline() throws Exception {
        String blockId = "BLK-DUP-" + System.nanoTime();
        mockMvc.perform(post("/api/v1/demo/trades/run-sync").param("blockId", blockId).param("tradeDate", "2026-06-10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalStatus").value("SENT"));

        mockMvc.perform(post("/api/v1/demo/trades/run-sync").param("blockId", blockId).param("tradeDate", "2026-06-10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalStatus").value("FAILED"));

        mockMvc.perform(get("/api/v1/demo/trades/" + blockId + "/timeline"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.complete").value(true))
                .andExpect(jsonPath("$.events[?(@.stage=='FAILED')]").exists());
    }
}
