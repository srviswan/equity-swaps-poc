# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.RoundingModeEnum import RoundingModeEnum

__all__ = ['RoundToNearest']


@replaceable
def RoundToNearest(value: Decimal, nearest: Decimal, roundingMode: RoundingModeEnum) -> Decimal:
    """
    Round a number to the supplied nearest, using the supplied rounding mode.
    
    Parameters 
    ----------
    value : number
    The original (unrounded) number.
    
    nearest : number
    The nearest number to round to.
    
    roundingMode : RoundingModeEnum
    The method of rounding (up to nearest/down to nearest).
    
    Returns
    -------
    roundedValue : number
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_PositiveNearest(self):
        return all_elements(rosetta_resolve_attr(self, "nearest"), ">", 0)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    roundedValue = rosetta_resolve_attr(self, "roundedValue")
    
    
    return roundedValue

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
