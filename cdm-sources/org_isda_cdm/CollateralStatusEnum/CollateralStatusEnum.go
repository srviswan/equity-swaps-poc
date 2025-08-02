/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CollateralStatusEnum
  import . "org_isda_cdm"
  /**
   * Represents the enumeration list to identify the settlement status of the collateral.
   */
  
  const (
  /**
   * Indicates the collateral balance amount in full, inclusive of any pre-agreed collateral positions in transit for settlement.
   */
  FULL_AMOUNT CollateralStatusEnum = iota + 1
  /**
   * Indicates collateral amount in transit settlement cycle only, excluding settled collateral amount/s.
   */
  IN_TRANSIT_AMOUNT CollateralStatusEnum = iota + 1
  /**
   * Indicates the collateral is settled and not an in transit pre-agreed collateral amount/s.
   */
  SETTLED_AMOUNT CollateralStatusEnum = iota + 1
  )    
