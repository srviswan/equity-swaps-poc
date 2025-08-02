# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ObservationPeriodDatesEnum']

class ObservationPeriodDatesEnum(Enum):
    """
    The enumerated values to specify whether rate calculations occur relative to the first or last day of a calculation period. Done in uppercase due to a bug in code generation. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
    """
    FIXING_DATE = "FixingDate"
    """
    Calculations occur relative to a previously defined reset date, e.g. for a fallback rate.
    """
    SET_IN_ADVANCE = "SetInAdvance"
    """
    Calculations occur relative to the first day of a calculation period.
    """
    STANDARD = "Standard"
    """
    Calculations occur relative to the last day of a calculation period (set in arrears).
    """
