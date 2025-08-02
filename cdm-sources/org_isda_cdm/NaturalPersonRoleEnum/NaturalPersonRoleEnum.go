/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package NaturalPersonRoleEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values for the natural person's role.
   */
  
  const (
  /**
   * The person who arranged with a client to execute the trade.
   */
  BROKER NaturalPersonRoleEnum = iota + 1
  /**
   * Acquirer of the legal title to the financial instrument.
   */
  BUYER NaturalPersonRoleEnum = iota + 1
  /**
   * The party or person with legal responsibility for authorization of the execution of the transaction.
   */
  DECISION_MAKER NaturalPersonRoleEnum = iota + 1
  /**
   * Person within the firm who is responsible for execution of the transaction.
   */
  EXECUTION_WITHIN_FIRM NaturalPersonRoleEnum = iota + 1
  /**
   * Person who is responsible for making the investment decision.
   */
  INVESTMENT_DECISION_MAKER NaturalPersonRoleEnum = iota + 1
  /**
   * Seller of the legal title to the financial instrument.
   */
  SELLER NaturalPersonRoleEnum = iota + 1
  /**
   * The person who executed the trade.
   */
  TRADER NaturalPersonRoleEnum = iota + 1
  )    
