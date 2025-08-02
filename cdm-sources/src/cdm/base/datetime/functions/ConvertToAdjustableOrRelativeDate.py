# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate import AdjustableOrAdjustedOrRelativeDate
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['ConvertToAdjustableOrRelativeDate']


@replaceable
def ConvertToAdjustableOrRelativeDate(adjustableOrAdjustedOrRelativeDate: AdjustableOrAdjustedOrRelativeDate | None) -> AdjustableOrRelativeDate:
    """
    Utility function to convert from AdjustableOrAdjustedOrRelativeDate to AdjustableOrRelativeDate
    
    Parameters 
    ----------
    adjustableOrAdjustedOrRelativeDate : AdjustableOrAdjustedOrRelativeDate
    
    Returns
    -------
    adjustableOrRelativeDate : AdjustableOrRelativeDate
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "adjustedDate")
    
    def _else_fn0():
        return True
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "businessCenters")
    
    def _else_fn1():
        return True
    
    def _then_fn2():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "businessDayConvention")
    
    def _else_fn2():
        return True
    
    def _then_fn3():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "dateRelativeTo")
    
    def _else_fn3():
        return True
    
    def _then_fn4():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "dayType")
    
    def _else_fn4():
        return True
    
    def _then_fn5():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "period")
    
    def _else_fn5():
        return True
    
    def _then_fn6():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "relativeDate"), "periodMultiplier")
    
    def _else_fn6():
        return True
    
    relativeDate = rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableOrAdjustedOrRelativeDate"), "relativeDate")
    adjustableOrRelativeDate = _get_rosetta_object('AdjustableOrRelativeDate', 'adjustableDate', _get_rosetta_object('AdjustableDate', 'adjustedDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableOrAdjustedOrRelativeDate"), "adjustedDate")))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'adjustableDate->unadjustedDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableOrAdjustedOrRelativeDate"), "unadjustedDate"))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'adjustableDate->dateAdjustments', rosetta_resolve_attr(rosetta_resolve_attr(self, "adjustableOrAdjustedOrRelativeDate"), "dateAdjustments"))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->adjustedDate', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn0, _else_fn0))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->businessCenters', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn1, _else_fn1))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->businessDayConvention', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn2, _else_fn2))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->dateRelativeTo', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn3, _else_fn3))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->dayType', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn4, _else_fn4))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->period', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn5, _else_fn5))
    adjustableOrRelativeDate = set_rosetta_attr(rosetta_resolve_attr(self, 'adjustableOrRelativeDate'), 'relativeDate->periodMultiplier', if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate")), _then_fn6, _else_fn6))
    
    
    return adjustableOrRelativeDate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
