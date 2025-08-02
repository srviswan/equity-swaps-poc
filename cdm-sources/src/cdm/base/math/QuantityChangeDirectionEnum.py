# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['QuantityChangeDirectionEnum']

class QuantityChangeDirectionEnum(Enum):
    """
    Specifies whether a quantity change is an increase, a decrease or a replacement, whereby the quantity is always specified as a positive number.
    """
    DECREASE = "Decrease"
    """
    When the quantity should go down by the specified amount.
    """
    INCREASE = "Increase"
    """
    When the quantity should go up by the specified amount.
    """
    REPLACE = "Replace"
    """
    When the quantity should be replaced by the specified amount.
    """
