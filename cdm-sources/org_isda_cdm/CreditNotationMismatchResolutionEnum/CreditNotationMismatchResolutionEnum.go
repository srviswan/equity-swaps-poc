/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CreditNotationMismatchResolutionEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list to identify the characteristics of the rating if there are several agency issue ratings but not equivalent, reference will be made to label characteristics of the rating such as the lowest/highest available.
   */
  
  const (
  /**
   * Denotes the average credit notation if several notations are listed.
   */
  AVERAGE CreditNotationMismatchResolutionEnum = iota + 1
  /**
   * Denotes the highest credit notation if several notations are listed.
   */
  HIGHEST CreditNotationMismatchResolutionEnum = iota + 1
  /**
   * Denotes the lowest credit notation if several notations are listed.
   */
  LOWEST CreditNotationMismatchResolutionEnum = iota + 1
  /**
   * Utilised where bespoke language represents the label characteristics of the rating.
   */
  OTHER CreditNotationMismatchResolutionEnum = iota + 1
  /**
   * Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
   */
  REFERENCE_AGENCY CreditNotationMismatchResolutionEnum = iota + 1
  /**
   * Denotes the second best credit notation if several notations are listed.
   */
  SECOND_BEST CreditNotationMismatchResolutionEnum = iota + 1
  )    
