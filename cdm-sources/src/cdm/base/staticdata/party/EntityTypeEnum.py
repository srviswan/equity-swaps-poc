# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['EntityTypeEnum']

class EntityTypeEnum(Enum):
    """
    The enumerated values to specify the reference entity types corresponding to a list of types defined in the ISDA First to Default documentation.
    """
    ASIAN = "Asian"
    """
    Entity Type of Asian.
    """
    AUSTRALIAN_AND_NEW_ZEALAND = "AustralianAndNewZealand"
    """
    Entity Type of Australian and New Zealand.
    """
    EUROPEAN_EMERGING_MARKETS = "EuropeanEmergingMarkets"
    """
    Entity Type of European Emerging Markets.
    """
    JAPANESE = "Japanese"
    """
    Entity Type of Japanese.
    """
    NORTH_AMERICAN_HIGH_YIELD = "NorthAmericanHighYield"
    """
    Entity Type of North American High Yield.
    """
    NORTH_AMERICAN_INSURANCE = "NorthAmericanInsurance"
    """
    Entity Type of North American Insurance.
    """
    NORTH_AMERICAN_INVESTMENT_GRADE = "NorthAmericanInvestmentGrade"
    """
    Entity Type of North American Investment Grade.
    """
    SINGAPOREAN = "Singaporean"
    """
    Entity Type of Singaporean.
    """
    WESTERN_EUROPEAN = "WesternEuropean"
    """
    Entity Type of Western European.
    """
    WESTERN_EUROPEAN_INSURANCE = "WesternEuropeanInsurance"
    """
    Entity Type of Western European Insurance.
    """
