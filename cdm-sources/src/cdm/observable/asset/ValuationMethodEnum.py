# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ValuationMethodEnum']

class ValuationMethodEnum(Enum):
    """
    The enumerated values to specify the ISDA defined methodology for determining the final price of the reference obligation for purposes of cash settlement.
    """
    AVERAGE_BLENDED_HIGHEST = "AverageBlendedHighest"
    AVERAGE_BLENDED_MARKET = "AverageBlendedMarket"
    AVERAGE_HIGHEST = "AverageHighest"
    AVERAGE_MARKET = "AverageMarket"
    BLENDED_HIGHEST = "BlendedHighest"
    BLENDED_MARKET = "BlendedMarket"
    HIGHEST = "Highest"
    MARKET = "Market"
