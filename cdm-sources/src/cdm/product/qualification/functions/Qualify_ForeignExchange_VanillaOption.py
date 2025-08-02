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

__all__ = ['Qualify_ForeignExchange_VanillaOption']


@replaceable
def Qualify_ForeignExchange_VanillaOption(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as FX Plain Vanilla Option based on economic terms, which is defined as one where 1) exercise style is American or European style only, and 2) does not contain any feature like Forward Starting Strike or Performance payout.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    optionPayout = rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "OptionPayout")
    is_product =  (((Qualify_AssetClass_ForeignExchange(rosetta_resolve_attr(self, "economicTerms")) and rosetta_attr_exists(rosetta_resolve_attr(self, "optionPayout"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "exerciseTerms"), "style"), "<>", rosetta_resolve_attr(OptionExerciseStyleEnum, "BERMUDA"))) and ((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "feature"))) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "feature"), "averagingFeature"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
