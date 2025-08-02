/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package RoundingFrequencyEnum
  import . "org_isda_cdm"
  /**
   * How often is rounding performed
   */
  
  const (
  /**
   * Rounding is done on each day
   */
  DAILY RoundingFrequencyEnum = iota + 1
  /**
   * Rounding is done only at the end of the period
   */
  PERIOD_END RoundingFrequencyEnum = iota + 1
  )    
