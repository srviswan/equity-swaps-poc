# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['ToTime']


@replaceable
def ToTime(hours: int, minutes: int, seconds: int) -> datetime.time:
    """
    Implemented by Java function.
    
    Parameters 
    ----------
    hours : int
    
    minutes : int
    
    seconds : int
    
    Returns
    -------
    time : time
    
    """
    self = inspect.currentframe()
    
    
    time = rosetta_resolve_attr(self, "time")
    
    
    return time

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
