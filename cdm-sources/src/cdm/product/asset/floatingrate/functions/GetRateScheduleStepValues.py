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

__all__ = ['GetRateScheduleStepValues']


@replaceable
def GetRateScheduleStepValues(schedule: RateSchedule, periodStartDate: datetime.date) -> Decimal:
    """
    Get all rate schedule step values whose stepDate is before or equal to the supplied periodStartDate.  Returns a list of step values starting from the initial rate.
    
    Parameters 
    ----------
    schedule : RateSchedule
    The rate schedule.
    
    periodStartDate : date
    The start date for which you want the rate.
    
    Returns
    -------
    stepValues : number
    
    """
    self = inspect.currentframe()
    
    
    stepValues = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "price"), "value")
    stepValues.add_rosetta_attr(self, (lambda item: map(lambda item: rosetta_resolve_attr(self, "value"), item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "schedule"), "price"), "datedValue"), lambda item: all_elements(rosetta_resolve_attr(self, "date"), "<=", rosetta_resolve_attr(self, "periodStartDate")))))
    
    
    return stepValues

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
