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
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['DetermineWeightingDates']


@replaceable
def DetermineWeightingDates(calculationParams: FloatingRateCalculationParameters, observationDates: list[datetime.date] | None, observationPeriod: CalculationPeriodBase, adjustedCalculationPeriod: CalculationPeriodBase, lockoutDays: int) -> datetime.date:
    """
    Determine the dates to be used for weighting observation.
    
    Parameters 
    ----------
    calculationParams : FloatingRateCalculationParameters
    Floating rate definition for the calculated rate.
    
    observationDates : date
    
    observationPeriod : CalculationPeriodBase
    The resulting observation period.
    
    adjustedCalculationPeriod : CalculationPeriodBase
    The calculation period for which the rate is being computed, after any adjustment.
    
    lockoutDays : int
    The number of lockout day.
    
    Returns
    -------
    weightingDates : date
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "observationDates")
    
    def _else_fn0():
        return GenerateObservationDates(rosetta_resolve_attr(self, "adjustedCalculationPeriod"), rosetta_resolve_attr(self, "businessCenters"), rosetta_resolve_attr(self, "lockoutDays"))
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "adjustedCalculationPeriod")
    
    def _else_fn1():
        return rosetta_resolve_attr(self, "observationPeriod")
    
    obsShift = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "observationShiftCalculation")
    lookback = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "lookbackCalculation")
    businessCenters = GetAllBusinessCenters(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "applicableBusinessDays"))
    baseWeightingDates = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "obsShift")), _then_fn0, _else_fn0)
    wtPeriod = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "lookback")), _then_fn1, _else_fn1)
    weightingDatesAll = AppendDateToList(rosetta_resolve_attr(self, "baseWeightingDates"), rosetta_resolve_attr(rosetta_resolve_attr(self, "wtPeriod"), "adjustedEndDate"))
    weightingDates = rosetta_resolve_attr(self, "weightingDatesAll")
    
    
    return weightingDates

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
