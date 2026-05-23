package com.pb.swap.rules.admin.controller;

import com.pb.swap.rules.admin.enumeration.EnumerationAdminService;
import com.pb.swap.rules.admin.enumeration.EnumerationRegistry;
import com.pb.swap.rules.core.enumeration.EnumerationDescriptor;
import com.pb.swap.rules.core.enumeration.EnumerationSnapshot;
import com.pb.swap.rules.store.entity.EnumerationEntity;
import com.pb.swap.rules.store.entity.EnumerationValueEntity;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CRUD and refresh endpoints for managed enumerations. All write operations transparently re-publish
 * the in-memory snapshot via {@link EnumerationRegistry}.
 */
@RestController
@RequestMapping("/api/v1/enumerations")
public class EnumerationsController {

    private final EnumerationAdminService service;
    private final EnumerationRegistry registry;

    public EnumerationsController(EnumerationAdminService service, EnumerationRegistry registry) {
        this.service = service;
        this.registry = registry;
    }

    /** All enumerations (live snapshot — includes resolved values). */
    @GetMapping
    public List<EnumerationDescriptor> list() {
        return registry.current().all();
    }

    /** One enumeration with its values. */
    @GetMapping("/{code}")
    public ResponseEntity<EnumerationDescriptor> get(@PathVariable String code) {
        return registry
                .current()
                .get(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /** Lightweight metadata about the active snapshot. */
    @GetMapping("/snapshot")
    public Map<String, Object> snapshotInfo() {
        EnumerationSnapshot snap = registry.current();
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("snapshotId", snap.snapshotId());
        m.put("publishedAt", snap.publishedAt().toString());
        m.put("size", snap.size());
        m.put("codes", snap.all().stream().map(EnumerationDescriptor::code).toList());
        return m;
    }

    /** Re-resolve every enumeration through its provider and republish the snapshot. */
    @PostMapping("/refresh")
    public Map<String, Object> refresh() {
        EnumerationSnapshot snap = registry.refresh();
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("snapshotId", snap.snapshotId());
        m.put("publishedAt", snap.publishedAt().toString());
        m.put("size", snap.size());
        return m;
    }

    /** Create / update an enumeration definition (metadata only). */
    @PostMapping
    public EnumerationEntity upsert(@RequestBody EnumerationEntity body) {
        return service.upsert(body);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        service.delete(code);
    }

    /** Replace the full value list for an enumeration in one shot (admin-friendly). */
    @PutMapping("/{code}/values")
    public List<EnumerationValueEntity> replaceValues(
            @PathVariable String code, @RequestBody List<ValuePayload> payload) {
        // delete + reinsert; simple and predictable
        service.values(code).forEach(v -> service.deleteValue(code, v.getValueCode()));
        payload.forEach(p -> service.upsertValue(code, p.toEntity(code)));
        return service.values(code);
    }

    /** Append or update a single value. */
    @PostMapping("/{code}/values")
    public EnumerationValueEntity addValue(
            @PathVariable String code, @RequestBody ValuePayload payload) {
        return service.upsertValue(code, payload.toEntity(code));
    }

    @PutMapping("/{code}/values/{valueCode}")
    public EnumerationValueEntity updateValue(
            @PathVariable String code,
            @PathVariable String valueCode,
            @RequestBody ValuePayload payload) {
        payload.valueCode = valueCode;
        return service.upsertValue(code, payload.toEntity(code));
    }

    @DeleteMapping("/{code}/values/{valueCode}")
    public void deleteValue(@PathVariable String code, @PathVariable String valueCode) {
        service.deleteValue(code, valueCode);
    }

    /** REST payload for value mutations. */
    public static class ValuePayload {
        public String valueCode;
        public String displayLabel;
        public Integer sortOrder;
        public Boolean active;
        public String metadata;
        public LocalDate validFrom;
        public LocalDate validTo;

        EnumerationValueEntity toEntity(String enumCode) {
            EnumerationValueEntity e = new EnumerationValueEntity();
            e.setEnumCode(enumCode);
            e.setValueCode(valueCode);
            e.setDisplayLabel(displayLabel);
            e.setSortOrder(sortOrder == null ? 0 : sortOrder);
            e.setActive(active == null ? true : active);
            e.setMetadata(metadata);
            e.setValidFrom(validFrom);
            e.setValidTo(validTo);
            return e;
        }
    }
}
