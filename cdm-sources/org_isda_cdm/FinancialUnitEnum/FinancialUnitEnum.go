/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package FinancialUnitEnum
  import . "org_isda_cdm"
  /**
   * Provides enumerated values for financial units, generally used in the context of defining quantities for securities.
   */
  
  const (
  /**
   * Denotes financial contracts, such as listed futures and options.
   */
  CONTRACT FinancialUnitEnum = iota + 1
  /**
   * Denotes a Contractual Product as defined in the CDM.  This unit type would be used when the price applies to the whole product, for example, in the case of a premium expressed as a cash amount.
   */
  CONTRACTUAL_PRODUCT FinancialUnitEnum = iota + 1
  /**
   * Denotes a price expressed in index points, e.g. for a stock index.
   */
  INDEX_UNIT FinancialUnitEnum = iota + 1
  /**
   * Denotes a log normal volatility, expressed in %/month, where the percentage is represented as a decimal. For example, 0.15 means a log-normal volatility of 15% per month.
   */
  LOG_NORMAL_VOLATILITY FinancialUnitEnum = iota + 1
  /**
   * Denotes the number of units of financial stock shares.
   */
  SHARE FinancialUnitEnum = iota + 1
  /**
   * Denotes a value (expressed in currency units) for a one day change in a valuation date, which is typically used for expressing sensitivity to the passage of time, also known as theta risk, or carry, or other names.
   */
  VALUE_PER_DAY FinancialUnitEnum = iota + 1
  /**
   * Denotes a value (expressed in currency units) per percent change in the underlying rate which is typically used for expressing sensitivity to volatility changes, also known as vega risk.
   */
  VALUE_PER_PERCENT FinancialUnitEnum = iota + 1
  /**
   * Denotes a quantity (expressed as a decimal value) represented the weight of a component in a basket.
   */
  WEIGHT FinancialUnitEnum = iota + 1
  )    
