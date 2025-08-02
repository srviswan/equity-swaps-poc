# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AssetClassEnum']

class AssetClassEnum(Enum):
    """
    The enumerated values to specify the FpML asset class categorization.
    """
    COMMODITY = "Commodity"
    """
    Commodity.
    """
    CREDIT = "Credit"
    """
    Credit.
    """
    EQUITY = "Equity"
    """
    Equity.
    """
    FOREIGN_EXCHANGE = "ForeignExchange"
    """
    ForeignExchange.
    """
    INTEREST_RATE = "InterestRate"
    """
    InterestRate.
    """
    MONEY_MARKET = "MoneyMarket"
    """
    Money Market Assets like CP and CD.
    """
