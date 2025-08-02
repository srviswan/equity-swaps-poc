# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CollateralStatusEnum']

class CollateralStatusEnum(Enum):
    """
    Represents the enumeration list to identify the settlement status of the collateral.
    """
    FULL_AMOUNT = "FullAmount"
    """
    Indicates the collateral balance amount in full, inclusive of any pre-agreed collateral positions in transit for settlement.
    """
    IN_TRANSIT_AMOUNT = "InTransitAmount"
    """
    Indicates collateral amount in transit settlement cycle only, excluding settled collateral amount/s.
    """
    SETTLED_AMOUNT = "SettledAmount"
    """
    Indicates the collateral is settled and not an in transit pre-agreed collateral amount/s.
    """
