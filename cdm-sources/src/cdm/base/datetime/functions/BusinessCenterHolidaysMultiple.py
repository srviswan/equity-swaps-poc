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
from cdm.base.datetime.functions.BusinessCenterHolidays import BusinessCenterHolidays

__all__ = ['BusinessCenterHolidaysMultiple']


@replaceable
def BusinessCenterHolidaysMultiple(businessCenters: list[BusinessCenterEnum] | None) -> datetime.date:
    """
    Returns a merged list of holidays for the supplied business centers.
    
    Parameters 
    ----------
    businessCenters : BusinessCenterEnum
    The business centers for which the holiday list is required.
    
    Returns
    -------
    holidayDates : date
    
    """
    self = inspect.currentframe()
    
    
    holidayDates = (lambda item: sorted(item))((lambda item: set(item))((lambda item: flatten_list(item))(map(lambda item: BusinessCenterHolidays(item), rosetta_resolve_attr(self, "businessCenters")))))
    
    
    return holidayDates

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
