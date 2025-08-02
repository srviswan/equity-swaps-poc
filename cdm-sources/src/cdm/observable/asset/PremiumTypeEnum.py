# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PremiumTypeEnum']

class PremiumTypeEnum(Enum):
    """
    The enumerated values to specify the premium type for forward start options.
    """
    FIXED = "Fixed"
    POST_PAID = "PostPaid"
    PRE_PAID = "PrePaid"
    VARIABLE = "Variable"
