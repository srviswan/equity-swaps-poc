# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ConfirmationStatusEnum']

class ConfirmationStatusEnum(Enum):
    """
    Enumeration for the different types of confirmation status.
    """
    CONFIRMED = "Confirmed"
    UNCONFIRMED = "Unconfirmed"
