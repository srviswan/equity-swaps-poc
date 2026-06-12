package com.pb.tcs.parity;

import com.fasterxml.jackson.databind.JsonNode;
import com.pb.tcs.config.ParityManifestConfig;
import com.pb.tcs.rules.BlotterJson;
import com.pb.tcs.rules.SwapBlotter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * FR-604: compares TCS vs legacy SwapBlotter using the configurable field manifest. Shared with
 * recon field comparison (FR-703).
 */
public final class ParityFieldComparator {

    private final ParityManifestConfig manifest;

    public ParityFieldComparator(ParityManifestConfig manifest) {
        this.manifest = manifest;
    }

    public ParityMismatchReport compare(SwapBlotter tcs, SwapBlotter legacy) {
        return compare(
                tcs.allocationId(),
                BlotterJson.toTree(tcs),
                BlotterJson.toTree(legacy));
    }

    ParityMismatchReport compare(String tradeKey, JsonNode tcs, JsonNode legacy) {
        Set<String> paths = new LinkedHashSet<>();
        collectPaths("", tcs, paths);
        collectPaths("", legacy, paths);
        manifest.fields().keySet().forEach(paths::add);

        List<ParityFieldMismatch> mismatches = new ArrayList<>();
        for (String path : paths) {
            ParityManifestConfig.FieldPolicy policy = manifest.policyFor(path);
            if (policy.mode() == ParityManifestConfig.Mode.IGNORE) {
                continue;
            }
            JsonNode left = valueAt(tcs, path);
            JsonNode right = valueAt(legacy, path);
            if (matches(policy, left, right)) {
                continue;
            }
            mismatches.add(
                    new ParityFieldMismatch(
                            path,
                            policy.mode(),
                            textOf(left),
                            textOf(right),
                            mismatchReason(policy, left, right)));
        }
        return new ParityMismatchReport(tradeKey, mismatches, mismatches.isEmpty());
    }

    private static boolean matches(
            ParityManifestConfig.FieldPolicy policy, JsonNode left, JsonNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.equals(right)) {
            return true;
        }
        if (policy.mode() == ParityManifestConfig.Mode.TOLERANCE) {
            BigDecimal l = numericValue(left);
            BigDecimal r = numericValue(right);
            if (l != null && r != null && policy.absoluteTolerance() != null) {
                return l.subtract(r).abs().compareTo(policy.absoluteTolerance()) <= 0;
            }
        }
        return false;
    }

    private static String mismatchReason(
            ParityManifestConfig.FieldPolicy policy, JsonNode left, JsonNode right) {
        if (policy.mode() == ParityManifestConfig.Mode.TOLERANCE) {
            BigDecimal l = numericValue(left);
            BigDecimal r = numericValue(right);
            if (l != null && r != null && policy.absoluteTolerance() != null) {
                BigDecimal delta = l.subtract(r).abs();
                return "delta "
                        + delta
                        + " exceeds tolerance "
                        + policy.absoluteTolerance();
            }
        }
        return "values differ";
    }

    private static BigDecimal numericValue(JsonNode node) {
        if (node == null || node.isNull()) {
            return null;
        }
        if (node.isNumber()) {
            return node.decimalValue();
        }
        if (node.isTextual()) {
            try {
                return new BigDecimal(node.asText());
            } catch (NumberFormatException ignored) {
                return null;
            }
        }
        return null;
    }

    private static String textOf(JsonNode node) {
        if (node == null || node.isNull()) {
            return null;
        }
        if (node.isValueNode()) {
            return node.asText();
        }
        return node.toString();
    }

    private static void collectPaths(String prefix, JsonNode node, Set<String> paths) {
        if (node == null || node.isNull()) {
            return;
        }
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                var entry = fields.next();
                String child = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
                if (entry.getValue().isObject()) {
                    collectPaths(child, entry.getValue(), paths);
                } else {
                    paths.add(child);
                }
            }
            return;
        }
        if (!prefix.isEmpty()) {
            paths.add(prefix);
        }
    }

    static JsonNode valueAt(JsonNode root, String dottedPath) {
        if (root == null || dottedPath == null || dottedPath.isEmpty()) {
            return null;
        }
        JsonNode current = root;
        for (String part : dottedPath.split("\\.")) {
            if (current == null || !current.isObject()) {
                return null;
            }
            current = current.get(part);
        }
        return current;
    }
}
