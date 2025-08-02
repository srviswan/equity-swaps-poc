# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['VectorGrowthOperation']


@replaceable
def VectorGrowthOperation(baseValue: Decimal, factor: list[Decimal] | None) -> Decimal:
    """
    Generates a result vector by starting with the supplied base value (typically 1), and then multiplying it in turn by each growth factor, which is typically a number just above 1. For instance, a growth factor of 1.1 reprsents a 10% increase, and 0.9 a 10% decrease. The results will show the successive results of applying the successive growth factors, with the first value of the list being the supplied baseValue, and final value of the results list being the product of all of the supplied values.  i.e. result[1] = baseValue * factor[1], result[n] = result[n-1] * factor[n]. The resulting list will have the one more element than the supplied list of factors.
    
    Parameters 
    ----------
    baseValue : number
    Original value, typically 1.0.
    
    factor : number
    Vector of growth factors, which are all typically slightly greater than 1.0.
    
    Returns
    -------
    result : number
    
    """
    self = inspect.currentframe()
    
    
    result = rosetta_resolve_attr(self, "result")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
