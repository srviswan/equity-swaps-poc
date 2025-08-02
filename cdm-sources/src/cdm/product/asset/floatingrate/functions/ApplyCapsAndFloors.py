# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.floatingrate.FloatingRateProcessingParameters import FloatingRateProcessingParameters

__all__ = ['ApplyCapsAndFloors']


@replaceable
def ApplyCapsAndFloors(processing: FloatingRateProcessingParameters, inputRate: Decimal) -> Decimal:
    """
    Apply any cap or floor rate as a constraint on a regular swap rate, as discussed in the 2021 ISDA Definitions, section 6.5.8 and 6.5.9.
    
    Parameters 
    ----------
    processing : FloatingRateProcessingParameters
    
    inputRate : number
    The floating rate prior to treatment, either a single term rate, or a calculated rate such as an OIS or lookback compounded rate.
    
    Returns
    -------
    cappedAndFlooredRate : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "cap")
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "inputRate")
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "floor")
    
    def _else_fn1():
        return rosetta_resolve_attr(self, "cappedRate")
    
    cap = rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "capRate")
    floor = rosetta_resolve_attr(rosetta_resolve_attr(self, "processing"), "floorRate")
    cappedRate = if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "cap")) and all_elements(rosetta_resolve_attr(self, "inputRate"), ">", rosetta_resolve_attr(self, "cap"))), _then_fn0, _else_fn0)
    flooredRate = if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "floor")) and all_elements(rosetta_resolve_attr(self, "cappedRate"), "<", rosetta_resolve_attr(self, "floor"))), _then_fn1, _else_fn1)
    cappedAndFlooredRate =  rosetta_resolve_attr(self, "flooredRate")
    
    
    return cappedAndFlooredRate

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
