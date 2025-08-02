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

__all__ = ['Qualify_ForeignExchange_ParameterReturnCorrelation']


@replaceable
def Qualify_ForeignExchange_ParameterReturnCorrelation(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as Foreign Exchange Swap for which the performance is based on the correlation changes between the constituents of a basket.  The determination of the qualification is based on the economic terms and the following criteria: 1) Is a product with with only one performance leg 2) which has correlation return terms, 3) with a basket underlier 4) which is exclusively constituted by foreign exchange constituents and 5) there are no option features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    performancePayout = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "PerformancePayout"))
    is_product =  ((((all_elements(Qualify_AssetClass_ForeignExchange(rosetta_resolve_attr(self, "economicTerms")), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "PerformancePayout"))) and self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "returnTerms"), "correlationReturnTerms"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "underlier"), "Observable"), "Basket"))) and all_elements(map(lambda item: rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "Index"), "ForeignExchangeRateIndex")), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "underlier"), "Observable"), "Basket"), "basketConstituent")), "=", True))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
