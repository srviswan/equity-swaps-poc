/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DeliveryNearbyTypeEnum
  import . "org_isda_cdm"
  
  const (
  /**
   * Describes the reference contract as the one that pertains to the month-year of the calculation period. If used, the nearby count is expected to be 0.
   */
  CALCULATION_PERIOD DeliveryNearbyTypeEnum = iota + 1
  /**
   * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby month.
   */
  NEARBY_MONTH DeliveryNearbyTypeEnum = iota + 1
  /**
   * Specifies that the reference delivery date of the underlying Commodity shall be the expiration date of the futures contract in the nth nearby week.
   */
  NEARBY_WEEK DeliveryNearbyTypeEnum = iota + 1
  )    
