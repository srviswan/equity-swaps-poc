# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.Trade import Trade
from cdm.margin.schedule.StandardizedSchedule import StandardizedSchedule
from cdm.margin.schedule.functions.StandardizedScheduleNotional import StandardizedScheduleNotional
from cdm.margin.schedule.functions.StandardizedScheduleAssetClass import StandardizedScheduleAssetClass
from cdm.margin.schedule.functions.StandardizedScheduleProductClass import StandardizedScheduleProductClass
from cdm.margin.schedule.functions.StandardizedScheduleDuration import StandardizedScheduleDuration
from cdm.margin.schedule.functions.StandardizedScheduleNotionalCurrency import StandardizedScheduleNotionalCurrency

__all__ = ['BuildStandardizedSchedule']


@replaceable
def BuildStandardizedSchedule(trade: Trade) -> StandardizedSchedule:
    """
    Takes a trade and uses qualification to extract the relevant information to populate the grid that will be used to calculate the gross initial margin.
    
    Parameters 
    ----------
    trade : Trade
    
    Returns
    -------
    standardizedSchedule : StandardizedSchedule
    
    """
    self = inspect.currentframe()
    
    
    assetClass = StandardizedScheduleAssetClass(rosetta_resolve_attr(self, "trade"))
    productClass = StandardizedScheduleProductClass(rosetta_resolve_attr(self, "trade"))
    standardizedSchedule = _get_rosetta_object('StandardizedSchedule', 'assetClass', rosetta_resolve_attr(self, "assetClass"))
    standardizedSchedule = set_rosetta_attr(rosetta_resolve_attr(self, 'standardizedSchedule'), 'productClass', rosetta_resolve_attr(self, "productClass"))
    standardizedSchedule = set_rosetta_attr(rosetta_resolve_attr(self, 'standardizedSchedule'), 'notional', StandardizedScheduleNotional(rosetta_resolve_attr(self, "trade"), rosetta_resolve_attr(self, "assetClass"), rosetta_resolve_attr(self, "productClass")))
    standardizedSchedule = set_rosetta_attr(rosetta_resolve_attr(self, 'standardizedSchedule'), 'notionalCurrency', StandardizedScheduleNotionalCurrency(rosetta_resolve_attr(self, "trade"), rosetta_resolve_attr(self, "assetClass"), rosetta_resolve_attr(self, "productClass")))
    standardizedSchedule = set_rosetta_attr(rosetta_resolve_attr(self, 'standardizedSchedule'), 'durationInYears', StandardizedScheduleDuration(rosetta_resolve_attr(self, "trade"), rosetta_resolve_attr(self, "assetClass"), rosetta_resolve_attr(self, "productClass")))
    
    
    return standardizedSchedule

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
