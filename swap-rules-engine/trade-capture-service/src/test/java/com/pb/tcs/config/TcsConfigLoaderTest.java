package com.pb.tcs.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * F0.4 contract: the five config files parse into typed models with the exact values pinned in
 * the spec. A change to a contract value must break a test here.
 */
class TcsConfigLoaderTest {

    @Nested
    class VersionGap {
        VersionGapConfig config = TcsConfigLoader.versionGap();

        @Test
        void defaultsMatchSpec() {
            assertThat(config.defaults().versionGapTimeoutMs()).isEqualTo(45_000L);
            assertThat(config.defaults().maxHeldPerAllocation()).isEqualTo(16);
            assertThat(config.defaults().onTimeout())
                    .isEqualTo(VersionGapConfig.TimeoutAction.QUARANTINE);
        }

        @Test
        void bookOverridesApplyAndUnknownBookFallsBackToDefault() {
            assertThat(config.timeoutMsFor("EQ_US_HY")).isEqualTo(90_000L);
            assertThat(config.timeoutMsFor("EQ_EU")).isEqualTo(30_000L);
            assertThat(config.timeoutMsFor("EQ_APAC_UNKNOWN")).isEqualTo(45_000L);
        }
    }

    @Nested
    class Ingress {
        IngressConfig config = TcsConfigLoader.ingress();

        @Test
        void solaceTopologyMatchesSpec() {
            assertThat(config.solace().queue()).isEqualTo("Q.TCS.ALLOCATION.IN");
            assertThat(config.solace().partitions()).isEqualTo(128);
            assertThat(config.solace().prefetch()).isEqualTo(50);
        }

        @Test
        void refdataRetryIsThreeAttemptsWithSpecBackoff() { // D6/D22
            assertThat(config.refdataRetry().maxAttempts()).isEqualTo(3);
            assertThat(config.refdataRetry().backoffMs()).containsExactly(1000L, 5000L, 15000L);
        }

        @Test
        void keySequenceGapDetectionIsOffUntilGcamDeliversE1() {
            assertThat(config.gapDetection().useKeySequence()).isFalse();
        }
    }

    @Nested
    class CachePolicy {
        CachePolicyConfig config = TcsConfigLoader.cachePolicy();

        @Test
        void securityStatusIsReadThrough() { // D16 hard-correctness rule
            CachePolicyConfig.FieldPolicy status = config.policy("security", "statusFields");
            assertThat(status.mode()).isEqualTo(CachePolicyConfig.Mode.READ_THROUGH);
        }

        @Test
        void securityStaticFieldsCacheFourHoursWithEventInvalidation() {
            CachePolicyConfig.FieldPolicy policy = config.policy("security", "staticFields");
            assertThat(policy.mode()).isEqualTo(CachePolicyConfig.Mode.CACHE);
            assertThat(policy.ttl()).isEqualTo(Duration.ofHours(4));
            assertThat(policy.invalidation()).isEqualTo(CachePolicyConfig.Invalidation.EVENT);
        }

        @Test
        void clientEligibilityUsesShortTtlCompromise() {
            CachePolicyConfig.FieldPolicy policy = config.policy("clientAccount", "eligibility");
            assertThat(policy.mode()).isEqualTo(CachePolicyConfig.Mode.CACHE);
            assertThat(policy.ttl()).isEqualTo(Duration.ofSeconds(30));
        }

        @Test
        void flatEntityDeclarationsResolveAsTheDefaultFieldGroup() {
            CachePolicyConfig.FieldPolicy book = config.policy("book", "anyField");
            assertThat(book.mode()).isEqualTo(CachePolicyConfig.Mode.CACHE);
            assertThat(book.ttl()).isEqualTo(Duration.ofHours(4));

            CachePolicyConfig.FieldPolicy washBook = config.policy("washBook", "anyField");
            assertThat(washBook.ttl()).isEqualTo(Duration.ofHours(1));
        }
    }

    @Nested
    class PositionMatchKey {
        PositionMatchKeyConfig config = TcsConfigLoader.positionMatchKey();

