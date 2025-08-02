/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DividendCompositionEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify how the composition of Dividends is to be determined.
   */
  
  const (
  /**
   * The Calculation Agent determines the composition of dividends (subject to conditions).
   */
  CALCULATION_AGENT_ELECTION DividendCompositionEnum = iota + 1
  /**
   * The Equity Amount Receiver determines the composition of dividends (subject to conditions).
   */
  EQUITY_AMOUNT_RECEIVER_ELECTION DividendCompositionEnum = iota + 1
  )    
