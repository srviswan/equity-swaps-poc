package com.pb.tcs.harness;

import static org.assertj.core.api.Assertions.assertThat;

import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * FR-606 generator contract: deterministic by seed, per-key versions strictly ascending in
 * emission order (mirrors GCAM publish order — Solace preserves it per partition key).
 */
class SyntheticAllocationGeneratorTest {

    @Test
    void emitsEveryKeyVersionExactlyOnceWithPerKeyAscendingOrder() {
        List<TcsIngressMessage> messages =
                SyntheticAllocationGenerator.uniform(50, 4, 42L).toList();

        assertThat(messages).hasSize(200);
        Map<String, Integer> lastVersion = new HashMap<>();
        for (TcsIngressMessage m : messages) {
            String key = m.getAllocation().getBlockId() + "|" + m.getAllocation().getAllocationId();
            int version = m.getAllocation().getVersion();
            assertThat(version)
                    .as("per-key ascending for %s", key)
                    .isEqualTo(lastVersion.getOrDefault(key, 0) + 1);
            lastVersion.put(key, version);
        }
        assertThat(lastVersion).hasSize(50).allSatisfy((k, v) -> assertThat(v).isEqualTo(4));
    }

    @Test
    void deterministicBySeed() {
        List<TcsIngressMessage> a = SyntheticAllocationGenerator.uniform(20, 3, 7L).toList();
        List<TcsIngressMessage> b = SyntheticAllocationGenerator.uniform(20, 3, 7L).toList();
        List<TcsIngressMessage> c = SyntheticAllocationGenerator.uniform(20, 3, 8L).toList();

        assertThat(a).isEqualTo(b);
        assertThat(a).isNotEqualTo(c);
    }

    @Test
    void hotKeysConcentratesAllMessagesOnRequestedKeyCount() {
        List<TcsIngressMessage> messages =
                SyntheticAllocationGenerator.hotKeys(10, 1500, 42L).toList();

        assertThat(messages).hasSize(1500);
        assertThat(
                        messages.stream()
                                .map(m -> m.getAllocation().getAllocationId())
                                .distinct())
                .hasSize(10);
    }

    @Test
    void generatedMessagesPassMandatoryValidation() {
        List<TcsIngressMessage> messages =
                SyntheticAllocationGenerator.uniform(5, 2, 1L).toList();

        var validator = new com.pb.tcs.validation.MandatoryFieldValidator();
        assertThat(messages)
                .allSatisfy(m -> assertThat(validator.validate(m.getAllocation())).isEmpty());
    }
}
