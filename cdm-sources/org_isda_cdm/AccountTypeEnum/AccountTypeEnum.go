/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package AccountTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumeration values to qualify the type of account.
   */
  
  const (
  /**
   * Aggregate client account, as defined under ESMA MiFIR.
   */
  AGGREGATE_CLIENT AccountTypeEnum = iota + 1
  /**
   * The account contains trading activity or positions that belong to a client of the firm that opened the account.
   */
  CLIENT AccountTypeEnum = iota + 1
  /**
   * The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account.
   */
  HOUSE AccountTypeEnum = iota + 1
  )    
