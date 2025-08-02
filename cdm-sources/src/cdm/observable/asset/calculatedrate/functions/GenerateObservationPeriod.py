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

__all__ = ['GenerateObservationPeriod']


@replaceable
def GenerateObservationPeriod(calculationPeriod: CalculationPeriodBase, businessCenters: list[BusinessCenterEnum] | None, shiftDays: int | None) -> CalculationPeriodBase:
    """
    Generate the date range to be used for observing the index, based on the calculation period, plus any applicable offsets/shifts.
    
    Parameters 
    ----------
    calculationPeriod : CalculationPeriodBase
    The calculation period for which the rate is being compute.
    
    businessCenters : BusinessCenterEnum
    The business centers to be used for shifting.
    
    shiftDays : int
    The amount of any shift.
    
    Returns
    -------
    observationPeriod : CalculationPeriodBase
    
    """
    self = inspect.currentframe()
    
    
    calcStart = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedStartDate")
    calcEnd = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedEndDate")
    obsStart = AddBusinessDays(rosetta_resolve_attr(self, "calcStart"), (-1 * rosetta_resolve_attr(self, "shiftDays")), rosetta_resolve_attr(self, "businessCenters"))
    obsEnd = AddBusinessDays(rosetta_resolve_attr(self, "calcEnd"), (-1 * rosetta_resolve_attr(self, "shiftDays")), rosetta_resolve_attr(self, "businessCenters"))
    observationPeriod = _get_rosetta_object('CalculationPeriodBase', 'adjustedStartDate', rosetta_resolve_attr(self, "obsStart"))
    observationPeriod = set_rosetta_attr(rosetta_resolve_attr(self, 'observationPeriod'), 'adjustedEndDate', rosetta_resolve_attr(self, "obsEnd"))
    
    
    return observationPeriod

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
