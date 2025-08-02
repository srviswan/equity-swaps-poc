/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package ExpirationTimeTypeEnum
  import . "org_isda_cdm"
  /**
   * The time of day at which the equity option expires, for example the official closing time of the exchange.
   */
  
  const (
  /**
   * The time is determined as provided in the relevant Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION ExpirationTimeTypeEnum = iota + 1
  /**
   * The official closing time of the exchange on the valuation date.
   */
  CLOSE ExpirationTimeTypeEnum = iota + 1
  /**
   * The official closing time of the derivatives exchange on which a derivative contract is listed on that security underlyer.
   */
  DERIVATIVES_CLOSE ExpirationTimeTypeEnum = iota + 1
  /**
   * The time at which the official settlement price is determined.
   */
  OSP ExpirationTimeTypeEnum = iota + 1
  /**
   * The official opening time of the exchange on the valuation date.
   */
  OPEN ExpirationTimeTypeEnum = iota + 1
  /**
   * The time specified in the element equityExpirationTime or valuationTime (as appropriate)
   */
  SPECIFIC_TIME ExpirationTimeTypeEnum = iota + 1
  /**
   * The time at which the official settlement price (following the auction by the exchange) is determined by the exchange.
   */
  XETRA ExpirationTimeTypeEnum = iota + 1
  )    
