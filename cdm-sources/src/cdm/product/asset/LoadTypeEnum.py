# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['LoadTypeEnum']

class LoadTypeEnum(Enum):
    """
    Specifies the load type of the delivery.
    """
    BASE_LOAD = "BaseLoad"
    """
    Base load
    """
    BLOCK_HOURS = "BlockHours"
    """
    Block Hours
    """
    GAS_DAY = "GasDay"
    """
    Gas Day
    """
    OFF_PEAK = "OffPeak"
    """
    Off-peak load
    """
    OTHER = "Other"
    """
    Other
    """
    PEAK_LOAD = "PeakLoad"
    """
    Peak load
    """
    SHAPED = "Shaped"
    """
    Shaped
    """
