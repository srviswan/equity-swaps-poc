# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AveragingInOutEnum']

class AveragingInOutEnum(Enum):
    """
    The enumerated values to specify the type of averaging used in an Asian option.
    """
    BOTH = "Both"
    """
    The average price is used to derive both the strike and the expiration price.
    """
    IN = "In"
    """
    The average price is used to derive the strike price. Also known as 'Asian strike' style option.
    """
    OUT = "Out"
    """
    The average price is used to derive the expiration price. Also known as 'Asian price' style option.
    """