        @Test
        void systemANeverLooksUpPositionsAndUsesDefaultKey() { // D11
            PositionMatchKeyConfig.SystemPolicy a = config.systems().get("SYSTEM_A");
            assertThat(a.explicitEventType()).isFalse();
            assertThat(a.positionLookup())
                    .isEqualTo(PositionMatchKeyConfig.PositionLookup.NEVER);
            assertThat(a.matchKeyFields())
                    .containsExactly("book", "clientAccount", "security", "direction");
        }

        @Test
        void systemBLooksUpBeforeRouteWithExtendedKey() { // D12
            PositionMatchKeyConfig.SystemPolicy b = config.systems().get("SYSTEM_B");
            assertThat(b.explicitEventType()).isTrue();
            assertThat(b.positionLookup())
                    .isEqualTo(PositionMatchKeyConfig.PositionLookup.BEFORE_ROUTE);
            assertThat(b.matchKeyFields())
                    .containsExactly(
                            "book", "clientAccount", "security", "direction", "swapStructure");
        }
    }

    @Nested
    class RoutingRules {
        RoutingRulesConfig config = TcsConfigLoader.routingRules();

        @Test
        void rulesEvaluateTopDownEndingInACatchAllToSystemA() {
            assertThat(config.rules()).hasSize(2);
            assertThat(config.rules().get(0).name()).isEqualTo("us-single-stock");
            assertThat(config.rules().get(0).targets())
                    .containsExactly("SYSTEM_A", "SYSTEM_B");
            RoutingRulesConfig.Rule last = config.rules().get(config.rules().size() - 1);
            assertThat(last.criteria()).isEmpty(); // catch-all
            assertThat(last.targets()).containsExactly("SYSTEM_A");
        }

        @Test
        void systemBRequiresCrossRefAndSystemADoesNot() { // D15
            assertThat(config.targets().get("SYSTEM_B").requiresCrossRef()).isTrue();
            assertThat(config.targets().get("SYSTEM_A").requiresCrossRef()).isFalse();
        }

        @Test
        void targetsCarryBusinessAckBudgetWithinTplus8Minutes() { // NFR-3
            for (var entry : config.targets().entrySet()) {
                assertThat(entry.getValue().awaitBusinessAck()).isTrue();
                assertThat(entry.getValue().businessAckTimeoutMs()).isEqualTo(480_000L);
                assertThat(entry.getValue().maxAttempts()).isEqualTo(5);
            }
        }
    }

    @Nested
    class CutoverPolicyConfigLoader {
        @Test
        void loadsShadowDefaultAndDualPublishBookOverrides() {
            var config = TcsConfigLoader.cutoverPolicy();
            assertThat(config.shadowMode()).isTrue();
            assertThat(config.dualPublishEnabled("EQ_US_HY", "SYSTEM_A")).isFalse();
            assertThat(config.dualPublishEnabled("EQ_APAC", "SYSTEM_B")).isTrue();
            assertThat(config.archive().hotWindowMonths()).isEqualTo(3);
        }
    }

    @Nested
    class ParityManifest {
        @Test
        void loadsToleranceAndIgnorePolicies() {
            var config = TcsConfigLoader.parityManifest();
            assertThat(config.defaultMode()).isEqualTo(ParityManifestConfig.Mode.MUST_MATCH);
            assertThat(config.policyFor("snapshotVersion").mode())
                    .isEqualTo(ParityManifestConfig.Mode.IGNORE);
            assertThat(config.policyFor("swap.interestLeg.spreadBps").mode())
                    .isEqualTo(ParityManifestConfig.Mode.TOLERANCE);
            assertThat(config.policyFor("swap.interestLeg.spreadBps").absoluteTolerance())
                    .isEqualByComparingTo("0.01");
        }
    }

    @Nested
    class ApprovalWorkflowConfig {
        @Test
        void loadsStpPolicyAndBulkLimits() {
            var config = TcsConfigLoader.approvalWorkflow();
            assertThat(config.bulkMaxRows()).isEqualTo(10_000);
            assertThat(config.isStp("GCAM", "ta_user")).isTrue();
            assertThat(config.isStp("MANUAL", "ta_user")).isFalse();
        }
    }
}
