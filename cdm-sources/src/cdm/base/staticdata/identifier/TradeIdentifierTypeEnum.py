# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TradeIdentifierTypeEnum']

class TradeIdentifierTypeEnum(Enum):
    """
    Defines the enumerated values to specify the nature of a trade identifier.
    """
    UNIQUE_SWAP_IDENTIFIER = "UniqueSwapIdentifier"
    UNIQUE_TRANSACTION_IDENTIFIER = "UniqueTransactionIdentifier"
