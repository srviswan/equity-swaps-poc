# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CollateralInterestHandlingEnum']

class CollateralInterestHandlingEnum(Enum):
    """
    How is collateral interest to be handled?
    """
    ADJUST = "Adjust"
    """
     Adjust the collateral balance to include the interest amount 
    """
    TRANSFER = "Transfer"
    """
     Transfer the interest each period 
    """
    TRANSFER_OR_ADJUST = "Transfer_or_Adjust"
    """
     Transfer the interest if it meets certain criteria, or otherwise adjust the collateral balance to reflect the interest amount  
    """
