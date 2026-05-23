package com.pb.swap.rules.core.enumeration;

import java.util.List;

/**
 * SPI for resolving the values of an enumeration. Implementations are injected by Spring and
 * registered by {@link #type()} (e.g. {@code DATABASE}, {@code STATIC}, {@code REST}). The
 * {@link com.pb.swap.rules.core.enumeration.EnumerationDefinition#sourceConfig() sourceConfig}
 * column carries any provider-specific configuration (a JSON blob, a connection name, etc.).
 */
public interface EnumerationProvider {

    /** Discriminator stored in the {@code provider_type} column. */
    String type();

    /** Fetch the current values for the supplied enumeration definition. */
    List<EnumerationValue> fetch(EnumerationDefinition definition);
}
