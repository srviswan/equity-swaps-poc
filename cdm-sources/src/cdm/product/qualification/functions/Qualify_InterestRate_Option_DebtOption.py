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

__all__ = ['Qualify_InterestRate_Option_DebtOption']


@replaceable
def Qualify_InterestRate_Option_DebtOption(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as a Option that can be exercised into an Debt Product based on the economic terms.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    optionPayout = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "OptionPayout")
    is_product =  ((all_elements(Qualify_AssetClass_InterestRate(rosetta_resolve_attr(self, "economicTerms")), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout")), "OptionPayout"))) and all_elements(map(lambda item: ObservableQualification(item, rosetta_resolve_attr(InstrumentTypeEnum, "DEBT"), []), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "optionPayout"), "underlier"), "Observable")), "=", True))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
