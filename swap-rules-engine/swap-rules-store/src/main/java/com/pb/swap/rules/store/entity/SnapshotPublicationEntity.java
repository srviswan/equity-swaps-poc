package com.pb.swap.rules.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
@Entity
@Table(name = "snapshot_publication")
public class SnapshotPublicationEntity {
    @Id
    @Column(name = "snapshot_id", length = 36)
    private String snapshotId;

    @Column(name = "published_at", nullable = false)
    private Instant publishedAt = Instant.now();

    @Column(name = "rule_count")
    private Integer ruleCount;

    @Column(name = "template_count")
    private Integer templateCount;

    @Column(name = "fragment_count")
    private Integer fragmentCount;

    private String checksum;

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Integer getRuleCount() {
        return ruleCount;
    }

    public void setRuleCount(Integer ruleCount) {
        this.ruleCount = ruleCount;
    }

    public Integer getTemplateCount() {
        return templateCount;
    }

    public void setTemplateCount(Integer templateCount) {
        this.templateCount = templateCount;
    }

    public Integer getFragmentCount() {
        return fragmentCount;
    }

    public void setFragmentCount(Integer fragmentCount) {
        this.fragmentCount = fragmentCount;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
}
