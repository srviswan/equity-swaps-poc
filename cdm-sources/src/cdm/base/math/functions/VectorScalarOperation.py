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
from cdm.base.math.functions.ArithmeticOperation import ArithmeticOperation

__all__ = ['VectorScalarOperation']


@replaceable
def VectorScalarOperation(arithmeticOp: ArithmeticOperationEnum, left: list[Decimal] | None, right: Decimal | None) -> Decimal:
    """
    Generates a result vector by applying the supplied arithmetic operation and scalar right value to each element of the supplied left vector in turn. i.e. result[n] = left[n] <op> right, where <op> is the arithmetic operation defined by ArithmeticOperationEnum.
    
    Parameters 
    ----------
    arithmeticOp : ArithmeticOperationEnum
    Arithmetic operator to be applied.
    
    left : number
    Left vector.
    
    right : number
    Scalar number - a single value to be applied to all elements of vector.
    
    Returns
    -------
    result : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "right")
    
    def _else_fn0():
        return 0.0
    
    rightOrDefault = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "right")), _then_fn0, _else_fn0)
    result = map(lambda item: ArithmeticOperation(item, rosetta_resolve_attr(self, "arithmeticOp"), rosetta_resolve_attr(self, "rightOrDefault")), rosetta_resolve_attr(self, "left"))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
