# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.EconomicTerms import EconomicTerms

__all__ = ['Qualify_EquitySwap_TotalReturnBasicPerformance_Basket']


@replaceable
def Qualify_EquitySwap_TotalReturnBasicPerformance_Basket(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as an Equity Swap for which the performance is based on the price changes and dividend returns on a basket.  The determination of the qualification is based on the economic terms and the following criteria: 1) An equity product with one performance leg and one interest leg 2) with the former featuring priceReturnTerms and dividendReturnTerms, 3) the underlier is a basket and 4) there are no option features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  ((((all_elements(Qualify_BaseProduct_EquitySwap(rosetta_resolve_attr(self, "economicTerms")), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "underlier"), "Observable"), "Basket"))) and (((PerformancePayoutAndInterestRatePayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout")), "=", 1)) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout")), "=", 2)) or ((all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "=", 2) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"))))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "priceReturnTerms"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "dividendReturnTerms")))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
