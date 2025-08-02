# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['StandardSettlementStyleEnum']

class StandardSettlementStyleEnum(Enum):
    """
    The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting.
    """
    NET = "Net"
    """
    This trade is a candidate for settlement netting.
    """
    PAIR_AND_NET = "PairAndNet"
    """
    These trades have been paired and are a candidate for settlement netting.
    """
    STANDARD = "Standard"
    """
    This trade will settle using standard predetermined funds settlement instructions.
    """
    STANDARD_AND_NET = "StandardAndNet"
    """
    This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting.
    """
