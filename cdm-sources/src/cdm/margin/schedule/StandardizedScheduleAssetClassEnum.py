# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['StandardizedScheduleAssetClassEnum']

class StandardizedScheduleAssetClassEnum(Enum):
    COMMODITY = "Commodity"
    CREDIT = "Credit"
    EQUITY = "Equity"
    FOREIGN_EXCHANGE = "ForeignExchange"
    INTEREST_RATES = "InterestRates"
