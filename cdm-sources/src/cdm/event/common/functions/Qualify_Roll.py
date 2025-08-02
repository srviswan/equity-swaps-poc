# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.FilterClosedTradeStates import FilterClosedTradeStates
from cdm.event.common.functions.FilterOpenTradeStates import FilterOpenTradeStates
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_Roll']


@replaceable
def Qualify_Roll(businessEvent: BusinessEvent) -> bool:
    """
    Qualification of a roll event based on: (i) terminating a single existing trade, (ii) entering into a new trade with the same details as the old trade, except for the effective and termination date where the effective date. The roll qualification does not make any assumption on the resulting quantity which may change compared to the original trade (it may only be partially rolled). The price is also likely different as market conditions may have evolved.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeEconomicterms = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction")), "before"), "trade"), "product"), "economicTerms")
    openEconomicTerms = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))), "trade"), "product"), "economicTerms")
    closedTradeState = FilterClosedTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    is_event =  ((((((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeEconomicterms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "openEconomicTerms"))) and all_elements(rosetta_count(rosetta_resolve_attr(self, "closedTradeState")), "=", 1)) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "payout"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "payout"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "collateral"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "collateral"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "effectiveDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "terminationDate"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "terminationDate")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
