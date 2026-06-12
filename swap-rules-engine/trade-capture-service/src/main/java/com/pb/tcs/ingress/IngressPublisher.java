package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;

/** Publishes ingress messages to the partitioned topic (FR-502). */
public interface IngressPublisher {

    void publish(TcsIngressMessage envelope, byte[] rawBytes);
}
