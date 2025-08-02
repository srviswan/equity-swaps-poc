# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.functions.FilterQuantityByCurrencyExists import FilterQuantityByCurrencyExists
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_StockSplit']


@replaceable
def Qualify_StockSplit(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of StockSplit business event based on (i) an unchanged before/after currency amount (ii) the same adjustment ratio applied to the before/after cash price and number of units.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return all_elements(rosetta_resolve_attr(self, "beforeCurrencyAmount"), "=", rosetta_resolve_attr(self, "afterCurrencyAmount"))
    
    def _else_fn0():
        return False
    
    def _then_fn1():
        return any_elements(rosetta_resolve_attr(self, "afterNoOfUnits"), "<>", rosetta_resolve_attr(self, "beforeNoOfUnits"))
    
    def _else_fn1():
        return False
    
    def _then_fn2():
        return any_elements(rosetta_resolve_attr(self, "beforePrice"), "<>", rosetta_resolve_attr(self, "afterPrice"))
    
    def _else_fn2():
        return False
    
    def _then_fn3():
        return all_elements((rosetta_resolve_attr(self, "afterNoOfUnits") / rosetta_resolve_attr(self, "beforeNoOfUnits")), "=", (rosetta_resolve_attr(self, "beforePrice") / rosetta_resolve_attr(self, "afterPrice")))
    
    def _else_fn3():
        return False
    
    beforeTradeState = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"))
    afterTradeState = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    beforeQuantities = rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "tradeLot")), "priceQuantity"), "quantity")
    beforeNoOfUnits = rosetta_resolve_attr(get_only_element(FilterQuantityByFinancialUnit(rosetta_resolve_attr(self, "beforeQuantities"), rosetta_resolve_attr(FinancialUnitEnum, "SHARE"))), "value")
    afterQuantities = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "afterTradeState"), "trade"), "tradeLot"), "priceQuantity"), "quantity")
    afterNoOfUnits = rosetta_resolve_attr(get_only_element(FilterQuantityByFinancialUnit(rosetta_resolve_attr(self, "afterQuantities"), rosetta_resolve_attr(FinancialUnitEnum, "SHARE"))), "value")
    beforeCurrencyAmount = get_only_element(set(rosetta_resolve_attr(FilterQuantityByCurrencyExists(rosetta_resolve_attr(self, "beforeQuantities")), "value")))
    afterCurrencyAmount = get_only_element(set(rosetta_resolve_attr(FilterQuantityByCurrencyExists(rosetta_resolve_attr(self, "afterQuantities")), "value")))
    beforePrice = (lambda item: get_only_element(item))((lambda item: map(lambda item: rosetta_resolve_attr(self, "value"), item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "tradeLot")), "priceQuantity"), "price"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "perUnitOf"), "financialUnit"), "=", rosetta_resolve_attr(FinancialUnitEnum, "SHARE")))))
    afterPrice = (lambda item: get_only_element(item))((lambda item: map(lambda item: rosetta_resolve_attr(self, "value"), item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "afterTradeState"), "trade"), "tradeLot")), "priceQuantity"), "price"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "perUnitOf"), "financialUnit"), "=", rosetta_resolve_attr(FinancialUnitEnum, "SHARE")))))
    currencyAmountUnchanged = if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeCurrencyAmount")) and rosetta_attr_exists(rosetta_resolve_attr(self, "afterCurrencyAmount"))), _then_fn0, _else_fn0)
    noOfUnitsChanged = if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeNoOfUnits")) and rosetta_attr_exists(rosetta_resolve_attr(self, "afterNoOfUnits"))), _then_fn1, _else_fn1)
    cashPriceChanged = if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "beforePrice")) and rosetta_attr_exists(rosetta_resolve_attr(self, "afterPrice"))), _then_fn2, _else_fn2)
    adjustmentRatioMatches = if_cond_fn((((((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeNoOfUnits")) and all_elements(rosetta_resolve_attr(self, "beforeNoOfUnits"), ">", 0)) and rosetta_attr_exists(rosetta_resolve_attr(self, "afterNoOfUnits"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "beforePrice"))) and rosetta_attr_exists(rosetta_resolve_attr(self, "afterPrice"))) and all_elements(rosetta_resolve_attr(self, "afterPrice"), ">", 0)), _then_fn3, _else_fn3)
    is_event =  (((all_elements(rosetta_resolve_attr(self, "currencyAmountUnchanged"), "=", True) and all_elements(rosetta_resolve_attr(self, "noOfUnitsChanged"), "=", True)) and all_elements(rosetta_resolve_attr(self, "cashPriceChanged"), "=", True)) and all_elements(rosetta_resolve_attr(self, "adjustmentRatioMatches"), "=", True))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
