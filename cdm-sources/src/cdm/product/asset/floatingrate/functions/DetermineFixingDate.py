# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.ResetDates import ResetDates

__all__ = ['DetermineFixingDate']


@replaceable
def DetermineFixingDate(resetDates: ResetDates, resetDate: datetime.date) -> datetime.date:
    """
    Determine the observation (fixing) date needed given a reset dates structure and a reset date.
    
    Parameters 
    ----------
    resetDates : ResetDates
    Reset date parameters for observing the rate.
    
    resetDate : date
    The date that the rate is needed for.
    
    Returns
    -------
    fixingDate : date
    
    """
    self = inspect.currentframe()
    
    
    fixingOffsetDays = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "fixingDates"), "periodMultiplier")
    businessCenters = GetAllBusinessCenters(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "fixingDates"), "businessCenters"))
    fixDate = AddBusinessDays(rosetta_resolve_attr(self, "resetDate"), rosetta_resolve_attr(self, "fixingOffsetDays"), rosetta_resolve_attr(self, "businessCenters"))
    fixingDate =  rosetta_resolve_attr(self, "fixDate")
    
    
    return fixingDate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
