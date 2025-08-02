# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CalculationMethodEnum']

class CalculationMethodEnum(Enum):
    """
    What calculation type is required, averaging or compounding. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
    """
    AVERAGING = "Averaging"
    """
    Averaging, i.e. arithmetic averaging.
    """
    COMPOUNDED_INDEX = "CompoundedIndex"
    """
    A rate based on an index that is computed by a rate administrator.  The user is responsible for backing out the rate by applying a simple formula.
    """
    COMPOUNDING = "Compounding"
    """
    Compounding, i.e. geometric averaging following an ISDA defined formula.
    """
