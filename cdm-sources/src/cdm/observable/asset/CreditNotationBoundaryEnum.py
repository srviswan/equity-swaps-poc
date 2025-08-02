# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['CreditNotationBoundaryEnum']

class CreditNotationBoundaryEnum(Enum):
    """
    Identifies an agency rating as a simple scale boundary of minimum or maximum.
    """
    MAXIMUM = "Maximum"
    """
    Denotes a maxiumum boundary
    """
    MINIMUM = "Minimum"
    """
    Denotes a minumum boundary
    """
