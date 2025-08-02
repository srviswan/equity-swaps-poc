/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package FinalPrincipalExchangeCalculationEnum
  import . "org_isda_cdm"
  /**
   * To be specified only for products that embed a redemption payment.
   */
  
  const (
  /**
   * If Floored is set then Principal Exchange takes the form: Notional Amount * Max(1, Index Final/ Index Base).
   */
  FLOORED FinalPrincipalExchangeCalculationEnum = iota + 1
  /**
   * If NonFloored is set then the Principal Exchange takes the form: Notional Amount * Index Final / Index Base.
   */
  NON_FLOORED FinalPrincipalExchangeCalculationEnum = iota + 1
  )    
