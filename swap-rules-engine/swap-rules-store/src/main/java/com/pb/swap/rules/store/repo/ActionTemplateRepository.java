package com.pb.swap.rules.store.repo;

import com.pb.swap.rules.store.entity.ActionTemplateEntity;
import com.pb.swap.rules.store.entity.TemplateId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActionTemplateRepository extends JpaRepository<ActionTemplateEntity, TemplateId> {
    @Query("SELECT t FROM ActionTemplateEntity t WHERE t.status = 'PUBLISHED'")
    List<ActionTemplateEntity> findPublished();
}
