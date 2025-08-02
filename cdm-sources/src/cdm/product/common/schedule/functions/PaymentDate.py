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

__all__ = ['PaymentDate']


@replaceable
def PaymentDate(economicTerms: EconomicTerms) -> datetime.date:
    """
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    result : date
    
    """
    self = inspect.currentframe()
    
    
    result =  rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "payout"), "InterestRatePayout")), "paymentDate"), "adjustedDate")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
