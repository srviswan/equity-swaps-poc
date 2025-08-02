# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.calculatedrate.functions.GenerateObservationDates import GenerateObservationDates
from cdm.observable.asset.calculatedrate.ObservationPeriodDatesEnum import ObservationPeriodDatesEnum
from cdm.observable.asset.calculatedrate.functions.ComputeCalculationPeriod import ComputeCalculationPeriod
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.observable.asset.calculatedrate.functions.DetermineObservationPeriod import DetermineObservationPeriod
from cdm.observable.asset.calculatedrate.CalculatedRateObservationDatesAndWeights import CalculatedRateObservationDatesAndWeights
from cdm.product.common.schedule.ResetDates import ResetDates
from cdm.observable.asset.calculatedrate.functions.GenerateWeightings import GenerateWeightings
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['GenerateObservationDatesAndWeights']


@replaceable
def GenerateObservationDatesAndWeights(calculationParams: FloatingRateCalculationParameters, resetDates: ResetDates | None, calculationPeriod: CalculationPeriodBase, priorCalculationPeriod: CalculationPeriodBase | None) -> CalculatedRateObservationDatesAndWeights:
    """
    Apply shifts to generate the list of observation dates and weights for each of those date.
    
    Parameters 
    ----------
    calculationParams : FloatingRateCalculationParameters
    Floating rate definition for the calculated rate.
    
    resetDates : ResetDates
    Reset structure (needed only for fallback rates, otherwise will be empty.
    
    calculationPeriod : CalculationPeriodBase
    Calculation period for which we want to determine the rate.
    
    priorCalculationPeriod : CalculationPeriodBase
    The prior calculation period (needed only for set in advance observation shift rate.
    
    Returns
    -------
    results : CalculatedRateObservationDatesAndWeights
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "lockout"), "offsetDays")
    
    def _else_fn0():
        return 5
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "specifiedLockout")
    
    def _else_fn1():
        return 0
    
    def _then_fn2():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "obsShift"), "calculationBase")
    
    def _else_fn2():
        return rosetta_resolve_attr(ObservationPeriodDatesEnum, "STANDARD")
    
    obsShift = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "observationShiftCalculation")
    lockout = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "lockoutCalculation")
    specifiedLockout = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "lockout"), "offsetDays")), _then_fn0, _else_fn0)
    lockoutDays = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "lockout")), _then_fn1, _else_fn1)
    businessDays = GetAllBusinessCenters(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "applicableBusinessDays"))
    calculateRelative = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "obsShift"), "calculationBase")), _then_fn2, _else_fn2)
    adjustedCalculationPeriod = ComputeCalculationPeriod(rosetta_resolve_attr(self, "calculationPeriod"), rosetta_resolve_attr(self, "priorCalculationPeriod"), rosetta_resolve_attr(self, "calculateRelative"), rosetta_resolve_attr(self, "resetDates"))
    observationPeriod = DetermineObservationPeriod(rosetta_resolve_attr(self, "adjustedCalculationPeriod"), rosetta_resolve_attr(self, "calculationParams"))
    observationDates = GenerateObservationDates(rosetta_resolve_attr(self, "observationPeriod"), rosetta_resolve_attr(self, "businessDays"), rosetta_resolve_attr(self, "lockoutDays"))
    results = rosetta_resolve_attr(self, "observationDates")
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'weights'), GenerateWeightings(rosetta_resolve_attr(self, "calculationParams"), rosetta_resolve_attr(rosetta_resolve_attr(self, "results"), "observationDates"), rosetta_resolve_attr(self, "observationPeriod"), rosetta_resolve_attr(self, "adjustedCalculationPeriod"), rosetta_resolve_attr(self, "lockoutDays")))
    
    
    return results

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
