package com.pb.swap.rules.store.repo;

import com.pb.swap.rules.store.entity.EnumerationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnumerationRepository extends JpaRepository<EnumerationEntity, String> {}
