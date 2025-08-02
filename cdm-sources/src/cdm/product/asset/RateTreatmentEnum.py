# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RateTreatmentEnum']

class RateTreatmentEnum(Enum):
    """
    The enumerated values to specify the methods for converting rates from one basis to another.
    """
    BOND_EQUIVALENT_YIELD = "BondEquivalentYield"
    """
    Bond Equivalent Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (g).
    """
    MONEY_MARKET_YIELD = "MoneyMarketYield"
    """
    Money Market Yield. Per Annex to the 2000 ISDA Definitions (June 2000 Version), Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraph (h).
    """
