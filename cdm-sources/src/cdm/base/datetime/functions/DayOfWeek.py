# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.DayOfWeekEnum import DayOfWeekEnum

__all__ = ['DayOfWeek']


@replaceable
def DayOfWeek(date: datetime.date) -> DayOfWeekEnum:
    """
    Returns the day of week corresponding to the supplied date.
    
    Parameters 
    ----------
    date : date
    The date for which the weekday is needed.
    
    Returns
    -------
    dayOfWeek : DayOfWeekEnum
    
    """
    self = inspect.currentframe()
    
    
    dayOfWeek = rosetta_resolve_attr(self, "dayOfWeek")
    
    
    return dayOfWeek

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
