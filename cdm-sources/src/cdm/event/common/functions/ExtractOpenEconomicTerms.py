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
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['ExtractOpenEconomicTerms']


@replaceable
def ExtractOpenEconomicTerms(businessEvent: BusinessEvent) -> EconomicTerms:
    """
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    economicTerms : EconomicTerms
    
    """
    self = inspect.currentframe()
    
    
    economicTerms =  rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))), "trade"), "product"), "economicTerms")
    
    
    return economicTerms

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
