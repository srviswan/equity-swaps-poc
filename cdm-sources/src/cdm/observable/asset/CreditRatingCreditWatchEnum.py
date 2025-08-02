# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditRatingCreditWatchEnum']

class CreditRatingCreditWatchEnum(Enum):
    """
    Represents the enumerated values to specify the credit watch rating.
    """
    DEVELOPING = "Developing"
    """
    Denotes a rating may be raised, lowered, or affirmed.
    """
    NEGATIVE = "Negative"
    """
    Denotes a rating may be lowered.
    """
    POSITIVE = "Positive"
    """
    Denotes a rating may be raised.
    """
