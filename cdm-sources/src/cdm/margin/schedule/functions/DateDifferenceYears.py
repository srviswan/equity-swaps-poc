# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['DateDifferenceYears']


@replaceable
def DateDifferenceYears(firstDate: datetime.date, secondDate: datetime.date) -> Decimal:
    """
    Computes the difference in years between two dates. All years are supposed to have 365 days.
    
    Parameters 
    ----------
    firstDate : date
    The earlier date.
    
    secondDate : date
    The later date.
    
    Returns
    -------
    difference : number
    
    """
    self = inspect.currentframe()
    
    
    difference =  (DateDifference(rosetta_resolve_attr(self, "firstDate"), rosetta_resolve_attr(self, "secondDate")) / 365.0)
    
    
    return difference

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
