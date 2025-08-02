/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package DividendAmountTypeEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify whether the dividend is paid with respect to the Dividend Period.
   */
  
  const (
  /**
   * The Amount is determined as provided in the relevant Master Confirmation.
   */
  AS_SPECIFIED_IN_MASTER_CONFIRMATION DividendAmountTypeEnum = iota + 1
  /**
   * The ex-date for a dividend occurs during a dividend period.
   */
  EX_AMOUNT DividendAmountTypeEnum = iota + 1
  /**
   * The payment date for a dividend occurs during a dividend period.
   */
  PAID_AMOUNT DividendAmountTypeEnum = iota + 1
  /**
   * The record date for a dividend occurs during a dividend period.
   */
  RECORD_AMOUNT DividendAmountTypeEnum = iota + 1
  )    
