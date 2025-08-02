# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.functions.DayOfWeek import DayOfWeek
from cdm.base.datetime.BusinessCenterEnum import BusinessCenterEnum
from cdm.base.datetime.DayOfWeekEnum import DayOfWeekEnum

__all__ = ['IsWeekend']


@replaceable
def IsWeekend(date: datetime.date, businessCenters: list[BusinessCenterEnum] | None) -> bool:
    """
    returns whether the supplied date is a weekend. This assumes a 5 day week with Saturday and Sunday as holidays. A more sophisticated implementation might use the business centers to determine which days are weekends, but most jurisdictions where derivatives are traded follow this convention.
    
    Parameters 
    ----------
    date : date
    The date for which the weekday is needed
    
    businessCenters : BusinessCenterEnum
    Not needed for the current implementation so ignored, but kept for future extensibility
    
    Returns
    -------
    isWeekend : boolean
    
    """
    self = inspect.currentframe()
    
    
    dayOfWeek = DayOfWeek(rosetta_resolve_attr(self, "date"))
    isWeekend =  (all_elements(rosetta_resolve_attr(self, "dayOfWeek"), "=", rosetta_resolve_attr(DayOfWeekEnum, "SAT")) or all_elements(rosetta_resolve_attr(self, "dayOfWeek"), "=", rosetta_resolve_attr(DayOfWeekEnum, "SUN")))
    
    
    return isWeekend

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
