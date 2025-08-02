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
from cdm.base.math.functions.Max import Max
from cdm.base.math.functions.Min import Min

__all__ = ['ArithmeticOperation']


@replaceable
def ArithmeticOperation(n1: Decimal, op: ArithmeticOperationEnum, n2: Decimal) -> Decimal:
    """
    
    Parameters 
    ----------
    n1 : number
    
    op : ArithmeticOperationEnum
    
    n2 : number
    
    Returns
    -------
    result : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn5():
        return Min(rosetta_resolve_attr(self, "n1"), rosetta_resolve_attr(self, "n2"))
    
    def _else_fn5():
        return True
    
    def _then_fn4():
        return Max(rosetta_resolve_attr(self, "n1"), rosetta_resolve_attr(self, "n2"))
    
    def _else_fn4():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "MIN")), _then_fn5, _else_fn5)
    
    def _then_fn3():
        return (rosetta_resolve_attr(self, "n1") / rosetta_resolve_attr(self, "n2"))
    
    def _else_fn3():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "MAX")), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return (rosetta_resolve_attr(self, "n1") * rosetta_resolve_attr(self, "n2"))
    
    def _else_fn2():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "DIVIDE")), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return (rosetta_resolve_attr(self, "n1") - rosetta_resolve_attr(self, "n2"))
    
    def _else_fn1():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "MULTIPLY")), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return (rosetta_resolve_attr(self, "n1") + rosetta_resolve_attr(self, "n2"))
    
    def _else_fn0():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "SUBTRACT")), _then_fn1, _else_fn1)
    
    result =  if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "ADD")), _then_fn0, _else_fn0)
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
