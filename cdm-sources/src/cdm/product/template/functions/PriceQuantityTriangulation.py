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
from cdm.observable.common.functions.CashPriceQuantityNoOfUnitsTriangulation import CashPriceQuantityNoOfUnitsTriangulation

__all__ = ['PriceQuantityTriangulation']


@replaceable
def PriceQuantityTriangulation(tradeLots: list[TradeLot] | None) -> bool:
    """
    Defines all the scenarios which triangulation can be helpful validation between Prices and Quantities.
    
    Parameters 
    ----------
    tradeLots : TradeLot
    
    Returns
    -------
    success : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return CashPriceQuantityNoOfUnitsTriangulation(rosetta_resolve_attr(rosetta_resolve_attr(item, "priceQuantity"), "quantity"), rosetta_resolve_attr(rosetta_resolve_attr(item, "priceQuantity"), "price"))
    
    def _else_fn1():
        return True
    
    def _then_fn0():
        return all_elements(map(lambda item: if_cond_fn(contains(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "priceQuantity"), "price"), "priceType"), rosetta_resolve_attr(PriceTypeEnum, "CASH_PRICE")), _then_fn1, _else_fn1), rosetta_resolve_attr(self, "tradeLots")), "=", True)
    
    def _else_fn0():
        return True
    
    success =  if_cond_fn(all_elements(rosetta_count(rosetta_resolve_attr(self, "tradeLots")), ">", 0), _then_fn0, _else_fn0)
    
    
    return success

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
