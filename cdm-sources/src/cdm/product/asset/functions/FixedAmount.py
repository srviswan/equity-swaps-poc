# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.calculation.functions.FixedAmountCalculation import FixedAmountCalculation
from cdm.product.common.schedule.CalculationPeriodData import CalculationPeriodData
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['FixedAmount']


@replaceable
def FixedAmount(interestRatePayout: InterestRatePayout, notional: Decimal | None, date: datetime.date | None, calculationPeriodData: CalculationPeriodData | None) -> Decimal:
    """
    2006 ISDA Definition Article 5 Section 5.1. Calculation of a Fixed Amount: The Fixed Amount payable by a party on a Payment Date will be: (a) if an amount is specified for the Swap Transaction as the Fixed Amount payable by that party for that Payment Date or for the related Calculation Period, that amount; or (b) if an amount is not specified for the Swap Transaction as the Fixed Amount payable by that party for that Payment Date or for the related Calculation Period, an amount calculated on a formula basis for that Payment Date or for the related Calculation Period as follows: Fixed Amount = Calculation Amount × Fixed Rate × Day Count Fraction.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    description of the interest rate payout
    
    notional : number
    The notional quantity to use
    
    date : date
    The date to use to obtain the calculation period
    
    calculationPeriodData : CalculationPeriodData
    full details of the calculation period
    
    Returns
    -------
    fixedAmount : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "calculationPeriodData")
    
    def _else_fn0():
        return CalculationPeriod(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "calculationPeriodDates"), rosetta_resolve_attr(self, "date"))
    
    calculationPeriod = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "calculationPeriodData")), _then_fn0, _else_fn0)
    calcPeriodBase = Create_CalculationPeriodBase(rosetta_resolve_attr(self, "calculationPeriod"))
    fixedAmountCalc = FixedAmountCalculation(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calcPeriodBase"), rosetta_resolve_attr(self, "notional"))
    fixedAmount =  rosetta_resolve_attr(rosetta_resolve_attr(self, "fixedAmountCalc"), "calculatedAmount")
    
    
    return fixedAmount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
