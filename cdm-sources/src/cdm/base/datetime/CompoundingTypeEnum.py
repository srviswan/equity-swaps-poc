# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CompoundingTypeEnum']

class CompoundingTypeEnum(Enum):
    """
    The enumerated values to specify how the compounding calculation is done
    """
    BUSINESS = "Business"
    """
    Compounding is done only on business days, i.e. not compounded each day on weekends or holidays.
    """
    CALENDAR = "Calendar"
    """
    Compounding is done on each calendar day.
    """
    NONE = "None"
    """
    Compounding is not applicable
    """
