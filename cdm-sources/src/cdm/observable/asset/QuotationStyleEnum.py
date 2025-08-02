# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['QuotationStyleEnum']

class QuotationStyleEnum(Enum):
    """
    The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg.
    """
    POINTS_UP_FRONT = "PointsUpFront"
    """
    When quotation style is 'PointsUpFront', the initialPoints element of the Credit Default Swap feeLeg should be populated
    """
    PRICE = "Price"
    """
    When quotation style is 'Price', the marketPrice element of the Credit Default Swap feeLeg should be populated
    """
    TRADED_SPREAD = "TradedSpread"
    """
    When quotation style is 'TradedSpread', the marketFixedRate element of the Credit Default Swap feeLeg should be populated
    """
