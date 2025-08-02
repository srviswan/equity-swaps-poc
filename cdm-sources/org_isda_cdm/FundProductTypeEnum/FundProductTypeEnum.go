/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package FundProductTypeEnum
  import . "org_isda_cdm"
  /**
   * Represents an enumeration list to identify the fund product type.
   */
  
  const (
  /**
   * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is passively managed and traded on a stock exchange.
   */
  EXCHANGE_TRADED_FUND FundProductTypeEnum = iota + 1
  /**
   * Denotes a fund that invests only in highly liquid near-term instruments such as cash, cash equivalent securities, and high credit rating debt instruments with a short-term maturity.
   */
  MONEY_MARKET_FUND FundProductTypeEnum = iota + 1
  /**
   * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is actively managed and can only be purchased or sold through the investment manager.
   */
  MUTUAL_FUND FundProductTypeEnum = iota + 1
  /**
   * Denotes a fund that is not an Exchange Traded Fund, Money Market Fund or Mutual Fund.
   */
  OTHER_FUND FundProductTypeEnum = iota + 1
  )    
