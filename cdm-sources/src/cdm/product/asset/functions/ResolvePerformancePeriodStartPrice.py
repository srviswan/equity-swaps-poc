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
from cdm.observable.asset.Observable import Observable
from cdm.observable.asset.PriceSchedule import PriceSchedule

__all__ = ['ResolvePerformancePeriodStartPrice']


@replaceable
def ResolvePerformancePeriodStartPrice(performancePayout: PerformancePayout, price: list[PriceSchedule] | None, observable: Observable | None, adjustedDate: datetime.date) -> PriceSchedule:
    """
    Resolves the price from the end of the previous period. If first period, then take the initial price.
    
    Parameters 
    ----------
    performancePayout : PerformancePayout
    
    price : PriceSchedule
    
    observable : Observable
    
    adjustedDate : date
    
    Returns
    -------
    startPrice : PriceSchedule
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "initialValuationPrice"))
    
    def _else_fn0():
        return ResolveEquityInitialPrice(rosetta_resolve_attr(self, "price"))
    
    adjustedValuationDates = AdjustedValuationDates(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "valuationDates"))
    startPrice =  if_cond_fn(all_elements(rosetta_resolve_attr(self, "adjustedDate"), "<", rosetta_resolve_attr(self, "adjustedValuationDates")[0]), _then_fn0, _else_fn0)
    
    
    return startPrice

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
