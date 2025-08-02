/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
export interface FieldWithMeta<T> {
  value?: T;
  meta?: MetaFields;
}

export interface ReferenceWithMeta<T> {
  globalReference?: string;
  externalReference?: string;
  address?: Reference;
  value?: T;
}

export interface MetaFields {
  key?: string;
  scheme?: string;
  globalKey?: string;
  externalKey?: string;
  location?: Key[];
}

export interface MetaAndTemplateFields {
  key?: string;
  scheme?: string;
  globalKey?: string;
  externalKey?: string;
  templateGlobalReference?: string;
  location?: Key[];
}

export interface Key {
  scope?: string;
  value?: string;
}

export interface Reference {
  scope?: string;
  value?: string;
}

