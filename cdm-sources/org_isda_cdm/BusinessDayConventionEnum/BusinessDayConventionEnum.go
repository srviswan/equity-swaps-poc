/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package BusinessDayConventionEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the convention for adjusting any relevant date if it would otherwise fall on a day that is not a valid business day.
   */
  
  const (
  /**
   * The non-business date will be adjusted to the first following day that is a business day
   */
  FOLLOWING BusinessDayConventionEnum = iota + 1
  /**
   * Per 2000 ISDA Definitions, Section 4.11. FRN Convention; Eurodollar Convention. FRN is included here as a type of business day convention although it does not strictly fall within ISDA's definition of a Business Day Convention and does not conform to the simple definition given above.
   */
  FRN BusinessDayConventionEnum = iota + 1
  /**
   * The non-business date will be adjusted to the first following day that is a business day unless that day falls in the next calendar month, in which case that date will be the first preceding day that is a business day.
   */
  MODFOLLOWING BusinessDayConventionEnum = iota + 1
  /**
   * The non-business date will be adjusted to the first preceding day that is a business day unless that day falls in the previous calendar month, in which case that date will be the first following day that us a business day.
   */
  MODPRECEDING BusinessDayConventionEnum = iota + 1
  /**
   * The non-business date will be adjusted to the nearest day that is a business day - i.e. if the non-business day falls on any day other than a Sunday or a Monday, it will be the first preceding day that is a business day, and will be the first following business day if it falls on a Sunday or a Monday.
   */
  NEAREST BusinessDayConventionEnum = iota + 1
  /**
   * The date will not be adjusted if it falls on a day that is not a business day.
   */
  NONE BusinessDayConventionEnum = iota + 1
  /**
   * The date adjustments conventions are defined elsewhere, so it is not required to specify them here.
   */
  NOT_APPLICABLE BusinessDayConventionEnum = iota + 1
  /**
   * The non-business day will be adjusted to the first preceding day that is a business day.
   */
  PRECEDING BusinessDayConventionEnum = iota + 1
  )    
