# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PriceTimingEnum']

class PriceTimingEnum(Enum):
    CLOSING_PRICE = "ClosingPrice"
    """
    The last price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
    """
    OPENING_PRICE = "OpeningPrice"
    """
    The first price anyone paid for a share of a product during the business hours of the exchange where the product is traded on a business day.
    """
