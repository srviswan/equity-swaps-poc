package com.pb.swap.rules.admin.changeset;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** Named draft bundle of rule edits published atomically (FR-508 / D24). */
public final class RuleChangeset {

    public enum Status {
        DRAFT,
        SIMULATED,
        PUBLISHED,
        REJECTED
    }

    private final String id;
    private final String name;
    private final String author;
    private Status status;
    private final List<RuleChange> changes = new ArrayList<>();
    private final Instant createdAt;
    private Instant simulatedAt;
    private Instant publishedAt;

    public RuleChangeset(String name, String author) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.author = author;
        this.status = Status.DRAFT;
        this.createdAt = Instant.now();
    }

    RuleChangeset(
            String id,
            String name,
            String author,
            Status status,
            List<RuleChange> changes,
            Instant createdAt,
            Instant simulatedAt,
            Instant publishedAt) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.status = status;
        this.changes.addAll(changes);
        this.createdAt = createdAt;
        this.simulatedAt = simulatedAt;
        this.publishedAt = publishedAt;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String author() {
        return author;
    }

    public Status status() {
        return status;
    }

    public List<RuleChange> changes() {
        return List.copyOf(changes);
    }

    public Instant createdAt() {
        return createdAt;
    }

    public Instant simulatedAt() {
        return simulatedAt;
    }

    public Instant publishedAt() {
        return publishedAt;
    }

    public void addChange(RuleChange change) {
        if (status != Status.DRAFT) {
            throw new IllegalStateException("changeset is not editable: " + status);
        }
        changes.add(change);
    }

    void markSimulated() {
        status = Status.SIMULATED;
        simulatedAt = Instant.now();
    }

    void markPublished() {
        status = Status.PUBLISHED;
        publishedAt = Instant.now();
    }

    void markRejected() {
        status = Status.REJECTED;
    }
}
