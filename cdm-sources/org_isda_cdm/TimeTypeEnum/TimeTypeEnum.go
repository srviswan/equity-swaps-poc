/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package TimeTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify points in the day when option exercise and valuation can occur.
   */
  
  const (
  /**
   * The time is determined as provided in the relevant Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION TimeTypeEnum = iota + 1
  /**
   * The official closing time of the exchange on the valuation date.
   */
  CLOSE TimeTypeEnum = iota + 1
  /**
   * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlier.
   */
  DERIVATIVES_CLOSE TimeTypeEnum = iota + 1
  /**
   * The time at which the official settlement price is determined.
   */
  OSP TimeTypeEnum = iota + 1
  /**
   * The official opening time of the exchange on the valuation date.
   */
  OPEN TimeTypeEnum = iota + 1
  /**
   * The time specified in the element equityExpirationTime or valuationTime (as appropriate).
   */
  SPECIFIC_TIME TimeTypeEnum = iota + 1
  /**
   * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
   */
  XETRA TimeTypeEnum = iota + 1
  )    
