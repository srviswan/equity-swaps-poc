/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
package org_isda_cdm_metafields

type FieldWithMeta struct {
  Value interface{};
  Meta MetaFields;
}

type ReferenceWithMeta struct {
  GlobalReference string;
  ExternalReference string;
  Address Reference;
  Value interface{};
}

type MetaFields struct {
  Scheme string;
  GlobalKey string;
  ExternalKey string;
  Location []Key;
}

type MetaAndTemplateFields struct {
  Scheme string;
  GlobalKey string;
  ExternalKey string;
  TemplateGlobalReference string;
  Location []Key;
}

type Key struct {
  Scope string;
  Value string;
}

type Reference struct {
  Scope string;
  Value string;
}

