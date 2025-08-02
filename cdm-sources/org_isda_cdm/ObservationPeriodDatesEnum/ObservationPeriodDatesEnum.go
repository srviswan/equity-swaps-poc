/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package ObservationPeriodDatesEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
   */
  
  const (
  /**
   * Calculations occur relative to a previously defined reset date, e.g. for a fallback rate.
   */
  FIXING_DATE ObservationPeriodDatesEnum = iota + 1
  /**
   * Calculations occur relative to the first day of a calculation period.
   */
  SET_IN_ADVANCE ObservationPeriodDatesEnum = iota + 1
  /**
   * Calculations occur relative to the last day of a calculation period (set in arrears).
   */
  STANDARD ObservationPeriodDatesEnum = iota + 1
  )    
