# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_OnDemandRateChange']


@replaceable
def Qualify_OnDemandRateChange(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of on an-demand rate change event from the fact that the only primitive is the reset.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeTrade = rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction")), "before"), "trade")
    beforeProduct = rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTrade"), "product")
    beforeEconomicterms = rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeProduct"), "economicTerms")
    openTrade = rosetta_resolve_attr(get_only_element(FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))), "trade")
    openEconomicTerms = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTrade"), "product"), "economicTerms")
    closedTradeState = FilterClosedTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    beforePriceQuantityRateOnly = (lambda item: map(lambda item: rosetta_resolve_attr(self, "value"), item))((lambda item: rosetta_filter(item, lambda item: all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"))))((lambda item: flatten_list(item))(map(lambda item: rosetta_resolve_attr(self, "price"), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTrade"), "tradeLot")), "priceQuantity")))))
    openPriceQuantityRateOnly = (lambda item: map(lambda item: rosetta_resolve_attr(self, "value"), item))((lambda item: rosetta_filter(item, lambda item: all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"))))((lambda item: flatten_list(item))(map(lambda item: rosetta_resolve_attr(self, "price"), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTrade"), "tradeLot")), "priceQuantity")))))
    beforePriceQuantityNoRate = map(lambda item: PriceQuantity(price=rosetta_filter(rosetta_resolve_attr(self, "price"), lambda item: any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "p"), "priceType"), "<>", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"))), quantity=rosetta_resolve_attr(self, "quantity"), observable=rosetta_resolve_attr(self, "observable")), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTrade"), "tradeLot")), "priceQuantity"))
    openPriceQuantityNoRate = map(lambda item: PriceQuantity(price=rosetta_filter(rosetta_resolve_attr(self, "price"), lambda item: any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "p"), "priceType"), "<>", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"))), quantity=rosetta_resolve_attr(self, "quantity"), observable=rosetta_resolve_attr(self, "observable")), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTrade"), "tradeLot")), "priceQuantity"))
    is_event =  (((((((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeEconomicterms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "openEconomicTerms"))) and all_elements(rosetta_count(rosetta_resolve_attr(self, "closedTradeState")), "=", 1)) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "collateral"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "collateral"))) and all_elements(rosetta_count(rosetta_resolve_attr(self, "beforePriceQuantityRateOnly")), "=", 1)) and all_elements(rosetta_count(rosetta_resolve_attr(self, "openPriceQuantityRateOnly")), "=", 1)) and any_elements(get_only_element(rosetta_resolve_attr(self, "beforePriceQuantityRateOnly")), "<>", get_only_element(rosetta_resolve_attr(self, "openPriceQuantityRateOnly")))) and all_elements(rosetta_resolve_attr(self, "beforePriceQuantityNoRate"), "=", rosetta_resolve_attr(self, "openPriceQuantityNoRate")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
