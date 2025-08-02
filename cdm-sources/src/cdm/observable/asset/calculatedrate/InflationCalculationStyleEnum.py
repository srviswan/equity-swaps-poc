# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['InflationCalculationStyleEnum']

class InflationCalculationStyleEnum(Enum):
    """
    Indicates the style of how the inflation index calculates the payment (e.g. YearOnYear, ZeroCoupon).
    """
    YEAR_ON_YEAR = "YearOnYear"
    """
    YearOnYear means Inflation Index Base is the inflation index for Reference Month that is 12 months prior to Inflation Index Final (subject to interpolation). Inflation Index Base is cashflow dependent.
    """
    ZERO_COUPON = "ZeroCoupon"
    """
    ZeroCoupon means Inflation Index Base used in the CalculationMethod is the inflation index for the Reference Month that is the lag number of months prior to Effective Date in the case of a swap, or Bond Interest Accrual Date in the case of an Asset Swap (subject to interpolation). Inflation Index Base has the same value for each inflation cashflow and Principal Exchange calculation within the trade.
    """
