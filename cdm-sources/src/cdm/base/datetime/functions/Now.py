# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian

__all__ = ['Now']


@replaceable
def Now() -> datetime.datetime:
    """
    Current date time.
    
    Parameters 
    ----------
    
    Returns
    -------
    now : zonedDateTime
    
    """
    self = inspect.currentframe()
    
    
    now = rosetta_resolve_attr(self, "now")
    
    
    return now

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
