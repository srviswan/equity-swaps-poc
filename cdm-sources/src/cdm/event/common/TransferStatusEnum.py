# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TransferStatusEnum']

class TransferStatusEnum(Enum):
    """
    The enumeration values to specify the transfer status.
    """
    DISPUTED = "Disputed"
    """
    The transfer is disputed.
    """
    INSTRUCTED = "Instructed"
    """
    The transfer has been instructed.
    """
    NETTED = "Netted"
    """
    The transfer has been netted into a separate Transfer.
    """
    PENDING = "Pending"
    """
    The transfer is pending instruction.
    """
    SETTLED = "Settled"
    """
    The transfer has been settled.
    """
