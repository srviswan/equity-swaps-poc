package com.pb.swap.rules.store.repo;

import com.pb.swap.rules.store.entity.SnapshotPublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnapshotPublicationRepository
        extends JpaRepository<SnapshotPublicationEntity, String> {}
