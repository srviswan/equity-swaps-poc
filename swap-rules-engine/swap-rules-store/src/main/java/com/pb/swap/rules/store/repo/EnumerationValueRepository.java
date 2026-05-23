package com.pb.swap.rules.store.repo;

import com.pb.swap.rules.store.entity.EnumerationValueEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EnumerationValueRepository extends JpaRepository<EnumerationValueEntity, Long> {

    List<EnumerationValueEntity> findByEnumCodeOrderBySortOrderAscValueCodeAsc(String enumCode);

    List<EnumerationValueEntity> findByEnumCodeAndActiveTrueOrderBySortOrderAscValueCodeAsc(String enumCode);

    Optional<EnumerationValueEntity> findByEnumCodeAndValueCode(String enumCode, String valueCode);

    @Transactional
    long deleteByEnumCode(String enumCode);
}
