package com.pb.tcs.ingress;

import com.pb.tcs.proto.allocation.v1.TcsIngressMessage;
import java.util.ArrayList;
import java.util.List;

/** Test double recording ingress publishes (FR-502). */
public final class RecordingIngressPublisher implements IngressPublisher {

    private final List<TcsIngressMessage> published = new ArrayList<>();

    @Override
    public void publish(TcsIngressMessage envelope, byte[] rawBytes) {
        published.add(envelope);
    }

    public List<TcsIngressMessage> published() {
        return List.copyOf(published);
    }
}
