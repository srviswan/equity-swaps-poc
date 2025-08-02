# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AverageTradingVolumeMethodologyEnum']

class AverageTradingVolumeMethodologyEnum(Enum):
    """
    Indicates the type of equity average trading volume (single) the highest amount on one exchange, or (consolidated) volumes across more than one exchange.
    """
    CONSOLIDATED = "Consolidated"
    """
    Consolidated volume across more than one exchange.
    """
    SINGLE = "Single"
    """
    Single, the highest amount on one exchange.
    """
