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

__all__ = ['Qualify_EquitySwap_PriceReturnBasicPerformance_Basket']


@replaceable
def Qualify_EquitySwap_PriceReturnBasicPerformance_Basket(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as an Equity Swap for which the performance is based on the price change on a basket.  The determination of the qualification is based on the economic terms and the following criteria: 1) An equity product with one performance leg and one interest leg 2) with the former featuring priceReturnTerms, 3) the underlier is a basket and 4) there are no option features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    performancePayout = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"))
    is_product =  (((((all_elements(Qualify_BaseProduct_EquitySwap(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "=", 2)) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "underlier"), "Observable"), "Basket"))) and self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "returnTerms"), "priceReturnTerms")))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
