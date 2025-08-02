# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['DayDistributionEnum']

class DayDistributionEnum(Enum):
    """
    Denotes the method by which the pricing days are distributed across the pricing period.
    """
    ALL = "All"
    FIRST = "First"
    LAST = "Last"
    PENULTIMATE = "Penultimate"
