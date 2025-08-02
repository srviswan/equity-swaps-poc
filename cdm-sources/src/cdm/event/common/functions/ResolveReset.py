# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.Reset import Reset
from cdm.event.common.TradeState import TradeState

__all__ = ['ResolveReset']


@replaceable
def ResolveReset(tradeState: TradeState, date: datetime.date) -> Reset:
    """
    Defines the interface for adopters to resolve a reset, given a trade state and a date.
    
    Parameters 
    ----------
    tradeState : TradeState
    
    date : date
    
    Returns
    -------
    reset : Reset
    
    """
    self = inspect.currentframe()
    
    
    reset = rosetta_resolve_attr(self, "reset")
    
    
    return reset

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
