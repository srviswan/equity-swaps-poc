# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditRatingAgencyEnum']

class CreditRatingAgencyEnum(Enum):
    """
    Represents the enumerated values to specify the rating agencies.
    """
    AM_BEST = "AMBest"
    """
    A. M. Best
    """
    CBRS = "CBRS"
    """
    Canadian Bond Rating Service
    """
    DBRS = "DBRS"
    """
    Dominion Bond Rating Service
    """
    FITCH = "Fitch"
    """
    Fitch
    """
    JAPANAGENCY = "Japanagency"
    """
    Japan Credit Rating Agency, Ltd.
    """
    MOODYS = "Moodys"
    """
    Moody's
    """
    RATING_AND_INVESTMENT_INFORMATION = "RatingAndInvestmentInformation"
    """
    Rating And Investment Information, Inc.
    """
    STANDARD_AND_POORS = "StandardAndPoors"
    """
    Standard And Poor's
    """
