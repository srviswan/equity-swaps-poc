/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CollateralTypeEnum
  import . "org_isda_cdm"
  /**
   * Specifies the types of collateral that are accepted by the Lender
   */
  
  const (
  /**
   * Security Lending Trades against Cash collateral
   */
  CASH CollateralTypeEnum = iota + 1
  /**
   * Security Lending Trades against CashPool collateral
   */
  CASH_POOL CollateralTypeEnum = iota + 1
  /**
   * Security Lending Trades against NonCash collateral
   */
  NON_CASH CollateralTypeEnum = iota + 1
  )    
