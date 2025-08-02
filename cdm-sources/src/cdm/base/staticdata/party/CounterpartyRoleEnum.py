# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CounterpartyRoleEnum']

class CounterpartyRoleEnum(Enum):
    """
    Defines the enumerated values to specify the two counterparties to the transaction.
    """
    PARTY_1 = "Party1"
    PARTY_2 = "Party2"
