/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package QuotationStyleEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg.
   */
  
  const (
  /**
   * When quotation style is 'PointsUpFront', the initialPoints element of the Credit Default Swap feeLeg should be populated
   */
  POINTS_UP_FRONT QuotationStyleEnum = iota + 1
  /**
   * When quotation style is 'Price', the marketPrice element of the Credit Default Swap feeLeg should be populated
   */
  PRICE QuotationStyleEnum = iota + 1
  /**
   * When quotation style is 'TradedSpread', the marketFixedRate element of the Credit Default Swap feeLeg should be populated
   */
  TRADED_SPREAD QuotationStyleEnum = iota + 1
  )    
