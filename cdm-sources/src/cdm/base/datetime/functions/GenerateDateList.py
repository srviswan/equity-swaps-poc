# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.functions.AppendDateToList import AppendDateToList
from cdm.base.datetime.BusinessCenterEnum import BusinessCenterEnum

__all__ = ['GenerateDateList']


@replaceable
def GenerateDateList(startDate: datetime.date, endDate: datetime.date, businessCenters: list[BusinessCenterEnum] | None) -> datetime.date:
    """
    Creates a list of good business days starting from the startDate and going to the end date, inclusive, omitting any days that are weekends or holidays according to the supplied business centers.
    
    Parameters 
    ----------
    startDate : date
    Start of the date range to be generated.
    
    endDate : date
    End of the date range to be generated
    
    businessCenters : BusinessCenterEnum
    Business centers to be used to generate the list of good business days
    
    Returns
    -------
    dateList : date
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return AppendDateToList(rosetta_resolve_attr(self, "priorList"), rosetta_resolve_attr(self, "endDate"))
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "priorList")
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "newList")
    
    def _else_fn1():
        return True
    
    active = all_elements(rosetta_resolve_attr(self, "startDate"), "<=", rosetta_resolve_attr(self, "endDate"))
    isGoodBusinessDay = IsBusinessDay(rosetta_resolve_attr(self, "endDate"), rosetta_resolve_attr(self, "businessCenters"))
    priorDate = AddBusinessDays(rosetta_resolve_attr(self, "endDate"), -1, rosetta_resolve_attr(self, "businessCenters"))
    priorList = GenerateDateList(rosetta_resolve_attr(self, "startDate"), rosetta_resolve_attr(self, "priorDate"), rosetta_resolve_attr(self, "businessCenters"))
    newList = if_cond_fn(rosetta_resolve_attr(self, "isGoodBusinessDay"), _then_fn0, _else_fn0)
    dateList = if_cond_fn(rosetta_resolve_attr(self, "active"), _then_fn0, _else_fn0)
    
    
    return dateList

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
