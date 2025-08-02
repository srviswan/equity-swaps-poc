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

__all__ = ['Qualify_EquitySwap_ParameterReturnDispersion']


@replaceable
def Qualify_EquitySwap_ParameterReturnDispersion(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as an Equity Swap for which the performance is based on the variance changes in several legs.  The determination of the qualification is based on the economic terms and the following criteria: 1) Is an equity product 2) of swap type, 3) more than one performance leg, 4) all of which have variance return terms, and 5) there are no option features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (((((((all_elements(Qualify_BaseProduct_EquitySwap(rosetta_resolve_attr(self, "economicTerms")), "=", True) and PerformancePayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"))) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout")), ">", 1)) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "varianceReturnTerms")), ">", 1)) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "volatilityReturnTerms")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "correlationReturnTerms")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "priceReturnTerms")))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "dividendReturnTerms"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
