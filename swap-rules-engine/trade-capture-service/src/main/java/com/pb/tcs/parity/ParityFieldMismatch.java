package com.pb.tcs.parity;

import com.pb.tcs.config.ParityManifestConfig;

public record ParityFieldMismatch(
        String fieldPath,
        ParityManifestConfig.Mode policy,
        String tcsValue,
        String legacyValue,
        String reason) {}
