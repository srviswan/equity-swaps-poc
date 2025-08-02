# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditRatingOutlookEnum']

class CreditRatingOutlookEnum(Enum):
    """
    Represents the enumerated values to specify the credit rating outlook.
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
    STABLE = "Stable"
    """
    Denotes a rating is not likely to change.
    """
