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
from cdm.product.asset.calculation.functions.CalculateYearFraction import CalculateYearFraction
from cdm.product.asset.FixedAmountCalculationDetails import FixedAmountCalculationDetails
from cdm.product.asset.calculation.functions.GetFixedRate import GetFixedRate
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.asset.calculation.functions.GetNotionalAmount import GetNotionalAmount

__all__ = ['FixedAmountCalculation']


@replaceable
def FixedAmountCalculation(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase, notional: Decimal | None) -> FixedAmountCalculationDetails:
    """
    Calculates the fixed amount for a calculation period by looking up the notional and the fixed rate and multiplying by the year fraction.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    
    calculationPeriod : CalculationPeriodBase
    
    notional : number
    
    Returns
    -------
    fixedAmountDetails : FixedAmountCalculationDetails
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "notional")
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationAmount"), "value")
    
    fixedRate = GetFixedRate(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    calculationAmount = GetNotionalAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    dcf = rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "dayCountFraction")
    yearFraction = CalculateYearFraction(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "dcf"), rosetta_resolve_attr(self, "calculationPeriod"))
    calcAmt = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "notional")), _then_fn0, _else_fn0)
    fixedAmountDetails = _get_rosetta_object('FixedAmountCalculationDetails', 'calculationPeriod', rosetta_resolve_attr(self, "calculationPeriod"))
    fixedAmountDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'fixedAmountDetails'), 'calculationPeriodNotionalAmount->value', rosetta_resolve_attr(self, "calcAmt"))
    fixedAmountDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'fixedAmountDetails'), 'calculationPeriodNotionalAmount->unit->currency', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "calculationAmount"), "unit"), "currency"))
    fixedAmountDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'fixedAmountDetails'), 'fixedRate', rosetta_resolve_attr(self, "fixedRate"))
    fixedAmountDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'fixedAmountDetails'), 'yearFraction', rosetta_resolve_attr(self, "yearFraction"))
    fixedAmountDetails = set_rosetta_attr(rosetta_resolve_attr(self, 'fixedAmountDetails'), 'calculatedAmount', ((rosetta_resolve_attr(self, "calcAmt") * rosetta_resolve_attr(rosetta_resolve_attr(self, "fixedAmountDetails"), "fixedRate")) * rosetta_resolve_attr(rosetta_resolve_attr(self, "fixedAmountDetails"), "yearFraction")))
    
    
    return fixedAmountDetails

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
