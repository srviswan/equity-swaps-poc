/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DebtSeniorityEnum
  import . "org_isda_cdm"
  /**
   * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
   */
  
  const (
  /**
   * Denotes debt which is secured over assets of the issuer or a related party (eg guarantor).
   */
  SECURED DebtSeniorityEnum = iota + 1
  /**
   * Denotes debt  which ranks pari passu with all other unsecured creditors of the issuer.
   */
  SENIOR DebtSeniorityEnum = iota + 1
  /**
   * Denotes debt  owed to an unsecured creditor that in the event of a liquidation can only be paid after the claims of secured and senior creditors have been met.
   */
  SUBORDINATED DebtSeniorityEnum = iota + 1
  )    
