# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ReturnTypeEnum']

class ReturnTypeEnum(Enum):
    """
    The enumerated values to specify the type of return associated the equity payout.
    """
    PRICE = "Price"
    """
    Price return, i.e. excluding dividends.
    """
    TOTAL = "Total"
    """
    Total return, i.e. including dividend and price components.
    """
