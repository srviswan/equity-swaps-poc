/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package TransferSettlementEnum
  import . "org_isda_cdm"
  /**
   * The enumeration values to specify how the transfer will settle, e.g. DvP.
   */
  
  const (
  /**
   * Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk.
   */
  DELIVERY_VERSUS_DELIVERY TransferSettlementEnum = iota + 1
  /**
   * Settlement in which the transfer of the asset and the cash settlement are simultaneous.
   */
  DELIVERY_VERSUS_PAYMENT TransferSettlementEnum = iota + 1
  /**
   * No central settlement.
   */
  NOT_CENTRAL_SETTLEMENT TransferSettlementEnum = iota + 1
  /**
   * Simultaneous transfer of cashflows.
   */
  PAYMENT_VERSUS_PAYMENT TransferSettlementEnum = iota + 1
  )    
