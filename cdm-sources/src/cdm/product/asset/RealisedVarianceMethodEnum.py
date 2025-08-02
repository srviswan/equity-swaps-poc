# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['RealisedVarianceMethodEnum']

class RealisedVarianceMethodEnum(Enum):
    """
    The contract specifies which price must satisfy the boundary condition.  Used for variance, volatility and correlation caps and floors.
    """
    BOTH = "Both"
    """
    For a return on day T, the observed prices on both T and T-1 must be in range
    """
    LAST = "Last"
    """
    For a return on day T, the observed price on T must be in range.
    """
    PREVIOUS = "Previous"
    """
    For a return on day T, the observed price on T-1 must be in range.
    """
