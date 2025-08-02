# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['OptionExerciseStyleEnum']

class OptionExerciseStyleEnum(Enum):
    """
    The enumerated values to specify the option exercise style. i.e., European, Bermuda or American.
    """
    AMERICAN = "American"
    """
    Continuous exercise over a range of dates
    """
    BERMUDA = "Bermuda"
    """
    Multiple specified exercise dates
    """
    EUROPEAN = "European"
    """
    Single Exercise
    """
