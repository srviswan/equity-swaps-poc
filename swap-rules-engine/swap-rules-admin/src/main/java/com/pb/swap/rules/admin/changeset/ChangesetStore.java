package com.pb.swap.rules.admin.changeset;

import java.util.Optional;

public interface ChangesetStore {

    RuleChangeset save(RuleChangeset changeset);

    Optional<RuleChangeset> findById(String id);
}
