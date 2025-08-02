# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TriggerTimeTypeEnum']

class TriggerTimeTypeEnum(Enum):
    """
    The enumerated values to specify the time of day which would be considered for valuing the knock event.
    """
    ANYTIME = "Anytime"
    """
    At any time during the Knock Determination period (continuous barrier).
    """
    CLOSING = "Closing"
    """
    The close of trading on a day would be considered for valuation.
    """
