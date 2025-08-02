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

__all__ = ['Qualify_Commodity_Swap_FixedFloat']


@replaceable
def Qualify_Commodity_Swap_FixedFloat(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as a Fixed Float Commodity Swap.  The determination of the qualification is based on the economic terms and the following criteria: 1) One Floating Leg represented by the CommodityPayout, with an underlier that is a commodity, 2) One Fixed Leg represented by the FixedPricePayout, and 3) there are no other payout types.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  (((all_elements(Qualify_AssetClass_Commodity(rosetta_resolve_attr(self, "economicTerms")), "=", True) and all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "=", 2)) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "CommodityPayout"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "FixedPricePayout")))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
