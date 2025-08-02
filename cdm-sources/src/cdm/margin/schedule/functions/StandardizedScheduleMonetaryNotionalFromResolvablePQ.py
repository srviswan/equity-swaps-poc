# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.settlement.ResolvablePriceQuantity import ResolvablePriceQuantity

__all__ = ['StandardizedScheduleMonetaryNotionalFromResolvablePQ']


@replaceable
def StandardizedScheduleMonetaryNotionalFromResolvablePQ(priceQuantity: ResolvablePriceQuantity | None) -> Decimal:
    """
    Extracts the notional amount for all products that have it populated in the resolvable priceQuantity.
    
    Parameters 
    ----------
    priceQuantity : ResolvablePriceQuantity
    
    Returns
    -------
    notional : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return (rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"), "value") * rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"), "multiplier"), "value"))
    
    def _else_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"), "value")
    
    def _then_fn0():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"), "multiplier")), _then_fn1, _else_fn1)
    
    def _else_fn0():
        return True
    
    notional =  if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantitySchedule"), "unit"), "currency"))), _then_fn0, _else_fn0)
    
    
    return notional

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
