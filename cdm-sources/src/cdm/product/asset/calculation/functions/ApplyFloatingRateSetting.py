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
from cdm.product.asset.calculation.functions.DefaultFloatingRate import DefaultFloatingRate
from cdm.product.asset.floatingrate.functions.GetFloatingRateProcessingParameters import GetFloatingRateProcessingParameters
from cdm.product.asset.floatingrate.functions.ApplyFloatingRateProcessing import ApplyFloatingRateProcessing
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.asset.floatingrate.FloatingAmountCalculationDetails import FloatingAmountCalculationDetails
from cdm.product.asset.floatingrate.FloatingRateSettingDetails import FloatingRateSettingDetails
from cdm.product.asset.calculation.functions.CalculateFloatingCashFlow import CalculateFloatingCashFlow

__all__ = ['ApplyFloatingRateSetting']


@replaceable
def ApplyFloatingRateSetting(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase, isInitialPeriod: bool, suppliedNotional: Decimal | None, suppliedRate: Decimal | None, floatingRateSetting: FloatingRateSettingDetails | None) -> FloatingAmountCalculationDetails:
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
    
    floatingRateSetting : FloatingRateSettingDetails
    Details of the rate observation/calculation corresonding to the supplied rate definition and calculation period.
    
    Returns
    -------
    result : FloatingAmountCalculationDetails
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return DefaultFloatingRate(rosetta_resolve_attr(self, "suppliedRate"))
    
    def _else_fn0():
        return ApplyFloatingRateProcessing(rosetta_resolve_attr(self, "processingParameters"), rosetta_resolve_attr(self, "floatingRate"), rosetta_resolve_attr(self, "calculationPeriod"), rosetta_resolve_attr(self, "isInitialPeriod"))
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "suppliedNotional")
    
    def _else_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "periodNotional"), "value")
    
    floatingRate = rosetta_resolve_attr(rosetta_resolve_attr(self, "floatingRateSetting"), "floatingRate")
    processingParameters = GetFloatingRateProcessingParameters(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    processedRateDetails = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "suppliedRate")), _then_fn0, _else_fn0)
    periodNotional = GetNotionalAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"))
    notional = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "suppliedNotional")), _then_fn1, _else_fn1)
    currency = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "periodNotional"), "unit"), "currency")
    result =  CalculateFloatingCashFlow(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "calculationPeriod"), rosetta_resolve_attr(self, "notional"), rosetta_resolve_attr(self, "currency"), rosetta_resolve_attr(self, "floatingRateSetting"), rosetta_resolve_attr(self, "processedRateDetails"))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
