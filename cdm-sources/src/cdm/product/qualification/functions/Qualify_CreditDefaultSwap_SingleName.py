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

__all__ = ['Qualify_CreditDefaultSwap_SingleName']


@replaceable
def Qualify_CreditDefaultSwap_SingleName(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as a Credit Default Swap which provides protection relative to defaults of a reference entity that could be a corporate, municipal, sovereign, or special purpose vehicle issuer of publicly traded debt.  The determination of the qualification is based on the economic terms and the following criteria: 1) A product with one credit default leg and one interest leg, 2) the reference entity is corporate, municipal, or sovereign issuer of debt, 3) the reference obligation is not a loan, and 4) there are no option features.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_product =  ((all_elements(Qualify_AssetClass_Credit(rosetta_resolve_attr(self, "economicTerms")), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "referenceInformation"), "referenceObligation"), "loan"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
