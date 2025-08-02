# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AffirmationStatusEnum']

class AffirmationStatusEnum(Enum):
    """
    Enumeration for the different types of affirmation status.
    """
    AFFIRMED = "Affirmed"
    UNAFFIRMED = "Unaffirmed"
