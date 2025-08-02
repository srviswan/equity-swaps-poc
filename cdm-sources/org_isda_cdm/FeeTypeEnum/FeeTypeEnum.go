/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package FeeTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify an event that has given rise to a fee.
   */
  
  const (
  /**
   * A cash flow resulting from the assignment of a contract to a new counterparty.
   */
  ASSIGNMENT FeeTypeEnum = iota + 1
  /**
   * The brokerage commission.
   */
  BROKERAGE_COMMISSION FeeTypeEnum = iota + 1
  /**
   * A cash flow associated with a corporate action
   */
  CORPORATE_ACTION FeeTypeEnum = iota + 1
  /**
   * A cash flow associated with a credit event.
   */
  CREDIT_EVENT FeeTypeEnum = iota + 1
  /**
   * A cash flow associated with an increase lifecycle event.
   */
  INCREASE FeeTypeEnum = iota + 1
  /**
   * The novation fee.
   */
  NOVATION FeeTypeEnum = iota + 1
  /**
   * A cash flow associated with a partial termination lifecycle event.
   */
  PARTIAL_TERMINATION FeeTypeEnum = iota + 1
  /**
   * Denotes the amount payable by the buyer to the seller for an option. The premium is paid on the specified premium payment date or on each premium payment date if specified.
   */
  PREMIUM FeeTypeEnum = iota + 1
  /**
   * A cash flow associated with a renegotiation lifecycle event.
   */
  RENEGOTIATION FeeTypeEnum = iota + 1
  /**
   * A cash flow associated with a termination lifecycle event.
   */
  TERMINATION FeeTypeEnum = iota + 1
  /**
   * An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
   */
  UPFRONT FeeTypeEnum = iota + 1
  )    
