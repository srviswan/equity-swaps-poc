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
from cdm.observable.asset.calculatedrate.functions.GenerateWeights import GenerateWeights
from cdm.observable.asset.calculatedrate.functions.DetermineWeightingDates import DetermineWeightingDates
from cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters import FloatingRateCalculationParameters

__all__ = ['GenerateWeightings']


@replaceable
def GenerateWeightings(calculationParams: FloatingRateCalculationParameters, observationDates: list[datetime.date] | None, observationPeriod: CalculationPeriodBase, adjustedCalculationPeriod: CalculationPeriodBase, lockoutDays: int) -> Decimal:
    """
    Determine the weighting dates and the corresponding weights to be used for weighting observation.
    
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
    weights : number
    
    """
    self = inspect.currentframe()
    
    
    weightingDates = DetermineWeightingDates(rosetta_resolve_attr(self, "calculationParams"), rosetta_resolve_attr(self, "observationDates"), rosetta_resolve_attr(self, "observationPeriod"), rosetta_resolve_attr(self, "adjustedCalculationPeriod"), rosetta_resolve_attr(self, "lockoutDays"))
    weights =  GenerateWeights(rosetta_resolve_attr(self, "weightingDates"))
    
    
    return weights

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
