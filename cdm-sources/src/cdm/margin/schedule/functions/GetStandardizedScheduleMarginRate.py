# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.margin.schedule.StandardizedScheduleAssetClassEnum import StandardizedScheduleAssetClassEnum

__all__ = ['GetStandardizedScheduleMarginRate']


@replaceable
def GetStandardizedScheduleMarginRate(assetClass: StandardizedScheduleAssetClassEnum, durationInYears: Decimal) -> Decimal:
    """
    Computes the margin rate, which is required in the calculation of the gross initial margin. It depends exclusively on the asset class of the trade and, in some cases, on the duration as well.
    
    Parameters 
    ----------
    assetClass : StandardizedScheduleAssetClassEnum
    
    durationInYears : number
    
    Returns
    -------
    percentage : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn3():
        return 4.0
    
    def _else_fn3():
        return True
    
    def _then_fn2():
        return 2.0
    
    def _else_fn2():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "durationInYears"), ">", 5), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return 1.0
    
    def _else_fn1():
        return if_cond_fn((all_elements(rosetta_resolve_attr(self, "durationInYears"), ">", 2) and all_elements(rosetta_resolve_attr(self, "durationInYears"), "<=", 5)), _then_fn2, _else_fn2)
    
    def _then_fn4():
        return 10.0
    
    def _else_fn4():
        return True
    
    def _then_fn3():
        return 5.0
    
    def _else_fn3():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "durationInYears"), ">", 5), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return 2.0
    
    def _else_fn2():
        return if_cond_fn((all_elements(rosetta_resolve_attr(self, "durationInYears"), ">", 2) and all_elements(rosetta_resolve_attr(self, "durationInYears"), "<=", 5)), _then_fn3, _else_fn3)
    
    def _then_fn4():
        return 15.0
    
    def _else_fn4():
        return True
    
    def _then_fn3():
        return 15.0
    
    def _else_fn3():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "COMMODITY")), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return 6.0
    
    def _else_fn2():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "EQUITY")), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "durationInYears"), "<=", 2), _then_fn2, _else_fn2)
    
    def _else_fn1():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "FOREIGN_EXCHANGE")), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "durationInYears"), "<=", 2), _then_fn1, _else_fn1)
    
    def _else_fn0():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "CREDIT")), _then_fn1, _else_fn1)
    
    percentage =  if_cond_fn(all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(StandardizedScheduleAssetClassEnum, "INTEREST_RATES")), _then_fn0, _else_fn0)
    
    
    return percentage

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
