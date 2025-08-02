# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.functions.ApplyFloatingRatePostSpreadProcessing import ApplyFloatingRatePostSpreadProcessing
from cdm.product.asset.floatingrate.FloatingRateProcessingParameters import FloatingRateProcessingParameters
from cdm.product.common.schedule.CalculationPeriodBase import CalculationPeriodBase
from cdm.product.asset.floatingrate.functions.ApplyUSRateTreatment import ApplyUSRateTreatment
from cdm.product.asset.NegativeInterestRateTreatmentEnum import NegativeInterestRateTreatmentEnum
from cdm.product.asset.floatingrate.FloatingRateProcessingDetails import FloatingRateProcessingDetails

__all__ = ['ApplyFloatingRateProcessing']


@replaceable
def ApplyFloatingRateProcessing(processing: FloatingRateProcessingParameters, rawRate: Decimal, calculationPeriod: CalculationPeriodBase, isInitialPeriod: bool) -> FloatingRateProcessingDetails:
    """
    Perform rate treatments on floating rates, such as applying spreads, multipliers, caps and floors, rounding, and negative interest treatment. TODO: initialRate needs to be supported.  Also, to support compounding methods, it may be necessary to split the before spread and after spread values and return both, so that cashflows can be computed both ways. This may require this function to be redesigned or split into pieces (e.g. factor out the post-spread processing).  Rate treatments are described in Section 6 of the 2021 ISDA Definitions.  Negative treatment does not correctly support the case where compounded periods are applicable and will need to be enhanced for that case when compounding calculations are developed.
    
    Parameters 
    ----------
    processing : FloatingRateProcessingParameters
    THe parameters to be used for processing, such as multipliers, spreads, cap rates, etc.
    
    rawRate : number
    The floating rate prior to treatment, either a single term rate, or a calculated rate such as an OIS or lookback compounded rate.
    
    calculationPeriod : CalculationPeriodBase
    The calculation period for with the processing need to be performed.
    
    isInitialPeriod : boolean
    Is this the initial calculation period of the payout?
    
    Returns
    -------
    details : FloatingRateProcessingDetails
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "multiplied")
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "rawRate")
    
    def _then_fn1():
        return Max(0.0, rosetta_resolve_attr(self, "treatedRate"))
    
    def _else_fn1():
        return rosetta_resolve_attr(self, "treatedRate")
    
    def _then_fn2():
        return rosetta_resolve_attr(self, "added")
    
    def _else_fn2():
        return rosetta_resolve_attr(self, "negativeTreatedRate")
    
    def _then_fn3():
        return Max(0.0, rosetta_resolve_attr(self, "ratePlusSpread"))
    
    def _else_fn3():
        return rosetta_resolve_attr(self, "ratePlusSpread")
    
    def _then_fn4():
        return True
    
    def _else_fn4():
        return False
    
    def _then_fn5():
        return rosetta_resolve_attr(self, "initialRatePluSpread")
    
    def _else_fn5():
        return rosetta_resolve_attr(self, "initialRate")
    
    def _then_fn6():
        return rosetta_resolve_attr(self, "initialRatePluSpread")
    
    def _else_fn6():
        return ApplyFloatingRatePostSpreadProcessing(rosetta_resolve_attr(self, "ratePlusSpread"), rosetta_resolve_attr(self, "processing"))
    
    def _then_fn7():
        return rosetta_resolve_attr(self, "initialRate")
    
    def _else_fn7():
        return ApplyFloatingRatePostSpreadProcessing(rosetta_resolve_attr(self, "negativeTreatedRate"), rosetta_resolve_attr(self, "processing"))
    
    multiplier = rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "multiplier")
    multiplied = (rosetta_resolve_attr(self, "rawRate") * rosetta_resolve_attr(self, "multiplier"))
    multipliedRate = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "multiplier")), _then_fn0, _else_fn0)
    treatedRate = (ApplyUSRateTreatment(rosetta_resolve_attr(self, "multipliedRate"), rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "treatment"), rosetta_resolve_attr(self, "calculationPeriod")) * 1.0)
    negativeTreatment = rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "negativeTreatment")
    negativeTreatedRate = if_cond_fn(all_elements(rosetta_resolve_attr(self, "negativeTreatment"), "=", rosetta_resolve_attr(NegativeInterestRateTreatmentEnum, "ZERO_INTEREST_RATE_EXCLUDING_SPREAD_METHOD")), _then_fn1, _else_fn1)
    spreadRate = rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "spread")
    added = (rosetta_resolve_attr(self, "negativeTreatedRate") + rosetta_resolve_attr(self, "spreadRate"))
    ratePlusSpread = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "spreadRate")), _then_fn2, _else_fn2)
    negativeTreatedRatePlusSpread = if_cond_fn(all_elements(rosetta_resolve_attr(self, "negativeTreatment"), "=", rosetta_resolve_attr(NegativeInterestRateTreatmentEnum, "ZERO_INTEREST_RATE_METHOD")), _then_fn3, _else_fn3)
    doInitialRate = if_cond_fn((all_elements(rosetta_resolve_attr(self, "isInitialPeriod"), "=", True) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "initialRate"))), _then_fn4, _else_fn4)
    initialRate = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "initialRate"), "value")
    initialRatePluSpread = (rosetta_resolve_attr(self, "initialRate") + rosetta_resolve_attr(self, "spreadRate"))
    initialRatePlusSpread = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "spreadRate")), _then_fn5, _else_fn5)
    details = _get_rosetta_object('FloatingRateProcessingDetails', 'processingParameters', rosetta_resolve_attr(self, "processing"))
    details = set_rosetta_attr(rosetta_resolve_attr(self, 'details'), 'rawRate', rosetta_resolve_attr(self, "rawRate"))
    details = set_rosetta_attr(rosetta_resolve_attr(self, 'details'), 'processedRate', if_cond_fn(all_elements(rosetta_resolve_attr(self, "doInitialRate"), "=", True), _then_fn2, _else_fn2))
    details = set_rosetta_attr(rosetta_resolve_attr(self, 'details'), 'spreadExclusiveRate', if_cond_fn(all_elements(rosetta_resolve_attr(self, "doInitialRate"), "=", True), _then_fn3, _else_fn3))
    
    
    return details

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
