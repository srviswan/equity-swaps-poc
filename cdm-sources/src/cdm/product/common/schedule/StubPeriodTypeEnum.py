# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['StubPeriodTypeEnum']

class StubPeriodTypeEnum(Enum):
    """
    The enumerated values to specify how to deal with a non standard calculation period within a swap stream.
    """
    LONG_FINAL = "LongFinal"
    """
    If there is a non regular period remaining it is placed at the end of the stream and combined with the adjacent calculation period to give a long last calculation period.
    """
    LONG_INITIAL = "LongInitial"
    """
    If there is a non regular period remaining it is placed at the start of the stream and combined with the adjacent calculation period to give a long first calculation period.
    """
    SHORT_FINAL = "ShortFinal"
    """
    If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the end of the stream.
    """
    SHORT_INITIAL = "ShortInitial"
    """
    If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the start of the stream.
    """
