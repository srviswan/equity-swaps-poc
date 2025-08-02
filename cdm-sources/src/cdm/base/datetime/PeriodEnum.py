# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PeriodEnum']

class PeriodEnum(Enum):
    """
    The enumerated values to specify the period, e.g. day, week.
    """
    D = "D"
    """
    Day
    """
    M = "M"
    """
    Month
    """
    W = "W"
    """
    Week
    """
    Y = "Y"
    """
    Year
    """
