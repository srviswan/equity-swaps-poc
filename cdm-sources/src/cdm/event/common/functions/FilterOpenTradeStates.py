# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.TradeState import TradeState

__all__ = ['FilterOpenTradeStates']


@replaceable
def FilterOpenTradeStates(tradeStates: list[TradeState] | None) -> TradeState:
    """
    Filter to only 'open' TradeState - where both the closedState and positionState are not set.
    
    Parameters 
    ----------
    tradeStates : TradeState
    
    Returns
    -------
    openTradeStates : TradeState
    
    """
    self = inspect.currentframe()
    
    
    openTradeStates = rosetta_filter(rosetta_resolve_attr(self, "tradeStates"), lambda item: (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "state"), "closedState"))))
    
    
    return openTradeStates

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
