/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package TriggerTimeTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the time of day which would be considered for valuing the knock event.
   */
  
  const (
  /**
   * At any time during the Knock Determination period (continuous barrier).
   */
  ANYTIME TriggerTimeTypeEnum = iota + 1
  /**
   * The close of trading on a day would be considered for valuation.
   */
  CLOSING TriggerTimeTypeEnum = iota + 1
  )    
