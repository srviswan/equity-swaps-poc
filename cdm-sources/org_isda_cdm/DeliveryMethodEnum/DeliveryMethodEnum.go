/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DeliveryMethodEnum
  import . "org_isda_cdm"
  /**
   * Specifies delivery methods for securities transactions. This coding-scheme defines the possible delivery methods for securities.
   */
  
  const (
  /**
   * Indicates that a securities delivery must be made against payment in simultaneous transmissions and stipulate each other.
   */
  DELIVERY_VERSUS_PAYMENT DeliveryMethodEnum = iota + 1
  /**
   * Indicates that a securities delivery can be made without a simultaneous cash payment in exchange and not depending on if payment obligations are fulfilled or not and vice versa.
   */
  FREE_OF_PAYMENT DeliveryMethodEnum = iota + 1
  /**
   * Indicates that a securities delivery must be made in full before the payment for the securities; fulfillment of payment obligations depends on securities delivery obligations fulfillment.
   */
  PRE_DELIVERY DeliveryMethodEnum = iota + 1
  /**
   * Indicates that a payment in full amount must be made before the securities delivery; fulfillment of securities delivery obligations depends on payment obligations fulfillment.
   */
  PRE_PAYMENT DeliveryMethodEnum = iota + 1
  )    
