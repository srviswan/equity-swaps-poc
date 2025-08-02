# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AveragingCalculationMethodEnum']

class AveragingCalculationMethodEnum(Enum):
    """
    Specifies enumerations for the type of averaging calculation.
    """
    ARITHMETIC = "Arithmetic"
    """
    Refers to the calculation of an average by taking the sum of observations divided by the count of observations.
    """
    GEOMETRIC = "Geometric"
    """
    Refers to the calculation of an average by taking the nth root of the product of n observations.
    """
    HARMONIC = "Harmonic"
    """
    Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations.
    """
