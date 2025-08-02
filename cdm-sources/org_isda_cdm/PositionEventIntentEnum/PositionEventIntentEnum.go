/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package PositionEventIntentEnum
  import . "org_isda_cdm"
  
  const (
  /**
   * The intent is to take into effect the occurrence of a Corporate Action and the particular Corporate Action at stake shall be further specified in CorporateActionTypeEnum.
   */
  CORPORATE_ACTION_ADJUSTMENT PositionEventIntentEnum = iota + 1
  /**
   * The intent is to Decrease the quantity of the position.
   */
  DECREASE PositionEventIntentEnum = iota + 1
  /**
   * The intent is to Increase the quantity of the position.
   */
  INCREASE PositionEventIntentEnum = iota + 1
  /**
   * The intent is to Exercise a position or part of a position.
   */
  OPTION_EXERCISE PositionEventIntentEnum = iota + 1
  /**
   * The intent is to form a position from a fully formed contract.
   */
  POSITION_CREATION PositionEventIntentEnum = iota + 1
  /**
   * The intent is to transfer the position to another clearing member.
   */
  TRANSFER PositionEventIntentEnum = iota + 1
  /**
   * The intent is to update the valuation of the position.
   */
  VALUATION PositionEventIntentEnum = iota + 1
  )    
