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

__all__ = ['Qualify_Cancellation']


@replaceable
def Qualify_Cancellation(businessEvent: BusinessEvent) -> bool:
    """
    Qualification of an cancellation event.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate"), "adjustableDate"), "unadjustedDate"), "<", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "closedEconomicTerms"), "terminationDate"), "adjustableDate"), "unadjustedDate"))
    
    def _else_fn0():
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate"))
    
    closedEconomicTerms = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(FilterClosedTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))), "trade"), "product"), "economicTerms")
    openEconomicTerms = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))), "trade"), "product"), "economicTerms")
    is_event =  (((all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before")), "=", 1) and rosetta_attr_exists(rosetta_resolve_attr(self, "closedEconomicTerms"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "openEconomicTerms"))) and if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "closedEconomicTerms"), "terminationDate"))), _then_fn0, _else_fn0))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
