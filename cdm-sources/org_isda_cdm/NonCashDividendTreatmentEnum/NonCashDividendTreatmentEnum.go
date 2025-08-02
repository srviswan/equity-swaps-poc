/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package NonCashDividendTreatmentEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the treatment of Non-Cash Dividends.
   */
  
  const (
  /**
   * Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend.
   */
  CASH_EQUIVALENT NonCashDividendTreatmentEnum = iota + 1
  /**
   * The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions.
   */
  POTENTIAL_ADJUSTMENT_EVENT NonCashDividendTreatmentEnum = iota + 1
  )    
