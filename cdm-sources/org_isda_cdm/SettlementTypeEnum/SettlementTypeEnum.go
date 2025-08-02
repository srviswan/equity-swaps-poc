/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package SettlementTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumeration values to specify how the option is to be settled when exercised.
   */
  
  const (
  /**
   * The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties.
   */
  CASH SettlementTypeEnum = iota + 1
  /**
   * Allow use of either Cash or Physical settlement without prior Election.
   */
  CASH_OR_PHYSICAL SettlementTypeEnum = iota + 1
  /**
   * Allow Election of either Cash or Physical settlement.
   */
  ELECTION SettlementTypeEnum = iota + 1
  /**
   * The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share.
   */
  PHYSICAL SettlementTypeEnum = iota + 1
  )    
