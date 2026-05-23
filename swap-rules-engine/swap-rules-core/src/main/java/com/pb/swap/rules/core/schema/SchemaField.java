package com.pb.swap.rules.core.schema;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declarative metadata for a record component participating in the schema surface exposed to the
 * rules engine UI.
 *
 * <p>Annotate components on {@code RawHedgeTrade} and the enriched-swap records to advertise:
 *
 * <ul>
 *   <li>which enumeration drives valid values for this field (via {@link #enumRef()})
 *   <li>whether the field is writable by an action (defaults to {@code true})
 *   <li>a human-readable description for tool tips
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.RECORD_COMPONENT, ElementType.METHOD})
public @interface SchemaField {

    /** Code of an enumeration registered with the enumeration registry (e.g. {@code CURRENCY}). */
    String enumRef() default "";

    /** Free-form description used for tooltips in the UI. */
    String description() default "";

    /** When {@code false}, the field is read-only (cannot be an action target). */
    boolean writable() default true;
}
