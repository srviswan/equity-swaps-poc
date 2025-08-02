# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['WeatherUnitEnum']

class WeatherUnitEnum(Enum):
    """
    Provides enumerated values for weather units, generally used in the context of defining quantities for commodities.
    """
    CDD = "CDD"
    """
    Denotes Cooling Degree Days as a standard unit.
    """
    CPD = "CPD"
    """
    Denotes Critical Precipitation Day as a standard unit.
    """
    HDD = "HDD"
    """
    Heating Degree Day as a standard unit.
    """
