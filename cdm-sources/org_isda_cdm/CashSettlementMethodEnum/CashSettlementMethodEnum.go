/**
 * This file is auto-generated from the ISDA Common Domain Model, do not edit.
 * Version: 6.0.0
 */
  package CashSettlementMethodEnum
  import . "org_isda_cdm"
  /**
   * Defines the different cash settlement methods for a product where cash settlement is applicable.
   */
  
  const (
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
   */
  CASH_PRICE_ALTERNATE_METHOD CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
   */
  CASH_PRICE_METHOD CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6.
   */
  COLLATERALIZED_CASH_PRICE_METHOD CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
   */
  CROSS_CURRENCY_METHOD CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
   */
  MID_MARKET_CALCULATION_AGENT_DETERMINATION CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
   */
  MID_MARKET_INDICATIVE_QUOTATIONS CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
   */
  MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
   */
  PAR_YIELD_CURVE_ADJUSTED_METHOD CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
   */
  PAR_YIELD_CURVE_UNADJUSTED_METHOD CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5
   */
  REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
   */
  REPLACEMENT_VALUE_FIRM_QUOTATIONS CashSettlementMethodEnum = iota + 1
  /**
   * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
   */
  ZERO_COUPON_YIELD_ADJUSTED_METHOD CashSettlementMethodEnum = iota + 1
  )    
