/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DeterminationMethodEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the method according to which an amount or a date is determined.
   */
  
  const (
  /**
   * Agreed separately between the parties.
   */
  AGREED_INITIAL_PRICE DeterminationMethodEnum = iota + 1
  /**
   * As specified in Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION DeterminationMethodEnum = iota + 1
  /**
   * Determined by the Calculation Agent.
   */
  CALCULATION_AGENT DeterminationMethodEnum = iota + 1
  /**
   * Official Closing Price.
   */
  CLOSING_PRICE DeterminationMethodEnum = iota + 1
  /**
   * Determined by the Currency of Equity Dividends.
   */
  DIVIDEND_CURRENCY DeterminationMethodEnum = iota + 1
  /**
   * The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation.
   */
  EXPIRING_CONTRACT_LEVEL DeterminationMethodEnum = iota + 1
  /**
   * Determined by the Hedging Party.
   */
  HEDGE_EXECUTION DeterminationMethodEnum = iota + 1
  /**
   * Issuer Payment Currency.
   */
  ISSUER_PAYMENT_CURRENCY DeterminationMethodEnum = iota + 1
  /**
   * Net Asset Value.
   */
  NAV DeterminationMethodEnum = iota + 1
  /**
   * OSP Price.
   */
  OSP_PRICE DeterminationMethodEnum = iota + 1
  /**
   * Opening Price of the Market.
   */
  OPEN_PRICE DeterminationMethodEnum = iota + 1
  /**
   * Settlement Currency.
   */
  SETTLEMENT_CURRENCY DeterminationMethodEnum = iota + 1
  /**
   * Date on which the strike is determined in respect of a forward starting swap.
   */
  STRIKE_DATE_DETERMINATION DeterminationMethodEnum = iota + 1
  /**
   * Official TWAP Price.
   */
  TWAP_PRICE DeterminationMethodEnum = iota + 1
  /**
   * Official VWAP Price.
   */
  VWAP_PRICE DeterminationMethodEnum = iota + 1
  /**
   * Price determined at valuation time.
   */
  VALUATION_TIME DeterminationMethodEnum = iota + 1
  )    
