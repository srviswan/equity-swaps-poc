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

__all__ = ['Qualify_Adjustment']


@replaceable
def Qualify_Adjustment(businessEvent: BusinessEvent) -> bool:
    """
    This qualification function is used to qualify adjustment of the collateral amount when a transaction is repriced.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeTrade = ExtractBeforeTrade(rosetta_resolve_attr(self, "businessEvent"))
    afterTrade = ExtractAfterTrade(rosetta_resolve_attr(self, "businessEvent"))
    beforeTradePurchasePrice = ExtractTradePurchasePrice(rosetta_resolve_attr(self, "beforeTrade"))
    afterTradePurchasePrice = ExtractTradePurchasePrice(rosetta_resolve_attr(self, "afterTrade"))
    beforeTradeCollateralQuantity = ExtractTradeCollateralQuantity(rosetta_resolve_attr(self, "beforeTrade"))
    afterTradeCollateralQuantity = ExtractTradeCollateralQuantity(rosetta_resolve_attr(self, "afterTrade"))
    beforeTradeCollateralPrice = ExtractTradeCollateralPrice(rosetta_resolve_attr(self, "beforeTrade"))
    afterTradeCollateralPrice = ExtractTradeCollateralPrice(rosetta_resolve_attr(self, "afterTrade"))
    beforeEconomicterms = ExtractBeforeEconomicTerms(rosetta_resolve_attr(self, "businessEvent"))
    openEconomicTerms = ExtractOpenEconomicTerms(rosetta_resolve_attr(self, "businessEvent"))
    is_event =  ((((((((((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "trade"), "product"), "economicTerms"), "payout"), "InterestRatePayout")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "payout"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "payout"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "beforeTradePurchasePrice"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "afterTradePurchasePrice"))) and all_elements(rosetta_resolve_attr(self, "afterTradePurchasePrice"), "=", rosetta_resolve_attr(self, "beforeTradePurchasePrice"))) and any_elements(rosetta_resolve_attr(self, "beforeTradeCollateralQuantity"), "<>", rosetta_resolve_attr(self, "afterTradeCollateralQuantity"))) and any_elements(rosetta_resolve_attr(self, "beforeTradeCollateralPrice"), "<>", rosetta_resolve_attr(self, "afterTradeCollateralPrice"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "beforeEconomicterms"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "openEconomicTerms"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "terminationDate"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "terminationDate"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "openEconomicTerms"), "effectiveDate"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeEconomicterms"), "effectiveDate")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
