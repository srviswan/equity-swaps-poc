/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package NotionalAdjustmentEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
   */
  
  const (
  /**
   * The adjustments to the number of units are governed by an execution clause.
   */
  EXECUTION NotionalAdjustmentEnum = iota + 1
  /**
   * The adjustments to the number of units are governed by a portfolio rebalancing clause.
   */
  PORTFOLIO_REBALANCING NotionalAdjustmentEnum = iota + 1
  /**
   * The adjustments to the number of units are not governed by any specific clause.
   */
  STANDARD NotionalAdjustmentEnum = iota + 1
  )    
