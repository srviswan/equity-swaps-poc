# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['InterestShortfallCapEnum']

class InterestShortfallCapEnum(Enum):
    """
    The enumerated values to specify the interest shortfall cap, applicable to mortgage derivatives.
    """
    FIXED = "Fixed"
    VARIABLE = "Variable"
