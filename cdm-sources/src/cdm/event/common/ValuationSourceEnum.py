# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['ValuationSourceEnum']

class ValuationSourceEnum(Enum):
    """
    Source for the valuation of the transaction by the valuation party.
    """
    CENTRAL_COUNTERPARTY = "CentralCounterparty"
    """
    Central Counterparty's Valuation
    """
