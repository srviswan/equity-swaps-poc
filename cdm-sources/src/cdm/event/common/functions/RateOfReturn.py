# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.PriceSchedule import PriceSchedule

__all__ = ['RateOfReturn']


@replaceable
def RateOfReturn(initialPrice: PriceSchedule, finalPrice: PriceSchedule) -> Decimal:
    """
    Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 139. 'Rate Of Return' means, in respect of any Equity Valuation Date, the amount determined pursuant to the following formula: Rate Of Return = (Final Price - Initial Price) / Initial Price.
    
    Parameters 
    ----------
    initialPrice : PriceSchedule
    
    finalPrice : PriceSchedule
    
    Returns
    -------
    rateOfReturn : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return ((rosetta_resolve_attr(self, "finalPriceValue") - rosetta_resolve_attr(self, "initialPriceValue")) / rosetta_resolve_attr(self, "initialPriceValue"))
    
    def _else_fn0():
        return True
    
    initialPriceValue = rosetta_resolve_attr(rosetta_resolve_attr(self, "initialPrice"), "value")
    finalPriceValue = rosetta_resolve_attr(rosetta_resolve_attr(self, "finalPrice"), "value")
    rateOfReturn =  if_cond_fn(((rosetta_attr_exists(rosetta_resolve_attr(self, "finalPriceValue")) and rosetta_attr_exists(rosetta_resolve_attr(self, "initialPriceValue"))) and all_elements(rosetta_resolve_attr(self, "initialPriceValue"), ">", 0)), _then_fn0, _else_fn0)
    
    
    return rateOfReturn

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
