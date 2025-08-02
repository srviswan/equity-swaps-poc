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

__all__ = ['BusinessCenterHolidays']


@replaceable
def BusinessCenterHolidays(businessCenter: BusinessCenterEnum) -> datetime.date:
    """
    
    Parameters 
    ----------
    businessCenter : BusinessCenterEnum
    
    Returns
    -------
    holidayDates : date
    
    """
    self = inspect.currentframe()
    
    
    holidayDates = rosetta_resolve_attr(self, "holidayDates")
    
    
    return holidayDates

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
