# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['PopOffDateList']


@replaceable
def PopOffDateList(dates: list[datetime.date] | None) -> datetime.date:
    """
    Remove last element from a list of dates.
    
    Parameters 
    ----------
    dates : date
    List of dates.
    
    Returns
    -------
    newList : date
    
    """
    self = inspect.currentframe()
    
    
    newList = rosetta_resolve_attr(self, "newList")
    
    
    return newList

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
