# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ConcentrationLimitTypeEnum']

class ConcentrationLimitTypeEnum(Enum):
    """
    Represents the enumerated values to identify where a concentration limit is applied.
    """
    ASSET = "Asset"
    """
    Specifies a limit on a single asset in the portfolio
    """
    BASE_CURRENCY_EQUIVALENT = "BaseCurrencyEquivalent"
    """
    Specifies a limit on all cash valued in the base currency of the portfolio.
    """
    INDUSTRY_SECTOR = "IndustrySector"
    """
    Specifies a limit on a single industry sector in the portfolio.
    """
    ISSUE_OUTSTANDING_AMOUNT = "IssueOutstandingAmount"
    """
    Specifies a limit of the issue compared to the outstanding amount of the asset on the market.
    """
    ISSUER = "Issuer"
    """
    Specifies a limit on a single issuer in the portfolio.
    """
    MARKET_CAPITALISATION = "MarketCapitalisation"
    """
    Specifies a limit of the issue calculated as a percentage of the market capitalisation of the asset on the market.
    """
    PRIMARY_EXCHANGE = "PrimaryExchange"
    """
    Specifies a limit on a single exchange in the portfolio.
    """
    ULTIMATE_PARENT_INSTITUTION = "UltimateParentInstitution"
    """
    Specifies a limit on a single issuer in the portfolio at the ultimate parent institution level.
    """
