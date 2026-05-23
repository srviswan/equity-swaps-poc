package com.pb.swap.rules.core.compile;

import com.pb.swap.rules.core.model.ComparisonOperator;
import com.pb.swap.rules.core.model.Criterion;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Pattern;

public final class OperatorPredicates {
    private OperatorPredicates() {}

    public static boolean evaluate(Criterion criterion, Object actual) {
        ComparisonOperator op = criterion.operator();
        Object expected = criterion.value();
        return switch (op) {
            case EQ -> Objects.equals(stringify(actual), stringify(expected));
            case NE -> !Objects.equals(stringify(actual), stringify(expected));
            case GT -> compare(actual, expected) > 0;
            case LT -> compare(actual, expected) < 0;
            case GTE -> compare(actual, expected) >= 0;
            case LTE -> compare(actual, expected) <= 0;
            case IN -> inCollection(actual, expected, true);
            case NOT_IN -> inCollection(actual, expected, false);
            case CONTAINS -> actual != null && stringify(actual).contains(stringify(expected));
            case STARTS_WITH -> actual != null && stringify(actual).startsWith(stringify(expected));
            case REGEX -> actual != null && Pattern.compile(stringify(expected)).matcher(stringify(actual)).matches();
            case EXISTS -> actual != null;
            case NOT_EXISTS -> actual == null;
        };
    }

    @SuppressWarnings("unchecked")
    private static boolean inCollection(Object actual, Object expected, boolean positive) {
        if (!(expected instanceof Collection<?> col)) {
            return false;
        }
        boolean found = col.stream().anyMatch(e -> Objects.equals(stringify(actual), stringify(e)));
        return positive ? found : !found;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static int compare(Object actual, Object expected) {
        if (actual == null || expected == null) {
            return actual == null && expected == null ? 0 : (actual == null ? -1 : 1);
        }
        if (actual instanceof Comparable c && expected.getClass().isAssignableFrom(actual.getClass())) {
            return c.compareTo(expected);
        }
        return stringify(actual).compareTo(stringify(expected));
    }

    private static String stringify(Object v) {
        return v == null ? "" : v.toString();
    }
}
