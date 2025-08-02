# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RoundingFrequencyEnum']

class RoundingFrequencyEnum(Enum):
    """
    How often is rounding performed
    """
    DAILY = "Daily"
    """
    Rounding is done on each day
    """
    PERIOD_END = "PeriodEnd"
    """
    Rounding is done only at the end of the period
    """
