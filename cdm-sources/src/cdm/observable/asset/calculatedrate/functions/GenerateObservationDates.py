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
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase

__all__ = ['GenerateObservationDates']


@replaceable
def GenerateObservationDates(observationPeriod: CalculationPeriodBase, businessCenters: list[BusinessCenterEnum] | None, lockoutDays: int | None) -> datetime.date:
    """
    Generate the list of observation dates given an observation period.
    
    Parameters 
    ----------
    observationPeriod : CalculationPeriodBase
    The given observation period.
    
    businessCenters : BusinessCenterEnum
    The observation date.
    
    lockoutDays : int
    The number of lockout date.
    
    Returns
    -------
    observationDates : date
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "lockoutDays")
    
    def _else_fn0():
        return 0
    
    days = (1 + if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "lockoutDays")), _then_fn0, _else_fn0))
    endDate = AddBusinessDays(rosetta_resolve_attr(rosetta_resolve_attr(self, "observationPeriod"), "adjustedEndDate"), (-1 * rosetta_resolve_attr(self, "days")), rosetta_resolve_attr(self, "businessCenters"))
    observationDates = GenerateDateList(rosetta_resolve_attr(rosetta_resolve_attr(self, "observationPeriod"), "adjustedStartDate"), rosetta_resolve_attr(self, "endDate"), rosetta_resolve_attr(self, "businessCenters"))
    
    
    return observationDates

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
