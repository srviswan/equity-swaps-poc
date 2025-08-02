# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.functions.DetermineFixingDate import DetermineFixingDate
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.common.schedule.ResetDates import ResetDates
from cdm.product.asset.floatingrate.functions.DetermineResetDate import DetermineResetDate
from cdm.product.asset.FloatingRate import FloatingRate
from cdm.product.asset.floatingrate.FloatingRateSettingDetails import FloatingRateSettingDetails

__all__ = ['EvaluateScreenRate']


@replaceable
def EvaluateScreenRate(rateDef: FloatingRate, resetDates: ResetDates, calculationPeriod: CalculationPeriodBase) -> FloatingRateSettingDetails:
    """
    Evaluate/lookup the value of a screen rate.
    
    Parameters 
    ----------
    rateDef : FloatingRate
    Floating rate definition.
    
    resetDates : ResetDates
    Reset dates for observing the rate.
    
    calculationPeriod : CalculationPeriodBase
    Calculation period for which you want the rate.
    
    Returns
    -------
    details : FloatingRateSettingDetails
    
    """
    self = inspect.currentframe()
    
    
    resetDate = DetermineResetDate(rosetta_resolve_attr(self, "resetDates"), rosetta_resolve_attr(self, "calculationPeriod"))
    fixingDate = DetermineFixingDate(rosetta_resolve_attr(self, "resetDates"), rosetta_resolve_attr(self, "resetDate"))
    observedRate = IndexValueObservation(rosetta_resolve_attr(self, "fixingDate"), rosetta_resolve_attr(rosetta_resolve_attr(self, "rateDef"), "rateOption"))
    details = _get_rosetta_object('FloatingRateSettingDetails', 'resetDate', rosetta_resolve_attr(self, "resetDate"))
    details = set_rosetta_attr(rosetta_resolve_attr(self, 'details'), 'observationDate', rosetta_resolve_attr(self, "fixingDate"))
    details = set_rosetta_attr(rosetta_resolve_attr(self, 'details'), 'floatingRate', rosetta_resolve_attr(self, "observedRate"))
    
    
    return details

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
