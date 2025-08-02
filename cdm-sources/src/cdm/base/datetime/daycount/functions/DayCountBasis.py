# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['DayCountBasis']


@replaceable
def DayCountBasis() -> None:
    """
    
    Parameters 
    ----------
    
    Returns
    -------
    No Return
    
    """
    self = inspect.currentframe()
    
    

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
