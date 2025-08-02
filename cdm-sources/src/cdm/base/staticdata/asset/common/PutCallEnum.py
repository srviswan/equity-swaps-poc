# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['PutCallEnum']

class PutCallEnum(Enum):
    """
    The enumerated values to specify the types of listed derivative options.
    """
    CALL = "Call"
    """
    A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
    """
    PUT = "Put"
    """
    A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
    """
