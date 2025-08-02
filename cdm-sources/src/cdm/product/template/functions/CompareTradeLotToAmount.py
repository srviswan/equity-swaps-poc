# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.TradeLot import TradeLot
from cdm.base.math.CompareOp import CompareOp

__all__ = ['CompareTradeLotToAmount']


@replaceable
def CompareTradeLotToAmount(tradeLot: TradeLot, op: CompareOp, amount: Decimal) -> bool:
    """
    Compare the Quantity amount in TradeLot to the given amount (regardless of unit of amount), based on the CompareOp enum.
    
    Parameters 
    ----------
    tradeLot : TradeLot
    
    op : CompareOp
    
    amount : number
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  (lambda item: all_elements(map(lambda item: CompareNumbers(rosetta_resolve_attr(item, "value"), rosetta_resolve_attr(self, "op"), rosetta_resolve_attr(self, "amount")), item), "=", True))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot"), "priceQuantity"), "quantity"), lambda item: rosetta_attr_exists(rosetta_resolve_attr(item, "value"))))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
