# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.functions.ProcessFloatingRateReset import ProcessFloatingRateReset
from cdm.product.asset.floatingrate.functions.GetFloatingRateProcessingType import GetFloatingRateProcessingType
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.asset.floatingrate.FloatingRateSettingDetails import FloatingRateSettingDetails

__all__ = ['DetermineFloatingRateReset']


@replaceable
def DetermineFloatingRateReset(interestRatePayout: InterestRatePayout, calcPeriod: CalculationPeriodBase) -> FloatingRateSettingDetails:
    """
    Get the value of a floating rate by either observing it directly or performing a rate calculation.  This function works differently depending on the rate category and style, as described in the 2021 ISDA Definitions, Section 6.6.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    Floating rate stream definition.
    
    calcPeriod : CalculationPeriodBase
    The calculation period for which you want the rate.
    
    Returns
    -------
    floatingRate : FloatingRateSettingDetails
    
    """
    self = inspect.currentframe()
    
    
    rateDef = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification")
    processingType = GetFloatingRateProcessingType(rosetta_resolve_attr(self, "rateDef"))
    floatingRate =  ProcessFloatingRateReset(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calcPeriod"), rosetta_resolve_attr(self, "processingType"))
    
    
    return floatingRate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
