package com.pb.swap.rules.admin.enumeration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pb.swap.rules.core.enumeration.EnumerationDefinition;
import com.pb.swap.rules.core.enumeration.EnumerationProvider;
import com.pb.swap.rules.core.enumeration.EnumerationValue;
import com.pb.swap.rules.store.entity.EnumerationValueEntity;
import com.pb.swap.rules.store.repo.EnumerationValueRepository;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/** Default provider: enumeration values live in the {@code enumeration_value} table. */
@Component
public class DatabaseEnumerationProvider implements EnumerationProvider {

    private static final ObjectMapper JSON = new ObjectMapper();
    private static final TypeReference<Map<String, Object>> MAP_TYPE =
            new TypeReference<>() {};

    private final EnumerationValueRepository repo;

    public DatabaseEnumerationProvider(EnumerationValueRepository repo) {
        this.repo = repo;
    }

    @Override
    public String type() {
        return "DATABASE";
    }

    @Override
    public List<EnumerationValue> fetch(EnumerationDefinition definition) {
        return repo
                .findByEnumCodeOrderBySortOrderAscValueCodeAsc(definition.code())
                .stream()
                .map(DatabaseEnumerationProvider::toValue)
                .toList();
    }

    private static EnumerationValue toValue(EnumerationValueEntity e) {
        Map<String, Object> meta = Map.of();
        if (e.getMetadata() != null && !e.getMetadata().isBlank()) {
            try {
                meta = JSON.readValue(e.getMetadata(), MAP_TYPE);
            } catch (Exception ignored) {
                meta = Map.of();
            }
        }
        return new EnumerationValue(
                e.getValueCode(),
                e.getDisplayLabel() == null ? e.getValueCode() : e.getDisplayLabel(),
                e.getSortOrder() == null ? 0 : e.getSortOrder(),
                e.isActive(),
                meta,
                e.getValidFrom(),
                e.getValidTo());
    }
}
