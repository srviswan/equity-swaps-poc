/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package PeriodExtendedEnum
  import . "org_isda_cdm"
  /**
   * The enumerated values to specify a time period containing the additional value of Term.
   */
  
  const (
  /**
   * CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period.
   */
  C PeriodExtendedEnum = iota + 1
  /**
   * Day
   */
  D PeriodExtendedEnum = iota + 1
  /**
   * Hour
   */
  H PeriodExtendedEnum = iota + 1
  /**
   * Month
   */
  M PeriodExtendedEnum = iota + 1
  /**
   * Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade.
   */
  T PeriodExtendedEnum = iota + 1
  /**
   * Week
   */
  W PeriodExtendedEnum = iota + 1
  /**
   * Year
   */
  Y PeriodExtendedEnum = iota + 1
  )    
