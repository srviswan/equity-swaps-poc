# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['MarginCallResponseTypeEnum']

class MarginCallResponseTypeEnum(Enum):
    """
    Represents the enumeration values to define the response type to a margin call.
    """
    AGREEIN_FULL = "AgreeinFull"
    """
    Specifies a 'Full Agreement' to Margin Call.
    """
    DISPUTE = "Dispute"
    """
    Specifies a 'Full Dispute' to a Margin call.
    """
    PARTIALLY_AGREE = "PartiallyAgree"
    """
    Specifies a 'Partial agreement' to Margin Call.
    """
