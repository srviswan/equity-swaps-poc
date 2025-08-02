# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.FloatingRateProcessingParameters import FloatingRateProcessingParameters
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.asset.floatingrate.functions.CapRateAmount import CapRateAmount
from cdm.product.asset.floatingrate.functions.FloorRateAmount import FloorRateAmount
from cdm.product.asset.floatingrate.functions.SpreadAmount import SpreadAmount
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.asset.floatingrate.functions.MultiplierAmount import MultiplierAmount

__all__ = ['GetFloatingRateProcessingParameters']


@replaceable
def GetFloatingRateProcessingParameters(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase) -> FloatingRateProcessingParameters:
    """
    Determine the processing parameters to use from the InterestRatePayout by looking them up if necessary from the corresponding schedules in the interest rate stream.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    An interest rate stream.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for which the calculation is being perfmored (needed to look up paramters).
    
    Returns
    -------
    processingParameters : FloatingRateProcessingParameters
    
    """
    self = inspect.currentframe()
    
    
    spreadRate = SpreadAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    multiplier = MultiplierAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    cap = CapRateAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    floor = FloorRateAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    rounding = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification"), "finalRateRounding")
    negativeTreatment = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification"), "negativeInterestRateTreatment")
    treatment = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification"), "rateTreatment")
    processingParameters = _get_rosetta_object('FloatingRateProcessingParameters', 'initialRate', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification"), "initialRate"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'spread', rosetta_resolve_attr(self, "spreadRate"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'multiplier', rosetta_resolve_attr(self, "multiplier"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'treatment', rosetta_resolve_attr(self, "treatment"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'capRate', rosetta_resolve_attr(self, "cap"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'floorRate', rosetta_resolve_attr(self, "floor"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'rounding', rosetta_resolve_attr(self, "rounding"))
    processingParameters = set_rosetta_attr(rosetta_resolve_attr(self, 'processingParameters'), 'negativeTreatment', rosetta_resolve_attr(self, "negativeTreatment"))
    
    
    return processingParameters

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
