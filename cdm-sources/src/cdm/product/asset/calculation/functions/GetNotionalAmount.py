# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.Money import Money
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.asset.calculation.functions.GetQuantityScheduleStepValues import GetQuantityScheduleStepValues
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['GetNotionalAmount']


@replaceable
def GetNotionalAmount(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase) -> Money:
    """
    Look up the notional amount in effect for a calculation period.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    An interest rate stream.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for which you want the notional.
    
    Returns
    -------
    notional : Money
    
    """
    self = inspect.currentframe()
    
    
    notional = _get_rosetta_object('Money', 'value', GetQuantityScheduleStepValues(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "priceQuantity"), "quantitySchedule"), rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationPeriod"), "adjustedStartDate"))[-1])
    notional = set_rosetta_attr(rosetta_resolve_attr(self, 'notional'), 'unit->currency', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "priceQuantity"), "quantitySchedule"), "unit"), "currency"))
    
    
    return notional

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
