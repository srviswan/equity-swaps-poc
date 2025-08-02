# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.calculatedrate.functions.GenerateObservationDatesAndWeights import GenerateObservationDatesAndWeights
from cdm.base.datetime.daycount.DayCountFractionEnum import DayCountFractionEnum
from cdm.observable.asset.calculatedrate.functions.IndexValueObservationMultiple import IndexValueObservationMultiple
from cdm.observable.asset.calculatedrate.CalculationMethodEnum import CalculationMethodEnum
from cdm.observable.asset.calculatedrate.functions.ApplyCompoundingFormula import ApplyCompoundingFormula
from cdm.product.asset.floatingrate.FloatingRateSettingDetails import FloatingRateSettingDetails
from cdm.observable.asset.calculatedrate.functions.ApplyAveragingFormula import ApplyAveragingFormula
from cdm.base.datetime.daycount.functions.YearFractionForOneDay import YearFractionForOneDay
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.observable.asset.calculatedrate.functions.ProcessObservations import ProcessObservations
from cdm.observable.asset.InterestRateIndex import InterestRateIndex
from cdm.product.common.schedule.ResetDates import ResetDates
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['EvaluateCalculatedRate']


@replaceable
def EvaluateCalculatedRate(interestRateIndex: InterestRateIndex, calculationParameters: FloatingRateCalculationParameters, resetDates: ResetDates | None, calculationPeriod: CalculationPeriodBase, priorCalculationPeriod: CalculationPeriodBase | None, dayCount: DayCountFractionEnum) -> FloatingRateSettingDetails:
    """
    Evaluate a calculated rate as described in the 2021 ISDA Definitions.
    
    Parameters 
    ----------
    interestRateIndex : InterestRateIndex
    The base floating rate index.
    
    calculationParameters : FloatingRateCalculationParameters
    Floating rate definition for the calculated rate.
    
    resetDates : ResetDates
    Reset structure (needed only for fallback rates, otherwise will be empty).
    
    calculationPeriod : CalculationPeriodBase
    Calculation period for which we want to determine the rate.
    
    priorCalculationPeriod : CalculationPeriodBase
    The prior calculation period (needed only for set in advance observation shift rate.
    
    dayCount : DayCountFractionEnum
    The day count fraction in effect on the stream.
    
    Returns
    -------
    results : FloatingRateSettingDetails
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return ApplyCompoundingFormula(rosetta_resolve_attr(self, "processedObservations"), rosetta_resolve_attr(self, "weights"), rosetta_resolve_attr(self, "yearFraction"))
    
    def _else_fn0():
        return ApplyAveragingFormula(rosetta_resolve_attr(self, "observations"), rosetta_resolve_attr(self, "weights"))
    
    rate = rosetta_resolve_attr(self, "interestRateIndex")
    datesAndWeights = GenerateObservationDatesAndWeights(rosetta_resolve_attr(self, "calculationParameters"), rosetta_resolve_attr(self, "resetDates"), rosetta_resolve_attr(self, "calculationPeriod"), rosetta_resolve_attr(self, "priorCalculationPeriod"))
    observationDates = rosetta_resolve_attr(rosetta_resolve_attr(self, "datesAndWeights"), "observationDates")
    observations = IndexValueObservationMultiple(rosetta_resolve_attr(self, "observationDates"), rosetta_resolve_attr(self, "rate"))
    processedObservations = ProcessObservations(rosetta_resolve_attr(self, "calculationParameters"), rosetta_resolve_attr(self, "observations"))
    calculationMethod = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationParameters"), "calculationMethod")
    isCompounding = all_elements(rosetta_resolve_attr(self, "calculationMethod"), "=", rosetta_resolve_attr(CalculationMethodEnum, "COMPOUNDING"))
    weights = rosetta_resolve_attr(rosetta_resolve_attr(self, "datesAndWeights"), "weights")
    yearFraction = YearFractionForOneDay(rosetta_resolve_attr(self, "dayCount"))
    calculationResults = if_cond_fn(rosetta_resolve_attr(self, "isCompounding"), _then_fn0, _else_fn0)
    results = _get_rosetta_object('FloatingRateSettingDetails', 'calculationDetails', rosetta_resolve_attr(self, "calculationResults"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'calculationDetails'), 'observations'), 'observationDates'), rosetta_resolve_attr(rosetta_resolve_attr(self, "datesAndWeights"), "observationDates"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'calculationDetails'), 'observations'), 'weights'), rosetta_resolve_attr(rosetta_resolve_attr(self, "datesAndWeights"), "weights"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'calculationDetails'), 'observations'), 'observedRates'), rosetta_resolve_attr(self, "observations"))
    results.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, results), 'calculationDetails'), 'observations'), 'processedRates'), rosetta_resolve_attr(self, "processedObservations"))
    results = set_rosetta_attr(rosetta_resolve_attr(self, 'results'), 'floatingRate', rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationResults"), "calculatedRate"))
    
    
    return results

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
