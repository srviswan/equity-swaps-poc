# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['NegativeInterestRateTreatmentEnum']

class NegativeInterestRateTreatmentEnum(Enum):
    """
    The enumerated values to specify the method of calculating payment obligations when a floating rate is negative (either due to a quoted negative floating rate or by operation of a spread that is subtracted from the floating rate).
    """
    NEGATIVE_INTEREST_RATE_METHOD = "NegativeInterestRateMethod"
    """
    Negative Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4 Negative Interest Rates, paragraphs (b) and (c).
    """
    ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD = "ZeroInterestRateExcludingSpreadMethod"
    """
    Per 2021 ISDA Definitions section 6.8.6
    """
    ZERO_INTEREST_RATE_METHOD = "ZeroInterestRateMethod"
    """
    Zero Interest Rate Method. Per 2000 ISDA Definitions, Section 6.4. Negative Interest Rates, paragraphs (d) and (e).
    """
