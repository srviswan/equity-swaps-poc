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
from cdm.product.asset.floatingrate.FloatingRateProcessingDetails import FloatingRateProcessingDetails
from cdm.product.asset.InterestRatePayout import InterestRatePayout
from cdm.product.asset.floatingrate.FloatingAmountCalculationDetails import FloatingAmountCalculationDetails
from cdm.product.asset.floatingrate.FloatingRateSettingDetails import FloatingRateSettingDetails

__all__ = ['CalculateFloatingCashFlow']


@replaceable
def CalculateFloatingCashFlow(interestRatePayout: InterestRatePayout, calculationPeriod: CalculationPeriodBase, notional: Decimal | None, currency: str | None, floatingRateSetting: FloatingRateSettingDetails | None, processedRateDetails: FloatingRateProcessingDetails) -> FloatingAmountCalculationDetails:
    """
    
    Parameters 
    ----------
    interestRatePayout : InterestRatePayout
    The interest rate stream for which the floating amount calculation is being done.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for which the floating rate calculation is being done.
    
    notional : number
    
    currency : string
    
    floatingRateSetting : FloatingRateSettingDetails
    Details of the rate observation/calculation corresponding to the supplied rate definition and calculation period.
    
    processedRateDetails : FloatingRateProcessingDetails
    Results are details of the rate treatment.
    
    Returns
    -------
    result : FloatingAmountCalculationDetails
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "floatingRateSetting")
    
    def _else_fn0():
        return True
    
    appliedRate = rosetta_resolve_attr(rosetta_resolve_attr(self, "processedRateDetails"), "processedRate")
    spreadExclusiveRate = rosetta_resolve_attr(rosetta_resolve_attr(self, "processedRateDetails"), "spreadExclusiveRate")
    dcf = rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "dayCountFraction")
    yearFraction = CalculateYearFraction(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(self, "dcf"), rosetta_resolve_attr(self, "calculationPeriod"))
    annualAccrual = (rosetta_resolve_attr(self, "notional") * rosetta_resolve_attr(self, "appliedRate"))
    notionalAccrual = (rosetta_resolve_attr(self, "notional") * rosetta_resolve_attr(self, "yearFraction"))
    cashflow = (rosetta_resolve_attr(self, "notionalAccrual") * rosetta_resolve_attr(self, "appliedRate"))
    spreadExclusiveCashflow = (rosetta_resolve_attr(self, "notionalAccrual") * rosetta_resolve_attr(self, "spreadExclusiveRate"))
    result = _get_rosetta_object('FloatingAmountCalculationDetails', 'calculationPeriod', rosetta_resolve_attr(self, "calculationPeriod"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'calculationPeriodNotionalAmount->value', rosetta_resolve_attr(self, "notional"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'calculationPeriodNotionalAmount->unit->currency', rosetta_resolve_attr(self, "currency"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'floatingRate', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "floatingRateSetting")), _then_fn0, _else_fn0))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'processingDetails', rosetta_resolve_attr(self, "processedRateDetails"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'appliedRate', rosetta_resolve_attr(self, "appliedRate"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'yearFraction', rosetta_resolve_attr(self, "yearFraction"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'calculatedAmount', rosetta_resolve_attr(self, "cashflow"))
    result = set_rosetta_attr(rosetta_resolve_attr(self, 'result'), 'spreadExclusiveCalculatedAMount', rosetta_resolve_attr(self, "spreadExclusiveCashflow"))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
