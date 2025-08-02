# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PriceTypeEnum']

class PriceTypeEnum(Enum):
    """
    Provides enumerated values for types of prices in the Price data type in order to explain how to interpret the amount and use it in calculations.
    """
    ASSET_PRICE = "AssetPrice"
    """
    Denotes a price expressed as a cash amount in a given currency to purchase a unit of an asset (e.g. a security or a commodity).
    """
    CASH_PRICE = "CashPrice"
    """
    Denotes a price expressed as a cash amount for an upfront fee or other purposes. For example, {amount, unitOfAmount, PerUnitOfAmount} = [12,500, USD, null] = USD 12,500.
    """
    CORRELATION = "Correlation"
    """
    Denotes a price expressed as the weighted average of all pairwise correlation coefficients.
    """
    DIVIDEND = "Dividend"
    """
    Denotes a price expressed as the dividend payment from a index or share.
    """
    EXCHANGE_RATE = "ExchangeRate"
    """
    Denotes a rate to convert one currency or other measure of value to another. Foreign Exchange rates are represented in decimals, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [1.23, USD, GBP] = USD 1.23 for every 1 GBP.
    """
    INTEREST_RATE = "InterestRate"
    """
    Denotes a price expressed as a rate to be applied to quantity/notional amount and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.08, EUR, EUR] = 8%  of the EUR notional quantity/amount or 8 cents for every EUR of notional amount.
    """
    VARIANCE = "Variance"
    """
    Denotes a price expressed as the the arithmetic average of the squared differences from the mean value of an observable price.
    """
    VOLATILITY = "Volatility"
    """
    Denotes a price expressed as the the square root of the arithmetic average of the squared differences from the mean value of an observable price.
    """
