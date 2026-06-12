package com.pb.tcs.ingress;

/** Pipeline entry point as seen by the transport binding. */
@FunctionalInterface
public interface MessageProcessor {

    PipelineResult process(byte[] raw, int deliveryAttempt);
}
