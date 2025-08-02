/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CompoundingMethodEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the type of compounding, e.g. flat, straight.
   */
  
  const (
  /**
   * Flat compounding. Compounding excludes the spread. Note that the first compounding period has it's interest calculated including any spread then subsequent periods compound this at a rate excluding the spread.
   */
  FLAT CompoundingMethodEnum = iota + 1
  /**
   * No compounding is to be applied.
   */
  NONE CompoundingMethodEnum = iota + 1
  /**
   * Spread Exclusive compounding.
   */
  SPREAD_EXCLUSIVE CompoundingMethodEnum = iota + 1
  /**
   * Straight compounding. Compounding includes the spread.
   */
  STRAIGHT CompoundingMethodEnum = iota + 1
  )    
