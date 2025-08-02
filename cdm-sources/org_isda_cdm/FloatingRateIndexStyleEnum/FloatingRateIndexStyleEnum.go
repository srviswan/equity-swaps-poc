/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package FloatingRateIndexStyleEnum
  import . "org_isda_cdm"
  /**
   * Second level ISDA FRO category.
   */
  
  const (
  /**
   * An ISDA-defined calculated rate done using arithmetic averaging.
   */
  AVERAGE_FRO FloatingRateIndexStyleEnum = iota + 1
  /**
   * An ISDA-defined calculated rate done using arithmetic averaging.
   */
  COMPOUNDED_FRO FloatingRateIndexStyleEnum = iota + 1
  /**
   * A published index calculated using compounding.
   */
  COMPOUNDED_INDEX FloatingRateIndexStyleEnum = iota + 1
  /**
   * A published index using a methodology defined by the publisher, e.g. S&P 500.
   */
  INDEX FloatingRateIndexStyleEnum = iota + 1
  OTHER FloatingRateIndexStyleEnum = iota + 1
  OVERNIGHT FloatingRateIndexStyleEnum = iota + 1
  /**
   *  A published rate computed using an averaging methodology.
   */
  PUBLISHED_AVERAGE FloatingRateIndexStyleEnum = iota + 1
  SPECIFIED_FORMULA FloatingRateIndexStyleEnum = iota + 1
  /**
   * A rate representing the market rate for swaps of a given maturity.
   */
  SWAP_RATE FloatingRateIndexStyleEnum = iota + 1
  /**
   * A rate specified over a given term, such as a libor-type rate.
   */
  TERM_RATE FloatingRateIndexStyleEnum = iota + 1
  )    
