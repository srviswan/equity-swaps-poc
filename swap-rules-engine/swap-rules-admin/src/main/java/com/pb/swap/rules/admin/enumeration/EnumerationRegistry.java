package com.pb.swap.rules.admin.enumeration;

import com.pb.swap.rules.core.enumeration.EnumerationDefinition;
import com.pb.swap.rules.core.enumeration.EnumerationDescriptor;
import com.pb.swap.rules.core.enumeration.EnumerationProvider;
import com.pb.swap.rules.core.enumeration.EnumerationSnapshot;
import com.pb.swap.rules.core.enumeration.EnumerationValue;
import com.pb.swap.rules.store.entity.EnumerationEntity;
import com.pb.swap.rules.store.repo.EnumerationRepository;
import jakarta.annotation.PostConstruct;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * In-memory, versioned snapshot of every enumeration declared in the database. Provides O(1)
 * lookups for the UI and is refreshable manually or on a schedule.
 */
@Component
public class EnumerationRegistry {

    private static final Logger log = LoggerFactory.getLogger(EnumerationRegistry.class);

    private final EnumerationRepository repo;
    private final Map<String, EnumerationProvider> providers;
    private final AtomicReference<EnumerationSnapshot> current =
            new AtomicReference<>(EnumerationSnapshot.empty());

    public EnumerationRegistry(EnumerationRepository repo, List<EnumerationProvider> providers) {
        this.repo = repo;
        Map<String, EnumerationProvider> idx = new HashMap<>();
        providers.forEach(p -> idx.put(p.type(), p));
        this.providers = Map.copyOf(idx);
    }

    @PostConstruct
    public void initialise() {
        try {
            refresh();
        } catch (Exception e) {
            log.warn("Initial enumeration snapshot load failed: {}", e.getMessage());
        }
    }

    public EnumerationSnapshot current() {
        return current.get();
    }

    /** Re-fetch every enumeration through its provider and publish a new snapshot. */
    public EnumerationSnapshot refresh() {
        Map<String, EnumerationDescriptor> built = new LinkedHashMap<>();
        for (EnumerationEntity ent : repo.findAll()) {
            EnumerationProvider provider = providers.get(ent.getProviderType());
            if (provider == null) {
                log.warn(
                        "No EnumerationProvider for type '{}' (enum {})",
                        ent.getProviderType(),
                        ent.getCode());
                continue;
            }
            EnumerationDefinition def = toDefinition(ent);
            List<EnumerationValue> values = provider.fetch(def);
            built.put(
                    ent.getCode(),
                    new EnumerationDescriptor(
                            ent.getCode(),
                            ent.getDisplayName(),
                            ent.getDescription(),
                            ent.getProviderType(),
                            ent.getVersion() == null ? 1 : ent.getVersion(),
                            ent.getUpdatedAt() == null ? Instant.now() : ent.getUpdatedAt(),
                            values));
        }
        EnumerationSnapshot snap =
                new EnumerationSnapshot(UUID.randomUUID().toString(), Instant.now(), built);
        current.set(snap);
        log.info("Enumeration snapshot refreshed: {} enumerations", snap.size());
        return snap;
    }

    private static EnumerationDefinition toDefinition(EnumerationEntity e) {
        return new EnumerationDefinition(
                e.getCode(),
                e.getDisplayName(),
                e.getDescription(),
                e.getProviderType(),
                e.getSourceConfig(),
                e.getRefreshPolicy(),
                e.getRefreshIntervalSeconds(),
                e.getVersion() == null ? 1 : e.getVersion());
    }
}
