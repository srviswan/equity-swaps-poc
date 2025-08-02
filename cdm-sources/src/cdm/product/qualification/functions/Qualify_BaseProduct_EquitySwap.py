# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.qualification.functions.PerformancePayoutOnlyExists import PerformancePayoutOnlyExists
from cdm.product.qualification.functions.PerformancePayoutAndInterestRatePayoutOnlyExists import PerformancePayoutAndInterestRatePayoutOnlyExists
from cdm.product.template.EconomicTerms import EconomicTerms
from cdm.product.qualification.functions.PerformancePayoutAndFixedPricePayoutOnlyExists import PerformancePayoutAndFixedPricePayoutOnlyExists

__all__ = ['Qualify_BaseProduct_EquitySwap']


@replaceable
def Qualify_BaseProduct_EquitySwap(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as having the Asset Class classification Equity and Base Product Classification Swap.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (all_elements(Qualify_AssetClass_Equity(rosetta_resolve_attr(self, "economicTerms")), "=", True) and ((PerformancePayoutAndInterestRatePayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")) or PerformancePayoutAndFixedPricePayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"))) or PerformancePayoutOnlyExists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
