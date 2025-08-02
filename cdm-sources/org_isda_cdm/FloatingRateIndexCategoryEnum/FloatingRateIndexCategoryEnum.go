/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package FloatingRateIndexCategoryEnum
  import . "org_isda_cdm"
  /**
   * Top level ISDA FRO category.
   */
  
  const (
  /**
   * The rate is calculated by the calculation agents from multiple observations.
   */
  CALCULATED FloatingRateIndexCategoryEnum = iota + 1
  /**
   * The rate is obtained by polling several other banks.
   */
  REFERENCE_BANKS FloatingRateIndexCategoryEnum = iota + 1
  /**
   * The rate is observed directly from a screen.
   */
  SCREEN_RATE FloatingRateIndexCategoryEnum = iota + 1
  )    
