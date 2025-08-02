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

__all__ = ['Qualify_InterestRate_CrossCurrency_FixedFloat']


@replaceable
def Qualify_InterestRate_CrossCurrency_FixedFloat(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as a Fixed-Float Cross-Currency Interest Rate Swap based on the economic terms and the following criteria: 1) An interest rate product with one fixed and one floating leg and a cross-currency feature and more than one payment, 2) without inflation features and 3) could be a 'zero coupon' and the floating leg index could be OIS or non-OIS.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (all_elements(Qualify_BaseProduct_CrossCurrency(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(Qualify_SubProduct_FixedFloat(rosetta_resolve_attr(self, "economicTerms")), "=", True))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
