# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PerformanceTransferTypeEnum']

class PerformanceTransferTypeEnum(Enum):
    """
    The enumerated values to specify the origin of a performance transfer
    """
    COMMODITY = "Commodity"
    CORRELATION = "Correlation"
    DIVIDEND = "Dividend"
    EQUITY = "Equity"
    INTEREST = "Interest"
    VARIANCE = "Variance"
    VOLATILITY = "Volatility"
