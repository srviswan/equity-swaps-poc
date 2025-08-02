# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.SettlementPayout import SettlementPayout
from cdm.product.template.TradeLot import TradeLot
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule

__all__ = ['StandardizedScheduleFXSwapNotional']


@replaceable
def StandardizedScheduleFXSwapNotional(farLeg: SettlementPayout | None, tradeLot: TradeLot | None) -> NonNegativeQuantitySchedule:
    """
    Extracts the notional amount and currency of an FX swap.
    
    Parameters 
    ----------
    farLeg : SettlementPayout
    
    tradeLot : TradeLot
    
    Returns
    -------
    quantity : NonNegativeQuantitySchedule
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn4():
        return (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "exchangedCurrencies"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"), "=", "CHF")))
    
    def _else_fn4():
        return sorted(rosetta_resolve_attr(self, "exchangedCurrencies"))[0]
    
    def _then_fn3():
        return (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "exchangedCurrencies"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"), "=", "GBP")))
    
    def _else_fn3():
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "exchangedCurrencies"), "unit"), "currency"), "=", "CHF"), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "exchangedCurrencies"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"), "=", "JPY")))
    
    def _else_fn2():
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "exchangedCurrencies"), "unit"), "currency"), "=", "GBP"), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "exchangedCurrencies"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"), "=", "EUR")))
    
    def _else_fn1():
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "exchangedCurrencies"), "unit"), "currency"), "=", "JPY"), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "exchangedCurrencies"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"), "=", "USD")))
    
    def _else_fn0():
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "exchangedCurrencies"), "unit"), "currency"), "=", "EUR"), _then_fn1, _else_fn1)
    
    priceQuantity = (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot"), "priceQuantity"), lambda item: all_elements(rosetta_resolve_attr(item, "price"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "farLeg"), "priceQuantity"), "priceSchedule"))))
    exchangedCurrencies = rosetta_resolve_attr(rosetta_resolve_attr(self, "priceQuantity"), "quantity")
    extractedExchangedCurrency = if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "exchangedCurrencies"), "unit"), "currency"), "=", "USD"), _then_fn0, _else_fn0)
    quantity =  rosetta_resolve_attr(self, "extractedExchangedCurrency")
    
    
    return quantity

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
