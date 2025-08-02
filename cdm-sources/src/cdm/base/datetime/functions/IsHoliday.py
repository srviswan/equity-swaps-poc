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
from cdm.base.datetime.functions.BusinessCenterHolidaysMultiple import BusinessCenterHolidaysMultiple

__all__ = ['IsHoliday']


@replaceable
def IsHoliday(checkDate: datetime.date, businessCenters: list[BusinessCenterEnum] | None) -> bool:
    """
    Returns whether a day is a holiday for the specified business centers
    
    Parameters 
    ----------
    checkDate : date
    The date being tested
    
    businessCenters : BusinessCenterEnum
    The business centers for which the test is required
    
    Returns
    -------
    isHoliday : boolean
    
    """
    self = inspect.currentframe()
    
    
    holidays = BusinessCenterHolidaysMultiple(rosetta_resolve_attr(self, "businessCenters"))
    isHoliday =  contains(rosetta_resolve_attr(self, "holidays"), rosetta_resolve_attr(self, "checkDate"))
    
    
    return isHoliday

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
