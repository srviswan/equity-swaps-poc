# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.datetime.TimeZone import TimeZone
from cdm.base.datetime.BusinessCenterTime import BusinessCenterTime

__all__ = ['TimeZoneFromBusinessCenterTime']


@replaceable
def TimeZoneFromBusinessCenterTime(time: BusinessCenterTime) -> TimeZone:
    """
    Function to resolve a time passed as BusinessCenterTime into a TimeZone time.
    
    Parameters 
    ----------
    time : BusinessCenterTime
    
    Returns
    -------
    result : TimeZone
    
    """
    self = inspect.currentframe()
    
    
    result = rosetta_resolve_attr(self, "result")
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
