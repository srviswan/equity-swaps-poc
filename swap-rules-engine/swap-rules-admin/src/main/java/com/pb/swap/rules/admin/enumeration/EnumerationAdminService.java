package com.pb.swap.rules.admin.enumeration;

import com.pb.swap.rules.store.entity.EnumerationEntity;
import com.pb.swap.rules.store.entity.EnumerationValueEntity;
import com.pb.swap.rules.store.repo.EnumerationRepository;
import com.pb.swap.rules.store.repo.EnumerationValueRepository;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Thin facade over the enumeration repos used by the REST layer. */
@Service
public class EnumerationAdminService {

    private final EnumerationRepository repo;
    private final EnumerationValueRepository valueRepo;
    private final EnumerationRegistry registry;

    public EnumerationAdminService(
            EnumerationRepository repo,
            EnumerationValueRepository valueRepo,
            EnumerationRegistry registry) {
        this.repo = repo;
        this.valueRepo = valueRepo;
        this.registry = registry;
    }

    public List<EnumerationEntity> listAll() {
        return repo.findAll();
    }

    public Optional<EnumerationEntity> get(String code) {
        return repo.findById(code);
    }

    public List<EnumerationValueEntity> values(String code) {
        return valueRepo.findByEnumCodeOrderBySortOrderAscValueCodeAsc(code);
    }

    @Transactional
    public EnumerationEntity upsert(EnumerationEntity ent) {
        if (ent.getProviderType() == null) ent.setProviderType("DATABASE");
        if (ent.getRefreshPolicy() == null) ent.setRefreshPolicy("MANUAL");
        EnumerationEntity existing = repo.findById(ent.getCode()).orElse(null);
        if (existing == null) {
            ent.setVersion(1);
        } else {
            ent.setVersion((existing.getVersion() == null ? 0 : existing.getVersion()) + 1);
        }
        ent.setUpdatedAt(Instant.now());
        EnumerationEntity saved = repo.save(ent);
        registry.refresh();
        return saved;
    }

    @Transactional
    public EnumerationValueEntity upsertValue(String enumCode, EnumerationValueEntity v) {
        if (repo.findById(enumCode).isEmpty()) {
            throw new IllegalArgumentException("Unknown enumeration: " + enumCode);
        }
        v.setEnumCode(enumCode);
        Optional<EnumerationValueEntity> existing =
                valueRepo.findByEnumCodeAndValueCode(enumCode, v.getValueCode());
        existing.ifPresent(e -> v.setId(e.getId()));
        EnumerationValueEntity saved = valueRepo.save(v);
        bumpVersion(enumCode);
        registry.refresh();
        return saved;
    }

    @Transactional
    public void deleteValue(String enumCode, String valueCode) {
        valueRepo
                .findByEnumCodeAndValueCode(enumCode, valueCode)
                .ifPresent(v -> valueRepo.deleteById(v.getId()));
        bumpVersion(enumCode);
        registry.refresh();
    }

    @Transactional
    public void delete(String code) {
        valueRepo.deleteByEnumCode(code);
        repo.deleteById(code);
        registry.refresh();
    }

    private void bumpVersion(String code) {
        repo.findById(code)
                .ifPresent(
                        e -> {
                            e.setVersion((e.getVersion() == null ? 0 : e.getVersion()) + 1);
                            e.setUpdatedAt(Instant.now());
                            repo.save(e);
                        });
    }
}
