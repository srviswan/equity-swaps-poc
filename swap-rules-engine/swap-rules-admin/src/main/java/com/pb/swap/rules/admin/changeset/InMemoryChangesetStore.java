package com.pb.swap.rules.admin.changeset;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public final class InMemoryChangesetStore implements ChangesetStore {

    private final Map<String, RuleChangeset> byId = new LinkedHashMap<>();

    @Override
    public RuleChangeset save(RuleChangeset changeset) {
        byId.put(changeset.id(), changeset);
        return changeset;
    }

    @Override
    public Optional<RuleChangeset> findById(String id) {
        return Optional.ofNullable(byId.get(id));
    }
}
