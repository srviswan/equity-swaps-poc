# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['FPVFinalPriceElectionFallbackEnum']

class FPVFinalPriceElectionFallbackEnum(Enum):
    """
    Specifies the fallback provisions in respect to the applicable Futures Price Valuation.
    """
    FPV_CLOSE = "FPVClose"
    """
    In respect of the Early Final Valuation Date, the provisions for FPV Close shall apply.
    """
    FPV_HEDGE_EXECUTION = "FPVHedgeExecution"
    """
    In respect of the Early Final Valuation Date, the provisions for FPV Hedge Execution shall apply.
    """
