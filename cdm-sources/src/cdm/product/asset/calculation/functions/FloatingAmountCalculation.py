# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.functions.DetermineFloatingRateReset import DetermineFloatingRateReset
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.asset.floatingrate.FloatingAmountCalculationDetails import FloatingAmountCalculationDetails
from cdm.product.asset.calculation.functions.ApplyFloatingRateSetting import ApplyFloatingRateSetting

__all__ = ['FloatingAmountCalculation']


@replaceable
def FloatingAmountCalculation(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase, isInitialPeriod: bool, suppliedNotional: Decimal | None, suppliedRate: Decimal | None) -> FloatingAmountCalculationDetails:
    """
    Calculate a floating amount for a calculation period by determining the raw floating rate, applying any rate treatments, looking up the calculation period notional, then performing the multiplication of the notional, rate, and year fraction.  Floating amount calculations are described in the 2021 ISDA Definitions in Section 6 and 7.
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    The interest rate stream for which the floating amount calculation is being done.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for which the floating rate calculation is being done.
    
    isInitialPeriod : boolean
    Is this the initial calculation period?.
    
    suppliedNotional : number
    
    suppliedRate : number
    
    Returns
    -------
    result : FloatingAmountCalculationDetails
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return DetermineFloatingRateReset(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    
    def _else_fn0():
        return True
    
    floatingRateSetting = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "suppliedRate"))), _then_fn0, _else_fn0)
    result =  ApplyFloatingRateSetting(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"), rosetta_resolve_attr(self, "isInitialPeriod"), rosetta_resolve_attr(self, "suppliedNotional"), rosetta_resolve_attr(self, "suppliedRate"), rosetta_resolve_attr(self, "floatingRateSetting"))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
