# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.RateSchedule import RateSchedule
from cdm.product.asset.floatingrate.functions.GetRateScheduleStepValues import GetRateScheduleStepValues

__all__ = ['GetRateScheduleAmount']


@replaceable
def GetRateScheduleAmount(schedule: RateSchedule, periodStartDate: datetime.date) -> Decimal:
    """
    Get the rate for the period start date.
    
    Parameters 
    ----------
    schedule : RateSchedule
    The rate schedule.
    
    periodStartDate : date
    The start date for which you want the rate.
    
    Returns
    -------
    amount : number
    
    """
    self = inspect.currentframe()
    
    
    amount =  GetRateScheduleStepValues(rosetta_resolve_attr(self, "schedule"), rosetta_resolve_attr(self, "periodStartDate"))[-1]
    
    
    return amount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
