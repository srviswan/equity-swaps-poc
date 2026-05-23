package com.pb.swap.rules.store.repo;

import com.pb.swap.rules.store.entity.CriteriaFragmentEntity;
import com.pb.swap.rules.store.entity.TemplateId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CriteriaFragmentRepository extends JpaRepository<CriteriaFragmentEntity, TemplateId> {
    @Query("SELECT f FROM CriteriaFragmentEntity f WHERE f.status = 'PUBLISHED'")
    List<CriteriaFragmentEntity> findPublished();
}
