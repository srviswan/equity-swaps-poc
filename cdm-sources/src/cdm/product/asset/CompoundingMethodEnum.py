# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CompoundingMethodEnum']

class CompoundingMethodEnum(Enum):
    """
    The enumerated values to specify the type of compounding, e.g. flat, straight.
    """
    FLAT = "Flat"
    """
    Flat compounding. Compounding excludes the spread. Note that the first compounding period has it's interest calculated including any spread then subsequent periods compound this at a rate excluding the spread.
    """
    NONE = "None"
    """
    No compounding is to be applied.
    """
    SPREAD_EXCLUSIVE = "SpreadExclusive"
    """
    Spread Exclusive compounding.
    """
    STRAIGHT = "Straight"
    """
    Straight compounding. Compounding includes the spread.
    """
