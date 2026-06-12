package com.pb.tcs.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("demo")
class TcsApplicationTest {

    @Autowired MockMvc mockMvc;

    @Test
    void contextLoadsAndServesOpsUi() throws Exception {
        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/"))
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk());
        mockMvc.perform(
                        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/actuator/health"))
                .andExpect(
                        result ->
                                assertThat(result.getResponse().getContentAsString()).contains("UP"));
    }

    @Test
    void demoTradeIsSearchable() throws Exception {
        mockMvc.perform(
                        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get(
                                "/api/v1/trades?allocationId=ALL-1"))
                .andExpect(
                        result ->
                                assertThat(result.getResponse().getContentAsString()).contains("ALL-1"));
    }
}
