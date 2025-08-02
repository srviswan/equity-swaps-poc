/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package ReturnTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the type of return associated the equity payout.
   */
  
  const (
  /**
   * Price return, i.e. excluding dividends.
   */
  PRICE ReturnTypeEnum = iota + 1
  /**
   * Total return, i.e. including dividend and price components.
   */
  TOTAL ReturnTypeEnum = iota + 1
  )    
