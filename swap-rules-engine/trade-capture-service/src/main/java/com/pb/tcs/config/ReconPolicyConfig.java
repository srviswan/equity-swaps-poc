package com.pb.tcs.config;

import java.util.List;

/** FR-706 / D25 reconciliation policy loaded from {@code recon-policy.yml}. */
public record ReconPolicyConfig(int inFlightHorizonMinutes, List<Integer> escalationHours) {}
