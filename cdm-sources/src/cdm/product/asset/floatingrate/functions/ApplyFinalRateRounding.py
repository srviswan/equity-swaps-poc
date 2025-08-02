# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.RoundingDirectionEnum import RoundingDirectionEnum
from cdm.base.math.Rounding import Rounding
from cdm.base.math.functions.RoundToPrecision import RoundToPrecision

__all__ = ['ApplyFinalRateRounding']


@replaceable
def ApplyFinalRateRounding(baseRate: Decimal, finalRateRounding: Rounding | None) -> Decimal:
    """
    Apply the final rate rounding treatment logic as described in the 2021 ISDA Definitions, section 4.8.1.
    
    Parameters 
    ----------
    baseRate : number
    Rate before rounding.
    
    finalRateRounding : Rounding
    type of rounding (precision and direction).
    
    Returns
    -------
    roundedRate : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "finalRateRounding"), "precision")
    
    def _else_fn0():
        return 7
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "finalRateRounding"), "roundingDirection")
    
    def _else_fn1():
        return rosetta_resolve_attr(RoundingDirectionEnum, "NEAREST")
    
    precision = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "finalRateRounding"), "precision")), _then_fn0, _else_fn0)
    direction = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "finalRateRounding"), "roundingDirection")), _then_fn1, _else_fn1)
    roundedRate =  RoundToPrecision(rosetta_resolve_attr(self, "baseRate"), rosetta_resolve_attr(self, "precision"), rosetta_resolve_attr(self, "direction"), False)
    
    
    return roundedRate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
