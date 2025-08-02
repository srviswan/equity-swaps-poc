# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['OptionTypeEnum']

class OptionTypeEnum(Enum):
    """
    The enumerated values to specify the type or strategy of the option.
    """
    CALL = "Call"
    """
    A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
    """
    PAYER = "Payer"
    """
    A 'payer' option: If you buy a 'payer' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price payer and receive float.
    """
    PUT = "Put"
    """
    A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
    """
    RECEIVER = "Receiver"
    """
    A 'receiver' option: If you buy a 'receiver' option you have the right but not the obligation to enter into the underlying swap transaction as the 'fixed' rate/price receiver and pay float.
    """
    STRADDLE = "Straddle"
    """
    A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date
    """
