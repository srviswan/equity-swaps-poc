/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CallTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumeration values that indicate the intended status of message type, such as expected call, notification of a call or a margin call.
   */
  
  const (
  /**
   * Identifies an expected Margin Call instruction for either party to notify the other or their service provider of an expected margin call movement.
   */
  EXPECTED_CALL CallTypeEnum = iota + 1
  /**
   * Identifies an actionable Margin Call.
   */
  MARGIN_CALL CallTypeEnum = iota + 1
  /**
   * Identifies a notification of a Margin Call for legal obligation to notify other party to initiate a margin call when notifying party is calculation or valuation agent.
   */
  NOTIFICATION CallTypeEnum = iota + 1
  )    
