# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.asset.rates.FloatingRateIndexEnum import FloatingRateIndexEnum

__all__ = ['ResolveRateIndex']


@replaceable
def ResolveRateIndex(index: FloatingRateIndexEnum) -> Decimal:
    """
    The function to specify that the floating rate index enumeration will be expressed as a number once the rate is observed.
    
    Parameters 
    ----------
    index : FloatingRateIndexEnum
    
    Returns
    -------
    rate : number
    
    """
    self = inspect.currentframe()
    
    
    rate = rosetta_resolve_attr(self, "rate")
    
    
    return rate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
