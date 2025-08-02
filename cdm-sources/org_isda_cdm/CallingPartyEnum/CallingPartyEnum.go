/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CallingPartyEnum
  import . "org_isda_cdm"
  /**
   * Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction.
   */
  
  const (
  /**
   * As defined in Master Agreement.
   */
  AS_DEFINED_IN_MASTER_AGREEMENT CallingPartyEnum = iota + 1
  /**
   * Either, Buyer or Seller to the repo transaction.
   */
  EITHER CallingPartyEnum = iota + 1
  /**
   * Initial buyer to the repo transaction.
   */
  INITIAL_BUYER CallingPartyEnum = iota + 1
  /**
   * Initial seller to the repo transaction.
   */
  INITIAL_SELLER CallingPartyEnum = iota + 1
  )    
