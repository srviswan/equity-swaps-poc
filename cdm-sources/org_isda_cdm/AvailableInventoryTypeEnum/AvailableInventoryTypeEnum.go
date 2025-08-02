/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package AvailableInventoryTypeEnum
  import . "org_isda_cdm"
  /**
   * Enumeration to describe the type of AvailableInventory
   */
  
  const (
  /**
   * Where a lender is broadcasting the securities that they have available to lend
   */
  AVAILABLE_TO_LEND AvailableInventoryTypeEnum = iota + 1
  /**
   * Where a party is asking a lender if they have specific securities available for them to borrow
   */
  REQUEST_TO_BORROW AvailableInventoryTypeEnum = iota + 1
  )    
