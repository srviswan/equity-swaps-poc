# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PeriodTimeEnum']

class PeriodTimeEnum(Enum):
    """
    The enumeration values to specify a time period containing additional values such as Term.
    """
    HOUR = "Hour"
    """
    Period measured in hours.
    """
    MINUTE = "Minute"
    """
    Period measured in minutes.
    """
    SECOND = "Second"
    """
    Period measured in seconds.
    """
