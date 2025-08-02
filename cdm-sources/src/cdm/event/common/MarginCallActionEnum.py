# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MarginCallActionEnum']

class MarginCallActionEnum(Enum):
    """
    Represents the enumeration values to identify the collateral action instruction.
    """
    DELIVERY = "Delivery"
    """
    Indicates an instruction of a new collateral asset delivery.
    """
    RETURN = "Return"
    """
    Indicates an instruction for a return of a principals collateral asset delivery.
    """
