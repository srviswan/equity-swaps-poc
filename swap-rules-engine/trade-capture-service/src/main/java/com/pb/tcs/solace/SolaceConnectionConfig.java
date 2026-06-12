package com.pb.tcs.solace;

/** Connection settings for the JCSMP partition consumer (queue/prefetch from ingress.yml). */
public record SolaceConnectionConfig(
        String host,
        String vpn,
        String username,
        String password,
        String queue,
        int prefetch) {}
