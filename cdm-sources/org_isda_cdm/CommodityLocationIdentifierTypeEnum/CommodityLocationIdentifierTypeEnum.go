/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CommodityLocationIdentifierTypeEnum
  import . "org_isda_cdm"
  /**
   * Defines the enumerated values to specify the nature of a location identifier.
   */
  
  const (
  /**
   * The hub code of the buyer.
   */
  BUYER_HUB CommodityLocationIdentifierTypeEnum = iota + 1
  /**
   * The physical or virtual point at which the commodity will be delivered.
   */
  DELIVERY_POINT CommodityLocationIdentifierTypeEnum = iota + 1
  /**
   * The zone covering potential delivery points for the commodity
   */
  DELIVERY_ZONE CommodityLocationIdentifierTypeEnum = iota + 1
  /**
   * The physical or virtual point at which the commodity enters a transportation system.
   */
  ENTRY_POINT CommodityLocationIdentifierTypeEnum = iota + 1
  /**
   * Identification of the border(s) or border point(s) of a transportation contract.
   */
  INTERCONNECTION_POINT CommodityLocationIdentifierTypeEnum = iota + 1
  /**
   * The hub code of the seller.
   */
  SELLER_HUB CommodityLocationIdentifierTypeEnum = iota + 1
  /**
   * The physical or virtual point at which the commodity is withdrawn from a transportation system.
   */
  WITHDRAWAL_POINT CommodityLocationIdentifierTypeEnum = iota + 1
  )    
