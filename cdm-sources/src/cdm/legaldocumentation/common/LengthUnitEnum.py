# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['LengthUnitEnum']

class LengthUnitEnum(Enum):
    """
    The enumerated values to specify the length unit in the Resource type.
    """
    PAGES = "Pages"
    TIME_UNIT = "TimeUnit"
