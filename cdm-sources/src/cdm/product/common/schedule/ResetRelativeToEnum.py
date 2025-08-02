# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ResetRelativeToEnum']

class ResetRelativeToEnum(Enum):
    """
    The enumerated values to specify whether resets occur relative to the first or last day of a calculation period.
    """
    CALCULATION_PERIOD_END_DATE = "CalculationPeriodEndDate"
    """
    Resets occur relative to the last day of a calculation period.
    """
    CALCULATION_PERIOD_START_DATE = "CalculationPeriodStartDate"
    """
    Resets occur relative to the first day of a calculation period.
    """
