/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package QuantityChangeDirectionEnum
  import . "org_isda_cdm"
  /**
   * Specifies whether a quantity change is an increase, a decrease or a replacement, whereby the quantity is always specified as a positive number.
   */
  
  const (
  /**
   * When the quantity should go down by the specified amount.
   */
  DECREASE QuantityChangeDirectionEnum = iota + 1
  /**
   * When the quantity should go up by the specified amount.
   */
  INCREASE QuantityChangeDirectionEnum = iota + 1
  /**
   * When the quantity should be replaced by the specified amount.
   */
  REPLACE QuantityChangeDirectionEnum = iota + 1
  )    
