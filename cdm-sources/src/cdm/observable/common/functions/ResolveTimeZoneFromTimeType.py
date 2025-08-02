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
from cdm.observable.common.TimeTypeEnum import TimeTypeEnum
from cdm.observable.common.DeterminationMethodEnum import DeterminationMethodEnum
from cdm.base.staticdata.asset.common.AssetIdentifier import AssetIdentifier

__all__ = ['ResolveTimeZoneFromTimeType']


@replaceable
def ResolveTimeZoneFromTimeType(assetIdentifier: AssetIdentifier, timeType: TimeTypeEnum, determinationMethod: DeterminationMethodEnum) -> TimeZone:
    """
    Defines inputs and outputs needed to derive the time and time-zone for a product identifier
    
    Parameters 
    ----------
    assetIdentifier : AssetIdentifier
    
    timeType : TimeTypeEnum
    
    determinationMethod : DeterminationMethodEnum
    
    Returns
    -------
    time : TimeZone
    
    """
    self = inspect.currentframe()
    
    
    time = rosetta_resolve_attr(self, "time")
    
    
    return time

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
