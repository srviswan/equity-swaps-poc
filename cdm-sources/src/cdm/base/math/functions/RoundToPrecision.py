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

__all__ = ['RoundToPrecision']


@replaceable
def RoundToPrecision(value: Decimal, precision: int, roundingMode: RoundingDirectionEnum, removeTrailingZeros: bool) -> Decimal:
    """
    Round a number to the supplied precision, using the supplied rounding direction.
    
    Parameters 
    ----------
    value : number
    The original (unrounded) number.
    
    precision : int
    The number of decimal digits of precision.
    
    roundingMode : RoundingDirectionEnum
    The method of rounding (up/down/nearest).
    
    removeTrailingZeros : boolean
    Flag to specify whether to strip trailing zeros.
    
    Returns
    -------
    roundedValue : number
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_NonNegativePrecision(self):
        """
        The number of decimal digits of precision should be greater than or equal to zero.
        """
        return all_elements(rosetta_resolve_attr(self, "precision"), ">=", 0)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    roundedValue = rosetta_resolve_attr(self, "roundedValue")
    
    
    return roundedValue

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
