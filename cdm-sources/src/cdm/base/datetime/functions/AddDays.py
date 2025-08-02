# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['AddDays']


@replaceable
def AddDays(inputDate: datetime.date, numDays: int) -> datetime.date:
    """
    Adds the specified number of calendar days to the supplied date.  A negative number will generate a date before the supplied date.
    
    Parameters 
    ----------
    inputDate : date
    The base date for the calculation.
    
    numDays : int
    The number of days to add.
    
    Returns
    -------
    resultDate : date
    
    """
    self = inspect.currentframe()
    
    
    resultDate = rosetta_resolve_attr(self, "resultDate")
    
    
    return resultDate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
