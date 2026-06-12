package com.pb.tcs.crossref;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/** Test double recording cross-ref pushes per destination. */
public final class StubCrossRefPublisher implements CrossRefPublisher {

    private final List<CrossRefPushMessage> published = new ArrayList<>();
    private final Set<String> down = ConcurrentHashMap.newKeySet();

    public void markDown(String toSystem) {
        down.add(toSystem);
    }

    public List<CrossRefPushMessage> published() {
        return List.copyOf(published);
    }

    public List<CrossRefPushMessage> toSystem(String toSystem) {
        return published.stream().filter(m -> toSystem.equals(m.toSystem())).toList();
    }

    @Override
    public void publish(CrossRefPushMessage message) {
        if (down.contains(message.toSystem())) {
            throw new PublishException(message.toSystem() + " unavailable");
        }
        published.add(message);
    }
}
