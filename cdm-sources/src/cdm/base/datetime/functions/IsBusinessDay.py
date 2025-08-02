# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.BusinessCenterEnum import BusinessCenterEnum
from cdm.base.datetime.functions.IsHoliday import IsHoliday
from cdm.base.datetime.functions.IsWeekend import IsWeekend

__all__ = ['IsBusinessDay']


@replaceable
def IsBusinessDay(date: datetime.date, businessCenters: list[BusinessCenterEnum] | None) -> bool:
    """
    returns an indicator of whether the supplied date is a good business date given the supplied business centers. True => good date, i.e. not a weekend or holiday. False means that it is either a weekend or a holiday
    
    Parameters 
    ----------
    date : date
    The date for which we want to determine whether it's a good business day
    
    businessCenters : BusinessCenterEnum
    The list of business centers to use
    
    Returns
    -------
    isGoodBusinessDay : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return False
    
    def _else_fn1():
        return True
    
    def _then_fn0():
        return False
    
    def _else_fn0():
        return if_cond_fn(rosetta_resolve_attr(self, "holiday"), _then_fn1, _else_fn1)
    
    weekend = IsWeekend(rosetta_resolve_attr(self, "date"), rosetta_resolve_attr(self, "businessCenters"))
    holiday = IsHoliday(rosetta_resolve_attr(self, "date"), rosetta_resolve_attr(self, "businessCenters"))
    isGoodBusinessDay =  if_cond_fn(rosetta_resolve_attr(self, "weekend"), _then_fn0, _else_fn0)
    
    
    return isGoodBusinessDay

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
