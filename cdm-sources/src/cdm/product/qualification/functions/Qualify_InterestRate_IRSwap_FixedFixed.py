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
from cdm.product.qualification.functions.Qualify_SubProduct_FixedFixed import Qualify_SubProduct_FixedFixed

__all__ = ['Qualify_InterestRate_IRSwap_FixedFixed']


@replaceable
def Qualify_InterestRate_IRSwap_FixedFixed(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as a Fixed-Fixed Interest Rate Swap based on the economic terms and the following criteria: 1) An interest rate product with two fixed legs and more than one payment and 2) without inflation features or cross-currency features but could have 'zero coupon' features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (all_elements(Qualify_BaseProduct_IRSwap(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(Qualify_SubProduct_FixedFixed(rosetta_resolve_attr(self, "economicTerms")), "=", True))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
