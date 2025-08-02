/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package MarginCallResponseTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumeration values to define the response type to a margin call.
   */
  
  const (
  /**
   * Specifies a 'Full Agreement' to Margin Call.
   */
  AGREEIN_FULL MarginCallResponseTypeEnum = iota + 1
  /**
   * Specifies a 'Full Dispute' to a Margin call.
   */
  DISPUTE MarginCallResponseTypeEnum = iota + 1
  /**
   * Specifies a 'Partial agreement' to Margin Call.
   */
  PARTIALLY_AGREE MarginCallResponseTypeEnum = iota + 1
  )    
