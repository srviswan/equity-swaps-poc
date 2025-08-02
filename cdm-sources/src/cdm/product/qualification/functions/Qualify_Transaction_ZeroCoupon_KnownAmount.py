# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.qualification.functions.Qualify_Transaction_ZeroCoupon import Qualify_Transaction_ZeroCoupon
from cdm.product.qualification.functions.Qualify_SubProduct_FixedFloat import Qualify_SubProduct_FixedFloat
from cdm.product.template.EconomicTerms import EconomicTerms

__all__ = ['Qualify_Transaction_ZeroCoupon_KnownAmount']


@replaceable
def Qualify_Transaction_ZeroCoupon_KnownAmount(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as having the Transaction classification Zero Coupon with a Known Amount. This category applies to a Zero Coupon Swap in which the fixed leg pays a known amount at maturity.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  ((all_elements(Qualify_SubProduct_FixedFloat(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(Qualify_Transaction_ZeroCoupon(rosetta_resolve_attr(self, "economicTerms")), "=", True)) and (lambda item: rosetta_attr_exists(item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout"), lambda item: (((rosetta_attr_exists(rosetta_resolve_attr(item, "priceQuantity")) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "rateSpecification")))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "periodMultiplier"), "=", 1)) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "paymentDates"), "paymentFrequency"), "period"), "=", rosetta_resolve_attr(PeriodExtendedEnum, "T"))))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
