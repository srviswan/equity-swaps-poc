package com.pb.swap.rules.admin;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.swap.rules.core.api.EnrichmentResult;
import com.pb.swap.rules.core.model.Action;
import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import com.pb.swap.rules.core.model.EnrichmentTarget;
import com.pb.swap.rules.core.model.OverridePolicy;
import com.pb.swap.rules.core.model.RawHedgeTrade;
import com.pb.swap.rules.core.model.RuleCategory;
import com.pb.swap.rules.core.model.RuleDefinition;
import com.pb.swap.rules.core.model.RuleStatus;
import com.pb.swap.rules.admin.service.PublishService;
import com.pb.swap.rules.runtime.engine.EnrichmentEngineImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminApplicationTest {

    @Autowired private PublishService publishService;
    @Autowired private EnrichmentEngineImpl engine;
    @Autowired private TestRestTemplate rest;

    @Test
    void publishAndEnrich() throws Exception {
        RuleDefinition economic =
                new RuleDefinition(
                        "ECON_TEST",
                        1,
                        "test",
                        RuleCategory.ECONOMIC,
                        EnrichmentTarget.INTEREST_LEG,
                        100,
                        true,
                        LocalDate.of(2020, 1, 1),
                        null,
                        null,
                        null,
                        RuleStatus.PUBLISHED,
                        List.of(new Criterion("currency", ComparisonOperator.EQ, "USD", null)),
                        null,
                        null,
                        List.of(Action.setField("interestLeg.dayCount", "ACT/365", OverridePolicy.ALWAYS)),
                        null,
                        null);
        rest.postForEntity("/api/v1/rules", economic, RuleDefinition.class);
        publishService.publish(LocalDate.now());
        RawHedgeTrade trade =
                new RawHedgeTrade(
                        "T-1", "EQUITY_SWAP", "EQ_SWAP", "USD", "T1", "AUTO",
                        BigDecimal.ONE, LocalDate.now(), "S", null);
        EnrichmentResult result = engine.enrich(trade);
        assertThat(result.swap().interestLeg().dayCount()).isEqualTo("ACT/365");
        ResponseEntity<String> health = rest.getForEntity("/actuator/health", String.class);
        assertThat(health.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
