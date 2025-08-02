/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package SpecifiedEntityTermsEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified.
   */
  
  const (
  /**
   * Any Affiliate is a Specified Entity.
   */
  ANY_AFFILIATE SpecifiedEntityTermsEnum = iota + 1
  /**
   * Any Material Subsidiary.
   */
  MATERIAL_SUBSIDIARY SpecifiedEntityTermsEnum = iota + 1
  /**
   * The Specified Entity is provided.
   */
  NAMED_SPECIFIED_ENTITY SpecifiedEntityTermsEnum = iota + 1
  /**
   * No Specified Entity is provided
   */
  NONE SpecifiedEntityTermsEnum = iota + 1
  /**
   * Non standard Specified Entity terms are provided.
   */
  OTHER_SPECIFIED_ENTITY SpecifiedEntityTermsEnum = iota + 1
  )    
