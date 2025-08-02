# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['AppendToVector']


@replaceable
def AppendToVector(vector: list[Decimal] | None, value: Decimal) -> Decimal:
    """
    Append a single value to a vector (list of numbers).
    
    Parameters 
    ----------
    vector : number
    Input vector.
    
    value : number
    Value to add to the vector.
    
    Returns
    -------
    resultVector : number
    
    """
    self = inspect.currentframe()
    
    
    resultVector = rosetta_resolve_attr(self, "vector")
    resultVector.add_rosetta_attr(self, rosetta_resolve_attr(self, "value"))
    
    
    return resultVector

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
