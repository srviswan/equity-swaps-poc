# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['AvailableInventoryTypeEnum']

class AvailableInventoryTypeEnum(Enum):
    """
    Enumeration to describe the type of AvailableInventory
    """
    AVAILABLE_TO_LEND = "AvailableToLend"
    """
    Where a lender is broadcasting the securities that they have available to lend
    """
    REQUEST_TO_BORROW = "RequestToBorrow"
    """
    Where a party is asking a lender if they have specific securities available for them to borrow
    """
