# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.PerformancePayout import PerformancePayout

__all__ = ['StandardizedScheduleVarianceSwapNotionalAmount']


@replaceable
def StandardizedScheduleVarianceSwapNotionalAmount(performancePayout: PerformancePayout | None) -> Decimal:
    """
    Extracts the notional amount of an EQ variance swap.
    
    Parameters 
    ----------
    performancePayout : PerformancePayout
    
    Returns
    -------
    amount : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return (rosetta_resolve_attr(self, "value") * rosetta_resolve_attr(rosetta_resolve_attr(self, "multiplier"), "value"))
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "value")
    
    def _then_fn0():
        return (0.01 * item)
    
    def _else_fn0():
        return item
    
    varianceAmount = (lambda item: if_cond_fn(all_elements(item, ">=", 1), _then_fn0, _else_fn0))((lambda item: if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "multiplier")), _then_fn0, _else_fn0))(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "priceQuantity"), "quantitySchedule")))
    volatilityStrikePrice = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "returnTerms"), "varianceReturnTerms"), "volatilityStrikePrice"), "value")
    amount =  ((200 * rosetta_resolve_attr(self, "varianceAmount")) * rosetta_resolve_attr(self, "volatilityStrikePrice"))
    
    
    return amount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
