package com.pb.swap.rules.core.schema;

import java.util.List;

/** Schema of a model root, exposed to the rule authoring UI. */
public record SchemaDescriptor(String root, String rootType, List<FieldDescriptor> fields) {}
