# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['SettlementTypeEnum']

class SettlementTypeEnum(Enum):
    """
    The enumeration values to specify how the option is to be settled when exercised.
    """
    CASH = "Cash"
    """
    The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties.
    """
    CASH_OR_PHYSICAL = "CashOrPhysical"
    """
    Allow use of either Cash or Physical settlement without prior Election.
    """
    ELECTION = "Election"
    """
    Allow Election of either Cash or Physical settlement.
    """
    PHYSICAL = "Physical"
    """
    The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share.
    """
