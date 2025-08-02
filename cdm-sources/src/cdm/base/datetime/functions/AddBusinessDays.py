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
from cdm.base.datetime.functions.AddDays import AddDays
from cdm.base.datetime.functions.IsBusinessDay import IsBusinessDay

__all__ = ['AddBusinessDays']


@replaceable
def AddBusinessDays(originalDate: datetime.date, offsetBusinessDays: int, businessCenters: list[BusinessCenterEnum] | None) -> datetime.date:
    """
    Returns a good business date that has been offset by the given number of business days given the supplied business centers. A negative value implies an earlier date (before the supplied originalDate), and a positive value a later date (after the supplied date).
    
    Parameters 
    ----------
    originalDate : date
    date to be shifted. If not a good business day, a supplied shift of 0 will shift it to the next business day
    
    offsetBusinessDays : int
    number of business days to shift the original date
    
    businessCenters : BusinessCenterEnum
    business centers to use in the shifting
    
    Returns
    -------
    shiftedDate : date
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return -1
    
    def _else_fn0():
        return 1
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "shift")
    
    def _else_fn1():
        return 0
    
    def _then_fn2():
        return 0
    
    def _else_fn2():
        return (rosetta_resolve_attr(self, "offsetBusinessDays") - rosetta_resolve_attr(self, "newShift"))
    
    def _then_fn3():
        return rosetta_resolve_attr(self, "originalDate")
    
    def _else_fn3():
        return AddBusinessDays(rosetta_resolve_attr(self, "shiftedByOne"), rosetta_resolve_attr(self, "newOffset"), rosetta_resolve_attr(self, "businessCenters"))
    
    isGoodBusinessDay = IsBusinessDay(rosetta_resolve_attr(self, "originalDate"), rosetta_resolve_attr(self, "businessCenters"))
    shift = if_cond_fn(all_elements(rosetta_resolve_attr(self, "offsetBusinessDays"), "<", 0), _then_fn0, _else_fn0)
    shiftedByOne = AddDays(rosetta_resolve_attr(self, "originalDate"), rosetta_resolve_attr(self, "shift"))
    isShiftedGood = IsBusinessDay(rosetta_resolve_attr(self, "shiftedByOne"), rosetta_resolve_attr(self, "businessCenters"))
    newShift = if_cond_fn(rosetta_resolve_attr(self, "isShiftedGood"), _then_fn1, _else_fn1)
    newOffset = if_cond_fn(all_elements(rosetta_resolve_attr(self, "offsetBusinessDays"), "=", 0), _then_fn2, _else_fn2)
    done = (all_elements(rosetta_resolve_attr(self, "offsetBusinessDays"), "=", 0) and all_elements(rosetta_resolve_attr(self, "isGoodBusinessDay"), "=", True))
    newDate = if_cond_fn(rosetta_resolve_attr(self, "done"), _then_fn3, _else_fn3)
    shiftedDate =  rosetta_resolve_attr(self, "newDate")
    
    
    return shiftedDate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
