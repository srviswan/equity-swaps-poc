# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.daycount.DayCountFractionEnum import DayCountFractionEnum
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.base.datetime.daycount.functions.YearFraction import YearFraction
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.common.schedule.functions.PeriodsInYear import PeriodsInYear

__all__ = ['CalculateYearFraction']


@replaceable
def CalculateYearFraction(interestRatePayout: InterestRatePayout, dcf: DayCountFractionEnum, calculationPeriod: CalculationPeriodBase) -> Decimal:
    """
    Calculate the year fraction for a single calculation period, by invoking the base year fraction logic
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    The interest rate payout for which the year fraction is needed
    
    dcf : DayCountFractionEnum
    The day count fraction convention to use
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for which the year fraction is needed
    
    Returns
    -------
    yearFrac : number
    
    """
    self = inspect.currentframe()
    
    
    start = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedStartDate")
    end = rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedEndDate")
    termination = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "calculationPeriodDates"), "terminationDate"), "adjustableDate"), "unadjustedDate")
    periodsInYear = PeriodsInYear(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "calculationPeriodDates"), "calculationPeriodFrequency"))
    yearFrac =  YearFraction(rosetta_resolve_attr(self, "dcf"), rosetta_resolve_attr(self, "start"), rosetta_resolve_attr(self, "end"), rosetta_resolve_attr(self, "termination"), rosetta_resolve_attr(self, "periodsInYear"))
    
    
    return yearFrac

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
