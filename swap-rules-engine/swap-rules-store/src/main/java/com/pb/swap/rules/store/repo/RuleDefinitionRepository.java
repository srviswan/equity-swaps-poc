package com.pb.swap.rules.store.repo;

import com.pb.swap.rules.store.entity.RuleDefinitionEntity;
import com.pb.swap.rules.store.entity.RuleDefinitionId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RuleDefinitionRepository extends JpaRepository<RuleDefinitionEntity, RuleDefinitionId> {
    @Query("SELECT r FROM RuleDefinitionEntity r WHERE r.status IN ('PUBLISHED','APPROVED') AND r.enabled = true")
    List<RuleDefinitionEntity> findPublished();
}
