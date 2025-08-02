# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.common.functions.ResolveTimeZoneFromTimeType import ResolveTimeZoneFromTimeType
from cdm.base.datetime.TimeZone import TimeZone
from cdm.observable.common.TimeTypeEnum import TimeTypeEnum
from cdm.observable.common.DeterminationMethodEnum import DeterminationMethodEnum
from cdm.base.staticdata.asset.common.AssetIdentifier import AssetIdentifier
from cdm.base.datetime.BusinessCenterTime import BusinessCenterTime
from cdm.base.datetime.functions.TimeZoneFromBusinessCenterTime import TimeZoneFromBusinessCenterTime

__all__ = ['ResolvePerformanceValuationTime']


@replaceable
def ResolvePerformanceValuationTime(valuationTime: BusinessCenterTime | None, valuationTimeType: TimeTypeEnum | None, assetIdentifier: AssetIdentifier, determinationMethod: DeterminationMethodEnum) -> TimeZone:
    """
    Defines how to resolve the observation time from those specified in the Performance Valuation type.
    
    Parameters 
    ----------
    valuationTime : BusinessCenterTime
    Represents the Equity Valuation terms from the Equity product definition.
    
    valuationTimeType : TimeTypeEnum
    The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
    
    assetIdentifier : AssetIdentifier
    Specifies the asset identifier, along with the source, which should be used to determine the correct valuation time i.e. close times are different across exchanges.
    
    determinationMethod : DeterminationMethodEnum
    Specifies the method according to which an amount or a date is determined.
    
    Returns
    -------
    time : TimeZone
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return TimeZoneFromBusinessCenterTime(rosetta_resolve_attr(self, "valuationTime"))
    
    def _else_fn0():
        return True
    
    def _then_fn1():
        return ResolveTimeZoneFromTimeType(rosetta_resolve_attr(self, "assetIdentifier"), rosetta_resolve_attr(self, "valuationTimeType"), rosetta_resolve_attr(self, "determinationMethod"))
    
    def _else_fn1():
        return True
    
    time =  if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "valuationTime")), _then_fn0, _else_fn0)
    time =  if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "valuationTimeType")), _then_fn1, _else_fn1)
    
    
    return time

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
