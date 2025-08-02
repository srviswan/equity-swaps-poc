/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CreditSeniorityEnum
  import . "org_isda_cdm"
  /**
   * Seniority of debt instruments comprising the index.
   */
  
  const (
  /**
   * Other as defined under EMIR.
   */
  OTHER CreditSeniorityEnum = iota + 1
  /**
   * Senior Loss Absorbing Capacity (RED Tier Code: SNRLAC).
   */
  SENIOR_LOSS_ABSORBING_CAPACITY CreditSeniorityEnum = iota + 1
  /**
   * Senior domestic (RED Tier Code: SECDOM).
   */
  SENIOR_SEC CreditSeniorityEnum = iota + 1
  /**
   * Senior foreign (RED Tier Code: SNRFOR).
   */
  SENIOR_UN_SEC CreditSeniorityEnum = iota + 1
  /**
   * Subordinate, Lower Tier 2 (RED Tier Code: SUBLT2).
   */
  SUB_LOWER_TIER_2 CreditSeniorityEnum = iota + 1
  /**
   * Subordinate Tier 1 (RED Tier Code: PREFT1).
   */
  SUB_TIER_1 CreditSeniorityEnum = iota + 1
  /**
   * Subordinate, Tier 3.
   */
  SUB_TIER_3 CreditSeniorityEnum = iota + 1
  /**
   * Subordinate, Upper Tier 2 (RED Tier Code: JRSUBUT2).
   */
  SUB_UPPER_TIER_2 CreditSeniorityEnum = iota + 1
  )    
