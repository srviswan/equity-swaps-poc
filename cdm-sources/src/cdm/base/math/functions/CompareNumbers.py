# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.CompareOp import CompareOp

__all__ = ['CompareNumbers']


@replaceable
def CompareNumbers(n1: Decimal, op: CompareOp, n2: Decimal) -> bool:
    """
    
    Parameters 
    ----------
    n1 : number
    
    op : CompareOp
    
    n2 : number
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn4():
        return all_elements(all_elements(rosetta_resolve_attr(self, "n1"), "<", rosetta_resolve_attr(self, "n2")), "=", True)
    
    def _else_fn4():
        return False
    
    def _then_fn3():
        return all_elements(all_elements(rosetta_resolve_attr(self, "n1"), "<=", rosetta_resolve_attr(self, "n2")), "=", True)
    
    def _else_fn3():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(CompareOp, "LESS_THAN")), _then_fn4, _else_fn4)
    
    def _then_fn2():
        return all_elements(all_elements(rosetta_resolve_attr(self, "n1"), "=", rosetta_resolve_attr(self, "n2")), "=", True)
    
    def _else_fn2():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(CompareOp, "LESS_THAN_OR_EQUALS")), _then_fn3, _else_fn3)
    
    def _then_fn1():
        return all_elements(all_elements(rosetta_resolve_attr(self, "n1"), ">=", rosetta_resolve_attr(self, "n2")), "=", True)
    
    def _else_fn1():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(CompareOp, "EQUALS")), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return all_elements(all_elements(rosetta_resolve_attr(self, "n1"), ">", rosetta_resolve_attr(self, "n2")), "=", True)
    
    def _else_fn0():
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(CompareOp, "GREATER_THAN_OR_EQUALS")), _then_fn1, _else_fn1)
    
    result =  if_cond_fn(all_elements(rosetta_resolve_attr(self, "op"), "=", rosetta_resolve_attr(CompareOp, "GREATER_THAN")), _then_fn0, _else_fn0)
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
