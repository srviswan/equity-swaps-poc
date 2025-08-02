# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.common.schedule.ResetDates import ResetDates

__all__ = ['DetermineResetDate']


@replaceable
def DetermineResetDate(resetDates: ResetDates, calculationPeriod: CalculationPeriodBase) -> datetime.date:
    """
    Determine the value of the reset date given a reset dates structure and a calculation paeriod for which it's needed. Reset dates are defined in the 2021 ISDA Definition in Section 6.5.5.
    
    Parameters 
    ----------
    resetDates : ResetDates
    Reset dates for observing the rate.
    
    calculationPeriod : CalculationPeriodBase
    Calculation period for which you want the rate.
    
    Returns
    -------
    resetDate : date
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedStartDate")
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedEndDate")
    
    resetRelativeTo = rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "resetRelativeTo")
    isStart = all_elements(rosetta_resolve_attr(self, "resetRelativeTo"), "=", rosetta_resolve_attr(ResetRelativeToEnum, "CALCULATION_PERIOD_START_DATE"))
    reset = if_cond_fn(rosetta_resolve_attr(self, "isStart"), _then_fn0, _else_fn0)
    resetDate =  rosetta_resolve_attr(self, "reset")
    
    
    return resetDate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
