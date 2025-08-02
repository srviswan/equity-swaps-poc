# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['TriggerTypeEnum']

class TriggerTypeEnum(Enum):
    """
    The enumerated values to specify whether an option will trigger or expire depending upon whether the spot rate is above or below the barrier rate.
    """
    EQUAL = "Equal"
    """
    The underlier price must be equal to the Trigger level.
    """
    EQUAL_OR_GREATER = "EqualOrGreater"
    """
    The underlier price must be equal to or greater than the Trigger level.
    """
    EQUAL_OR_LESS = "EqualOrLess"
    """
    The underlier price must be equal to or less than the Trigger level.
    """
    GREATER = "Greater"
    """
    The underlier price must be greater than the Trigger level.
    """
    LESS = "Less"
    """
    The underlier price must be less than the Trigger level.
    """
