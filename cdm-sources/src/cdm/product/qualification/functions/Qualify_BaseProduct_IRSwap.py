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

__all__ = ['Qualify_BaseProduct_IRSwap']


@replaceable
def Qualify_BaseProduct_IRSwap(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as having the Base Product classification Interest Rate Swap.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  ((((all_elements(Qualify_AssetClass_InterestRate(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout")), "=", 2)) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout"), "paymentDates")), "=", 2)) and all_elements(Qualify_BaseProduct_CrossCurrency(rosetta_resolve_attr(self, "economicTerms")), "=", False)) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout"), "rateSpecification"), "InflationRateSpecification"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
