# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SpreadCalculationMethodEnum']

class SpreadCalculationMethodEnum(Enum):
    """
    Method by which spread is calculated. For example on an asset swap: 'ParPar' or 'Proceeds' may be the method indicated.
    """
    PAR_PAR = "ParPar"
    PROCEEDS = "Proceeds"
