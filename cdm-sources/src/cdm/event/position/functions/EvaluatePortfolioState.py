# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.position.Portfolio import Portfolio
from cdm.event.position.PortfolioState import PortfolioState

__all__ = ['EvaluatePortfolioState']


@replaceable
def EvaluatePortfolioState(portfolio: Portfolio) -> PortfolioState:
    """
    Function specification to evaluate a portfolio's aggregation parameters and return a new portfolio state containing aggregated positions.
    
    Parameters 
    ----------
    portfolio : Portfolio
    Portfolio containing the aggregation parameters to be used to calculate the new portfolio state.
    
    Returns
    -------
    portfolioState : PortfolioState
    
    """
    self = inspect.currentframe()
    
    
    portfolioState = rosetta_resolve_attr(self, "portfolioState")
    
    
    return portfolioState

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
