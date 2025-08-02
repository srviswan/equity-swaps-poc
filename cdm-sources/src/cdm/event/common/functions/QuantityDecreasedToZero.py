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
from cdm.event.common.functions.CompareTradeStatesToAmount import CompareTradeStatesToAmount

__all__ = ['QuantityDecreasedToZero']


@replaceable
def QuantityDecreasedToZero(before: list[TradeState] | None, after: list[TradeState] | None) -> bool:
    """
    
    Parameters 
    ----------
    before : TradeState
    
    after : TradeState
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  (all_elements(CompareTradeLotToAmount(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "trade"), "tradeLot")), rosetta_resolve_attr(CompareOp, "GREATER_THAN_OR_EQUALS"), 0.0), "=", True) and all_elements(CompareTradeStatesToAmount(rosetta_resolve_attr(self, "after"), rosetta_resolve_attr(CompareOp, "EQUALS"), 0.0), "=", True))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
