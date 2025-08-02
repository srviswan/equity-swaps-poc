# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PayerReceiverEnum']

class PayerReceiverEnum(Enum):
    """
    The enumerated values to specify an interest rate stream payer or receiver party.
    """
    PAYER = "Payer"
    """
    The party identified as the stream payer.
    """
    RECEIVER = "Receiver"
    """
    The party identified as the stream receiver.
    """
