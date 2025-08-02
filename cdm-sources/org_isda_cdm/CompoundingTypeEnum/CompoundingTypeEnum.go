/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CompoundingTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify how the compounding calculation is done
   */
  
  const (
  /**
   * Compounding is done only on business days, i.e. not compounded each day on weekends or holidays.
   */
  BUSINESS CompoundingTypeEnum = iota + 1
  /**
   * Compounding is done on each calendar day.
   */
  CALENDAR CompoundingTypeEnum = iota + 1
  /**
   * Compounding is not applicable
   */
  NONE CompoundingTypeEnum = iota + 1
  )    
