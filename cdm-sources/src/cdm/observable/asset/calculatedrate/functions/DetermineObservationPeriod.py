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
from cdm.observable.asset.calculatedrate.functions.GenerateObservationPeriod import GenerateObservationPeriod
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['DetermineObservationPeriod']


@replaceable
def DetermineObservationPeriod(adjustedCalculationPeriod: CalculationPeriodBase, calculationParams: FloatingRateCalculationParameters) -> CalculationPeriodBase:
    """
    Determine any applicable offsets/shifts for the period for observing an index, and then generate the date range to be used for observing the index, based on the calculation period, plus any applicable offsets/shift.
    
    Parameters 
    ----------
    adjustedCalculationPeriod : CalculationPeriodBase
    The calculation period for which the rate is being computed, after any adjustment.
    
    calculationParams : FloatingRateCalculationParameters
    Floating rate definition for the calculated rate.
    
    Returns
    -------
    observationPeriod : CalculationPeriodBase
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "lookback"), "offsetDays")
    
    def _else_fn1():
        return 0
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "obsShift"), "offsetDays")
    
    def _else_fn0():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "lookback")), _then_fn1, _else_fn1)
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "shift")
    
    def _else_fn1():
        return 5
    
    obsShift = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "observationShiftCalculation")
    lookback = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "lookbackCalculation")
    businessDays = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParams"), "applicableBusinessDays")
    additionalBusinessDays = rosetta_resolve_attr(rosetta_resolve_attr(self, "obsShift"), "additionalBusinessDays")
    allBusinessDays = (lambda item: flatten_list(item))(map(lambda item: GetAllBusinessCenters(item), [rosetta_resolve_attr(self, "businessDays"), rosetta_resolve_attr(self, "additionalBusinessDays")]))
    shift = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "obsShift")), _then_fn0, _else_fn0)
    shiftDefaulted = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "shift")), _then_fn1, _else_fn1)
    observationPeriod =  GenerateObservationPeriod(rosetta_resolve_attr(self, "adjustedCalculationPeriod"), rosetta_resolve_attr(self, "allBusinessDays"), rosetta_resolve_attr(self, "shiftDefaulted"))
    
    
    return observationPeriod

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
