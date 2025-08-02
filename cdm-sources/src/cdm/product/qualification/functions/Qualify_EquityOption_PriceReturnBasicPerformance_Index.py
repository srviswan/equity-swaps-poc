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

__all__ = ['Qualify_EquityOption_PriceReturnBasicPerformance_Index']


@replaceable
def Qualify_EquityOption_PriceReturnBasicPerformance_Index(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as an Equity Option with an index as underlier.  The determination of the qualification is based on the economic terms and the following criteria: 1) An option product  for which the underlier is an index and 2) No special option feature exists other than option averaging.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "nonStandardisedTerms"), "=", False)
    
    def _else_fn0():
        return True
    
    optionPayout = rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "OptionPayout")
    is_product =  ((((Qualify_AssetClass_Equity(rosetta_resolve_attr(self, "economicTerms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "optionPayout"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "underlier"), "Observable"), "Index"), "EquityIndex"))) and ((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "feature"))) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "feature"), "averagingFeature"))) or rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "feature"), "fxFeature")), "quanto"))) or rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "feature"), "fxFeature")), "composite")))) and if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "nonStandardisedTerms")), _then_fn0, _else_fn0))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
