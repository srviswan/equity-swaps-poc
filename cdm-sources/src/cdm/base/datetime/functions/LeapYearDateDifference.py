# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['LeapYearDateDifference']


@replaceable
def LeapYearDateDifference(firstDate: datetime.date, secondDate: datetime.date) -> int:
    """
    Subtracts the two supplied dates to return the number of leap year calendar days between them. A negative number implies firstDate is after secondDate.
    
    Parameters 
    ----------
    firstDate : date
    The left side of the subtraction.
    
    secondDate : date
    The right side of the subtraction.
    
    Returns
    -------
    difference : int
    
    """
    self = inspect.currentframe()
    
    
    difference = rosetta_resolve_attr(self, "difference")
    
    
    return difference

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
