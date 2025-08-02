# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.NonNegativeQuantity import NonNegativeQuantity
from cdm.product.template.TradeLot import TradeLot
from cdm.base.math.functions.CompareQuantityByUnitOfAmount import CompareQuantityByUnitOfAmount
from cdm.base.math.CompareOp import CompareOp

__all__ = ['CompareTradeLot']


@replaceable
def CompareTradeLot(tradeLot1: TradeLot, op: CompareOp, tradeLot2: TradeLot) -> bool:
    """
    Compare the Quantity in TradeLot 1 to the Quantity (with the same unit of amount) in TradeLot 2, based on the CompareOp enum.
    
    Parameters 
    ----------
    tradeLot1 : TradeLot
    
    op : CompareOp
    
    tradeLot2 : TradeLot
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    unitOfAmounts = set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot2"), "priceQuantity"), "quantity"), "unit"))
    result =  all_elements(map(lambda item: CompareQuantityByUnitOfAmount(map(lambda item: NonNegativeQuantity(value=rosetta_resolve_attr(item, "value"), unit=rosetta_resolve_attr(item, "unit")), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot1"), "priceQuantity"), "quantity")), rosetta_resolve_attr(self, "op"), map(lambda item: NonNegativeQuantity(value=rosetta_resolve_attr(item, "value"), unit=rosetta_resolve_attr(item, "unit")), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot2"), "priceQuantity"), "quantity")), rosetta_resolve_attr(self, "unitOfAmount")), rosetta_resolve_attr(self, "unitOfAmounts")), "=", True)
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
