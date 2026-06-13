package com.pb.tcs.ingress;

/**
 * Transport-agnostic view of one delivered message. The Solace (JCSMP) adapter implements this;
 * tests use fakes — the ACK/NACK contract stays verifiable without a broker.
 */
public interface TransportMessage {

    byte[] payload();

    /** 1-based delivery attempt (Solace redelivery count + 1); drives D6/D22 retry policy. */
    int deliveryAttempt();

    void ack();

    void nack();
}
