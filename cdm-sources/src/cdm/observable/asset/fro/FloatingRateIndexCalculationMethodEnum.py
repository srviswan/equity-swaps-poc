# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['FloatingRateIndexCalculationMethodEnum']

class FloatingRateIndexCalculationMethodEnum(Enum):
    """
    3rd level ISDA FRO category.
    """
    ALL_IN_COMPOUNDED = "All-In Compounded Index"
    AVERAGE = "Overnight Averaging"
    """
    A calculation methodology using the arithmetic mean.
    """
    COMPOUNDED = "Compounded Index"
    OIS_COMPOUND = "OIS Compounding"
    """
    A calculation methodology using the ISDA-defined OIS compounding formula.
    """
