# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TimeUnitEnum']

class TimeUnitEnum(Enum):
    """
    The enumeration values to qualify the allowed units of time.
    """
    DAY = "Day"
    """
    Day
    """
    HOUR = "Hour"
    """
    Hour
    """
    MINUTE = "Minute"
    """
    Minute
    """
    MONTH = "Month"
    """
    Month
    """
    SECOND = "Second"
    """
    Second
    """
    WEEK = "Week"
    """
    Week
    """
    YEAR = "Year"
    """
    Year
    """
