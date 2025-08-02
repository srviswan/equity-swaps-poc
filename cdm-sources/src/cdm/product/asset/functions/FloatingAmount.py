# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.calculation.functions.FloatingAmountCalculation import FloatingAmountCalculation
from cdm.product.common.schedule.CalculationPeriodData import CalculationPeriodData
from cdm.product.asset.InterestRatePayout import InterestRatePayout

__all__ = ['FloatingAmount']


@replaceable
def FloatingAmount(interestRatePayout: InterestRatePayout, rate: Decimal | None, notional: Decimal | None, date: datetime.date | None, calculationPeriodData: CalculationPeriodData | None) -> Decimal:
    """
    2006 ISDA Definition Article 6 Section 6.1. Calculation of a Floating Amount: Subject to the provisions of Section 6.4 (Negative Interest Rates), the Floating Amount payable by a party on a Payment Date will be: (a) if Compounding is not specified for the Swap Transaction or that party, an amount calculated on a formula basis for that Payment Date or for the related Calculation Period as follows: Floating Amount = Calculation Amount × Floating Rate + Spread × Floating Rate Day Count Fraction (b) if 'Compounding' is specified to be applicable to the Swap Transaction or that party and 'Flat Compounding' is not specified, an amount equal to the sum of the Compounding Period Amounts for each of the Compounding Periods in the related Calculation Period; or (c) if 'Flat Compounding' is specified to be applicable to the Swap Transaction or that party, an amount equal to the sum of the Basic Compounding Period Amounts for each of the Compounding Periods in the related Calculation Period plus the sum of the Additional Compounding Period Amounts for each such Compounding Period.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    full description of the interest rate payout
    
    rate : number
    the floating rate to use; if omitted it is retrieved/calculated based on the interest rate payout and floating index 
    
    notional : number
    the notional; if omitted it is obtained from the payout
    
    date : date
    The date to use to obtain the calculation period
    
    calculationPeriodData : CalculationPeriodData
    full details of the calculation period
    
    Returns
    -------
    floatingAmount : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "calculationPeriodData")
    
    def _else_fn0():
        return CalculationPeriod(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "calculationPeriodDates"), rosetta_resolve_attr(self, "date"))
    
    calculationPeriod = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "calculationPeriodData")), _then_fn0, _else_fn0)
    calcPeriodBase = Create_CalculationPeriodBase(rosetta_resolve_attr(self, "calculationPeriod"))
    floatingCalc = FloatingAmountCalculation(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calcPeriodBase"), False, rosetta_resolve_attr(self, "notional"), rosetta_resolve_attr(self, "rate"))
    floatingAmount =  rosetta_resolve_attr(rosetta_resolve_attr(self, "floatingCalc"), "calculatedAmount")
    
    
    return floatingAmount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
