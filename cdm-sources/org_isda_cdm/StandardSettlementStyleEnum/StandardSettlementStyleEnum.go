/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package StandardSettlementStyleEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting.
   */
  
  const (
  /**
   * This trade is a candidate for settlement netting.
   */
  NET StandardSettlementStyleEnum = iota + 1
  /**
   * These trades have been paired and are a candidate for settlement netting.
   */
  PAIR_AND_NET StandardSettlementStyleEnum = iota + 1
  /**
   * This trade will settle using standard predetermined funds settlement instructions.
   */
  STANDARD StandardSettlementStyleEnum = iota + 1
  /**
   * This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting.
   */
  STANDARD_AND_NET StandardSettlementStyleEnum = iota + 1
  )    
