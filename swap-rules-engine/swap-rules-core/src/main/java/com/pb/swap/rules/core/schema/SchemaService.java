package com.pb.swap.rules.core.schema;

import java.lang.reflect.RecordComponent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Reflection-driven schema service. Walks a (potentially nested) record graph and emits a flat list
 * of {@link FieldDescriptor}s tagged with type, enum binding, writability, and the operators that
 * make sense for the type.
 *
 * <p>Pure Java by design so it can live in {@code swap-rules-core} and be consumed by both the
 * runtime and the admin UI.
 */
public final class SchemaService {

    private final Map<Class<?>, SchemaDescriptor> cache = new ConcurrentHashMap<>();

    /** Build (or fetch from cache) a schema descriptor for the given record class. */
    public SchemaDescriptor describe(String rootName, Class<?> rootClass) {
        return cache.computeIfAbsent(
                rootClass, c -> new SchemaDescriptor(rootName, c.getSimpleName(), walk(c)));
    }

    /** Convenience for ad-hoc walks without registering a root name. */
    public List<FieldDescriptor> walk(Class<?> recordClass) {
        if (!recordClass.isRecord()) {
            throw new IllegalArgumentException(
                    "SchemaService only supports record classes, got " + recordClass.getName());
        }
        List<FieldDescriptor> out = new ArrayList<>();
        walk("", recordClass, out, true);
        return out;
    }

    private void walk(String prefix, Class<?> cls, List<FieldDescriptor> out, boolean parentWritable) {
        for (RecordComponent rc : cls.getRecordComponents()) {
            String path = prefix.isEmpty() ? rc.getName() : prefix + "." + rc.getName();
            Class<?> type = rc.getType();
            SchemaField ann = rc.getAnnotation(SchemaField.class);
            boolean writable = parentWritable && (ann == null || ann.writable());
            String enumRef = ann != null && !ann.enumRef().isEmpty() ? ann.enumRef() : null;
            String description = ann != null ? ann.description() : "";

            if (type.isRecord()) {
                // Add a node descriptor (useful for grouping), then recurse.
                out.add(
                        new FieldDescriptor(
                                path,
                                "OBJECT",
                                null,
                                true,
                                writable,
                                description,
                                List.of("EXISTS", "NOT_EXISTS")));
                walk(path, type, out, writable);
                continue;
            }

            String typeCode = typeOf(type);
            out.add(
                    new FieldDescriptor(
                            path,
                            typeCode,
                            enumRef,
                            !type.isPrimitive(),
                            writable,
                            description,
                            operatorsFor(typeCode, enumRef != null)));
        }
    }

    private static String typeOf(Class<?> type) {
        if (type == String.class || type == CharSequence.class) return "STRING";
        if (type == Boolean.class || type == boolean.class) return "BOOLEAN";
        if (type == LocalDate.class) return "DATE";
        if (type == LocalDateTime.class || type == LocalTime.class) return "DATETIME";
        if (type == BigDecimal.class || type == Double.class || type == double.class
                || type == Float.class || type == float.class) return "DECIMAL";
        if (type == BigInteger.class || type == Long.class || type == long.class
                || type == Integer.class || type == int.class
                || type == Short.class || type == short.class
                || type == Byte.class || type == byte.class) return "INTEGER";
        if (Map.class.isAssignableFrom(type)) return "MAP";
        return "STRING";
    }

    private static List<String> operatorsFor(String type, boolean hasEnum) {
        return switch (type) {
            case "STRING" ->
                    hasEnum
                            ? List.of("EQ", "NE", "IN", "NOT_IN", "EXISTS", "NOT_EXISTS")
                            : List.of(
                                    "EQ", "NE", "IN", "NOT_IN", "CONTAINS", "STARTS_WITH", "REGEX",
                                    "EXISTS", "NOT_EXISTS");
            case "DECIMAL", "INTEGER" ->
                    List.of("EQ", "NE", "GT", "LT", "GTE", "LTE", "IN", "NOT_IN", "EXISTS", "NOT_EXISTS");
            case "DATE", "DATETIME" -> List.of("EQ", "NE", "GT", "LT", "GTE", "LTE", "EXISTS", "NOT_EXISTS");
            case "BOOLEAN" -> List.of("EQ", "NE", "EXISTS", "NOT_EXISTS");
            case "OBJECT" -> List.of("EXISTS", "NOT_EXISTS");
            default -> List.of("EQ", "NE", "EXISTS", "NOT_EXISTS");
        };
    }
}
