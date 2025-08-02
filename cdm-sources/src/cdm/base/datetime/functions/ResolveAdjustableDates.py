# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.AdjustableRelativeOrPeriodicDates import AdjustableRelativeOrPeriodicDates

__all__ = ['ResolveAdjustableDates']


@replaceable
def ResolveAdjustableDates(adjustableRelativeOrPeriodicDates: AdjustableRelativeOrPeriodicDates) -> datetime.date:
    """
    
    Parameters 
    ----------
    adjustableRelativeOrPeriodicDates : AdjustableRelativeOrPeriodicDates
    
    Returns
    -------
    adjustedDates : date
    
    """
    self = inspect.currentframe()
    
    
    adjustedDates = rosetta_resolve_attr(self, "adjustedDates")
    
    
    return adjustedDates

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
