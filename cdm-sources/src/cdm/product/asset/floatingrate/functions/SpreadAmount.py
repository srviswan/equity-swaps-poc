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
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['SpreadAmount']


@replaceable
def SpreadAmount(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase) -> Decimal:
    """
    Look up the spread amount for a calculation period.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    An interest rate stream.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for which you want the spread.
    
    Returns
    -------
    spread : number
    
    """
    self = inspect.currentframe()
    
    
    spread =  GetRateScheduleAmount(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification"), "spreadSchedule"), rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedStartDate"))
    
    
    return spread

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
