# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['Min']


@replaceable
def Min(a: Decimal, b: Decimal) -> Decimal:
    """
    Returns the lesser number of two supplied numbers.
    
    Parameters 
    ----------
    a : number
    
    b : number
    
    Returns
    -------
    result : number
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "b")
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "a")
    
    result =  if_cond_fn(all_elements(rosetta_resolve_attr(self, "a"), ">", rosetta_resolve_attr(self, "b")), _then_fn0, _else_fn0)
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
