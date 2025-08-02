# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SpreadScheduleTypeEnum']

class SpreadScheduleTypeEnum(Enum):
    """
    The enumerated values to specify a long or short spread value.
    """
    LONG = "Long"
    """
    Represents a Long Spread Schedule. Spread schedules defined as 'Long' will be applied to Long Positions.
    """
    SHORT = "Short"
    """
    Represents a Short Spread Schedule. Spread schedules defined as 'Short' will be applied to Short Positions.
    """
