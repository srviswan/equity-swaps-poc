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
from cdm.base.datetime.PeriodExtendedEnum import PeriodExtendedEnum

__all__ = ['Qualify_Transaction_ZeroCoupon']


@replaceable
def Qualify_Transaction_ZeroCoupon(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as having the Transaction classification Zero Coupon
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (lambda item: rosetta_attr_exists(item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout"), "paymentDates"), "paymentFrequency"), lambda item: (all_elements(rosetta_resolve_attr(item, "periodMultiplier"), "=", 1) and all_elements(rosetta_resolve_attr(item, "period"), "=", rosetta_resolve_attr(PeriodExtendedEnum, "T")))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
