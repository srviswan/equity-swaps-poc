# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.CompareOp import CompareOp
from cdm.event.common.TradeState import TradeState

__all__ = ['CompareTradeStatesToAmount']


@replaceable
def CompareTradeStatesToAmount(tradeStates: list[TradeState] | None, op: CompareOp, amount: Decimal) -> bool:
    """
    For each TradeState, compare the Quantity amounts in each TradeState to the given amount (regardless of unit of amount), based on the CompareOp enum.
    
    Parameters 
    ----------
    tradeStates : TradeState
    List of TradeState to be compared.
    
    op : CompareOp
    Comparison operation to use.
    
    amount : number
    Quantity amount to use.
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  all_elements(map(lambda item: CompareTradeLotToAmount(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeLot")), rosetta_resolve_attr(self, "op"), rosetta_resolve_attr(self, "amount")), rosetta_resolve_attr(self, "tradeStates")), "=", True)
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
