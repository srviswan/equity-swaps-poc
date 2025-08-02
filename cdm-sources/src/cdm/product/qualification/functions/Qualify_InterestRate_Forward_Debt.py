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

__all__ = ['Qualify_InterestRate_Forward_Debt']


@replaceable
def Qualify_InterestRate_Forward_Debt(economicTerms: EconomicTerms) -> bool:
    """
    Qualifies a product as Interest Rate Bond Forward based on economic terms, which is defined as a transaction in which one party agrees to pay an agreed price for a specified amount of a bond of an issuer or a basket of bonds of several issuers at a future date and the other party agrees to pay a price for the same amount of the same bond to be set on a specified date in the future.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_product : boolean
    
    """
    self = inspect.currentframe()
    
    
    forwardPayout = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "SettlementPayout"))
    is_product =  (all_elements(Qualify_AssetClass_InterestRate(rosetta_resolve_attr(self, "economicTerms")), "=", True) and (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "forwardPayout"), "underlier"), "Observable"), "Asset"), "Instrument"), "Security")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "forwardPayout"), "underlier"), "Product"), "TransferableProduct"), "Instrument"), "Security"))))
    
    
    return is_product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
