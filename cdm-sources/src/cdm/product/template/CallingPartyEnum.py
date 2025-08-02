# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CallingPartyEnum']

class CallingPartyEnum(Enum):
    """
    Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction.
    """
    AS_DEFINED_IN_MASTER_AGREEMENT = "AsDefinedInMasterAgreement"
    """
    As defined in Master Agreement.
    """
    EITHER = "Either"
    """
    Either, Buyer or Seller to the repo transaction.
    """
    INITIAL_BUYER = "InitialBuyer"
    """
    Initial buyer to the repo transaction.
    """
    INITIAL_SELLER = "InitialSeller"
    """
    Initial seller to the repo transaction.
    """
