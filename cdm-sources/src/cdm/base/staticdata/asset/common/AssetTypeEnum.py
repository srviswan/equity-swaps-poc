# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AssetTypeEnum']

class AssetTypeEnum(Enum):
    """
    Represents an enumeration list to identify the asset type.
    """
    CASH = "Cash"
    """
    Indentifies cash in a currency form.
    """
    COMMODITY = "Commodity"
    """
    Indentifies basic good used in commerce that is interchangeable with other goods of the same type.
    """
    OTHER = "Other"
    """
    Indentifies other asset types.
    """
    SECURITY = "Security"
    """
    Indentifies negotiable financial instrument of monetary value with an issue ownership position.
    """
