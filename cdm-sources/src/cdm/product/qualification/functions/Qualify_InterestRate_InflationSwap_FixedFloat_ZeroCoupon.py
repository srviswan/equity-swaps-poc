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

__all__ = ['Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon']


@replaceable
def Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as a Fixed-Float Inflation Swap based on the economic terms and the following criteria: 1) An interest rate product with one fixed and one inflation rate leg, 2) where the fixed leg represents one singular payment agreed upon execution and to be made at maturity, 3) where the inflation leg features an inflation floating rate and 4) without cross-currency features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (((all_elements(Qualify_BaseProduct_Inflation(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(Qualify_BaseProduct_CrossCurrency(rosetta_resolve_attr(self, "economicTerms")), "=", False)) and all_elements(Qualify_SubProduct_FixedFloat(rosetta_resolve_attr(self, "economicTerms")), "=", True)) and all_elements(Qualify_Transaction_ZeroCoupon(rosetta_resolve_attr(self, "economicTerms")), "=", True))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
