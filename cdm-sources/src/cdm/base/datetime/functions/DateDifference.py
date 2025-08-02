# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['DateDifference']


@replaceable
def DateDifference(firstDate: datetime.date, secondDate: datetime.date) -> int:
    """
    Subtracts the two supplied dates to return the number of calendar days between them.  A negative number implies first is after second.
    
    Parameters 
    ----------
    firstDate : date
    The earlier date.
    
    secondDate : date
    The later date.
    
    Returns
    -------
    difference : int
    
    """
    self = inspect.currentframe()
    
    
    difference = rosetta_resolve_attr(self, "difference")
    
    
    return difference

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
