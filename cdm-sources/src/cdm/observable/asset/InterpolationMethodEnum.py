# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['InterpolationMethodEnum']

class InterpolationMethodEnum(Enum):
    """
    The enumerated values to specify the interpolation method, e.g. linear.
    """
    LINEAR = "Linear"
    """
    Linear Interpolation applicable.
    """
    LINEAR_ZERO_YIELD = "LinearZeroYield"
    """
    Linear Interpolation applicable.
    """
    NONE = "None"
    """
    No Interpolation applicable.
    """
