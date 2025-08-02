# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['EquityTypeEnum']

class EquityTypeEnum(Enum):
    """
    Represents an enumeration list to identify the type of Equity.
    """
    NON_CONVERTIBLE_PREFERENCE = "NonConvertiblePreference"
    """
    Identifies an Equity of Non-Convertible Preference, Shares which hold priority to receive capital return in event of issuer liquidation.
    """
    ORDINARY = "Ordinary"
    """
    Identifies an Equity of Common stocks and shares.
    """
