/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package NationalizationOrInsolvencyOrDelistingEventEnum
  import . "org_isda_cdm"
  /**
   * Defines the consequences of nationalization, insolvency and delisting events relating to the underlying.
   */
  
  const (
  /**
   * The trade is terminated.
   */
  CANCELLATION_AND_PAYMENT NationalizationOrInsolvencyOrDelistingEventEnum = iota + 1
  /**
   * The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues.
   */
  NEGOTIATED_CLOSEOUT NationalizationOrInsolvencyOrDelistingEventEnum = iota + 1
  )    
