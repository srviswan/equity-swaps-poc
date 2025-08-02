# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MaturityTypeEnum']

class MaturityTypeEnum(Enum):
    """
    Represents an enumeration list to identify the Maturity.
    """
    FROM_ISSUANCE = "FromIssuance"
    """
    Denotes a period from issuance date until now.
    """
    ORIGINAL_MATURITY = "OriginalMaturity"
    """
    Denotes a period from issuance until maturity date.
    """
    REMAINING_MATURITY = "RemainingMaturity"
    """
    Denotes a period from now until maturity date.
    """
