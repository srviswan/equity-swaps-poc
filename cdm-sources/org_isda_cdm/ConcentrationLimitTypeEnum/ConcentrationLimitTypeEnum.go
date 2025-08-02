/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package ConcentrationLimitTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumerated values to identify where a concentration limit is applied.
   */
  
  const (
  /**
   * Specifies a limit on a single asset in the portfolio
   */
  ASSET ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on all cash valued in the base currency of the portfolio.
   */
  BASE_CURRENCY_EQUIVALENT ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single industry sector in the portfolio.
   */
  INDUSTRY_SECTOR ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit of the issue compared to the outstanding amount of the asset on the market.
   */
  ISSUE_OUTSTANDING_AMOUNT ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single issuer in the portfolio.
   */
  ISSUER ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market.
   */
  MARKET_CAPITALISATION ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single exchange in the portfolio.
   */
  PRIMARY_EXCHANGE ConcentrationLimitTypeEnum = iota + 1
  /**
   * Specifies a limit on a single issuer in the portfolio at the ultimate parent institution level.
   */
  ULTIMATE_PARENT_INSTITUTION ConcentrationLimitTypeEnum = iota + 1
  )    
