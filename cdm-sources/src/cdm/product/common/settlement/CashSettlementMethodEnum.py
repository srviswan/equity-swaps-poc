# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CashSettlementMethodEnum']

class CashSettlementMethodEnum(Enum):
    """
    Defines the different cash settlement methods for a product where cash settlement is applicable.
    """
    CASH_PRICE_ALTERNATE_METHOD = "CashPriceAlternateMethod"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
    """
    CASH_PRICE_METHOD = "CashPriceMethod"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
    """
    COLLATERALIZED_CASH_PRICE_METHOD = "CollateralizedCashPriceMethod"
    """
    An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6.
    """
    CROSS_CURRENCY_METHOD = "CrossCurrencyMethod"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
    """
    MID_MARKET_CALCULATION_AGENT_DETERMINATION = "MidMarketCalculationAgentDetermination"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
    """
    MID_MARKET_INDICATIVE_QUOTATIONS = "MidMarketIndicativeQuotations"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
    """
    MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE = "MidMarketIndicativeQuotationsAlternate"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
    """
    PAR_YIELD_CURVE_ADJUSTED_METHOD = "ParYieldCurveAdjustedMethod"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
    """
    PAR_YIELD_CURVE_UNADJUSTED_METHOD = "ParYieldCurveUnadjustedMethod"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
    """
    REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION = "ReplacementValueCalculationAgentDetermination"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5
    """
    REPLACEMENT_VALUE_FIRM_QUOTATIONS = "ReplacementValueFirmQuotations"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
    """
    ZERO_COUPON_YIELD_ADJUSTED_METHOD = "ZeroCouponYieldAdjustedMethod"
    """
    An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
    """
