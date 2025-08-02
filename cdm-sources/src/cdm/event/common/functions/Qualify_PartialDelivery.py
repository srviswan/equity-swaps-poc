# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.ExtractAfterTrade import ExtractAfterTrade
from cdm.event.common.functions.ExtractBeforeTrade import ExtractBeforeTrade
from cdm.event.common.functions.ExtractTradeCollateralQuantity import ExtractTradeCollateralQuantity
from cdm.event.common.functions.ExtractBeforeEconomicTerms import ExtractBeforeEconomicTerms
from cdm.event.common.functions.ExtractOpenEconomicTerms import ExtractOpenEconomicTerms
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_PartialDelivery']


@replaceable
def Qualify_PartialDelivery(businessEvent: BusinessEvent) -> bool:
    """
    Qualification of a partial delivery which constitutes a change in quantity and open with the remaining quantity and termination date.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeEconomicterms = ExtractBeforeEconomicTerms(rosetta_resolve_attr(self, "businessEvent"))
    openEconomicTerms = ExtractOpenEconomicTerms(rosetta_resolve_attr(self, "businessEvent"))
    openTrades = rosetta_resolve_attr(FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after")), "trade")
    closedTradeState = FilterClosedTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    beforeTrade = ExtractBeforeTrade(rosetta_resolve_attr(self, "businessEvent"))
    afterTrade = ExtractAfterTrade(rosetta_resolve_attr(self, "businessEvent"))
    beforeTradeCollateralQuantity = get_only_element(ExtractTradeCollateralQuantity(rosetta_resolve_attr(self, "beforeTrade")))
    afterTradeCollateralQuantity = get_only_element(ExtractTradeCollateralQuantity(rosetta_resolve_attr(self, "afterTrade")))
    is_event =  ((((((((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeEconomicterms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "openEconomicTerms"))) and all_elements(rosetta_count(rosetta_resolve_attr(self, "openTrades")), "=", 1)) and all_elements(rosetta_count(rosetta_resolve_attr(self, "closedTradeState")), "=", 1)) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "payout"), "InterestRatePayout"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "payout"), "InterestRatePayout"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "collateral"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "collateral"))) and all_elements(rosetta_resolve_attr(self, "beforeTradeCollateralQuantity"), ">", rosetta_resolve_attr(self, "afterTradeCollateralQuantity"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "terminationDate"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "effectiveDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "effectiveDate")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
