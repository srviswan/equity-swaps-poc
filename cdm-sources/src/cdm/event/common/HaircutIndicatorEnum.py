# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['HaircutIndicatorEnum']

class HaircutIndicatorEnum(Enum):
    """
    Represents the enumeration indicators to specify if an asset or group of assets valuation is based on any valuation treatment haircut.
    """
    POST_HAIRCUT = "PostHaircut"
    """
    Indicates Post haircut value
    """
    PRE_HAIRCUT = "PreHaircut"
    """
    Indicates Pre haircut value
    """
