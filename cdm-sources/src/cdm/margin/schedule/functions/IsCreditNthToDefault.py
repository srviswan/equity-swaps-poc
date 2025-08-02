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

__all__ = ['IsCreditNthToDefault']


@replaceable
def IsCreditNthToDefault(economicTerms: EconomicTerms) -> bool:
    """
    Identifies a product as a CR basket Nth to default.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_Product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_Product =  rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "CreditDefaultPayout"), "generalTerms"), "basketReferenceInformation"), "nthToDefault"))
    
    
    return is_Product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
