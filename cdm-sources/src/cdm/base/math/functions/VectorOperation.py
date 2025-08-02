# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.ArithmeticOperationEnum import ArithmeticOperationEnum

__all__ = ['VectorOperation']


@replaceable
def VectorOperation(arithmeticOp: ArithmeticOperationEnum, left: list[Decimal] | None, right: list[Decimal] | None) -> Decimal:
    """
    Generates a result vector by applying the supplied arithmetic operation to each element of the supplied left and right vectors in turn.  i.e. result[n] = left[n] <op> right[n], where <op> is the arithmetic operation defined by ArithmeticOperationEnum.
    
    Parameters 
    ----------
    arithmeticOp : ArithmeticOperationEnum
    Vector operator.
    
    left : number
    Left vector.
    
    right : number
    Right vector.
    
    Returns
    -------
    result : number
    
    """
    self = inspect.currentframe()
    
    
    result = rosetta_resolve_attr(self, "result")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
