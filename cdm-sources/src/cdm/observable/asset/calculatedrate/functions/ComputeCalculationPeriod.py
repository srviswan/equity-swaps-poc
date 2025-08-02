# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.common.schedule.ResetRelativeToEnum import ResetRelativeToEnum

__all__ = ['ComputeCalculationPeriod']


@replaceable
def ComputeCalculationPeriod() -> None:
    """
    
    Parameters 
    ----------
    
    Returns
    -------
    No Return
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "priorCalculationPeriod")
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "calculationPeriod")
    
    resetRelativeTo = rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "resetRelativeTo")
    isStart = all_elements(rosetta_resolve_attr(self, "resetRelativeTo"), "=", rosetta_resolve_attr(ResetRelativeToEnum, "CALCULATION_PERIOD_START_DATE"))
    calcPd = if_cond_fn(rosetta_resolve_attr(self, "isStart"), _then_fn0, _else_fn0)
    fixingOffsetDays = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "fixingDates"), "periodMultiplier")
    businessCenters = GetAllBusinessCenters(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "resetDates"), "resetDatesAdjustments"), "businessCenters"))
    endDate = AddBusinessDays(rosetta_resolve_attr(rosetta_resolve_attr(self, "calcPd"), "adjustedEndDate"), rosetta_resolve_attr(self, "fixingOffsetDays"), rosetta_resolve_attr(self, "businessCenters"))
    startDate = AddBusinessDays(rosetta_resolve_attr(rosetta_resolve_attr(self, "calcPd"), "adjustedStartDate"), rosetta_resolve_attr(self, "fixingOffsetDays"), rosetta_resolve_attr(self, "businessCenters"))

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
