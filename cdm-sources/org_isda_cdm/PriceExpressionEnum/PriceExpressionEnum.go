/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package PriceExpressionEnum
  import . "org_isda_cdm"
  /**
   * Enumerated values to specify whether the price is expressed in absolute or relative terms.
   */
  
  const (
  /**
   * The price is expressed as an absolute amount.
   */
  ABSOLUTE_TERMS PriceExpressionEnum = iota + 1
  /**
   * Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value.
   */
  PAR_VALUE_FRACTION PriceExpressionEnum = iota + 1
  /**
   * Denotes a price expressed per number of options.
   */
  PER_OPTION PriceExpressionEnum = iota + 1
  /**
   * The price is expressed in percentage of the notional amount.
   */
  PERCENTAGE_OF_NOTIONAL PriceExpressionEnum = iota + 1
  )    
