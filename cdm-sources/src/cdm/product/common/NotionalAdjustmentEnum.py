# pylint: disable=missing-module-docstring, invalid-name, line-too-long
from enum import Enum

__all__ = ['NotionalAdjustmentEnum']

class NotionalAdjustmentEnum(Enum):
    """
    The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
    """
    EXECUTION = "Execution"
    """
    The adjustments to the number of units are governed by an execution clause.
    """
    PORTFOLIO_REBALANCING = "PortfolioRebalancing"
    """
    The adjustments to the number of units are governed by a portfolio rebalancing clause.
    """
    STANDARD = "Standard"
    """
    The adjustments to the number of units are not governed by any specific clause.
    """
