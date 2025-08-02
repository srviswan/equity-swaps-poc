# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ValuationTypeEnum']

class ValuationTypeEnum(Enum):
    """
    Method used for the valuation of the transaction by the valuation party.
    """
    MARK_TO_MARKET = "MarkToMarket"
    """
    Mark-to-Market
    """
    MARK_TO_MODEL = "MarkToModel"
    """
    Mark-to-Model
    """
