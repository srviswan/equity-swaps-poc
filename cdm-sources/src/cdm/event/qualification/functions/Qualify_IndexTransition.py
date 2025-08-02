# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_IndexTransition']


@replaceable
def Qualify_IndexTransition(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of an index transition event based on (i) adjustment spread applied and (ii) floating rate index changed.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "spread"), "value"), "<>", 0)
    
    def _else_fn0():
        return True
    
    after = rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after")), "trade")
    before = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"), "trade")
    floatingRateIndexChanged = (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "tradeLot"), "priceQuantity"), "observable"), "Index"), "InterestRateIndex")) and disjoint(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "tradeLot"), "priceQuantity"), "observable"), "Index"), "InterestRateIndex"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "after"), "tradeLot"), "priceQuantity"), "observable"), "Index"), "InterestRateIndex")))
    spread = FilterPrice(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "after"), "tradeLot"), "priceQuantity"), "price"), rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"), [rosetta_resolve_attr(ArithmeticOperationEnum, "ADD"), rosetta_resolve_attr(ArithmeticOperationEnum, "SUBTRACT")], [])
    adjustmentSpreadAdded = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "spread")), _then_fn0, _else_fn0)
    is_event =  ((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "INDEX_TRANSITION")) and all_elements(rosetta_resolve_attr(self, "floatingRateIndexChanged"), "=", True)) and all_elements(rosetta_resolve_attr(self, "adjustmentSpreadAdded"), "=", True))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
