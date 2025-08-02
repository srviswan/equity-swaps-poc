# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['NonCashDividendTreatmentEnum']

class NonCashDividendTreatmentEnum(Enum):
    """
    The enumerated values to specify the treatment of Non-Cash Dividends.
    """
    CASH_EQUIVALENT = "CashEquivalent"
    """
    Any non-cash dividend shall be treated as a Declared Cash Equivalent Dividend.
    """
    POTENTIAL_ADJUSTMENT_EVENT = "PotentialAdjustmentEvent"
    """
    The treatment of any non-cash dividend shall be determined in accordance with the Potential Adjustment Event provisions.
    """
