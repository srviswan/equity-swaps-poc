# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.Money import Money
from cdm.margin.schedule.StandardizedSchedule import StandardizedSchedule
from cdm.margin.schedule.functions.GetStandardizedScheduleMarginRate import GetStandardizedScheduleMarginRate

__all__ = ['GetGrossInitialMarginFromStandardizedSchedule']


@replaceable
def GetGrossInitialMarginFromStandardizedSchedule(standardizedSchedule: StandardizedSchedule) -> Money:
    """
    Takes the grid information from an specific trade and calculates the gross initial margin.
    
    Parameters 
    ----------
    standardizedSchedule : StandardizedSchedule
    
    Returns
    -------
    grossInitialMargin : Money
    
    """
    _post_registry = {}
    self = inspect.currentframe()
    
    
    initialMarginRequirement = GetStandardizedScheduleMarginRate(rosetta_resolve_attr(rosetta_resolve_attr(self, "standardizedSchedule"), "assetClass"), rosetta_resolve_attr(rosetta_resolve_attr(self, "standardizedSchedule"), "durationInYears"))
    grossInitialMargin = _get_rosetta_object('Money', 'value', ((rosetta_resolve_attr(rosetta_resolve_attr(self, "standardizedSchedule"), "notional") * rosetta_resolve_attr(self, "initialMarginRequirement")) * 0.01))
    grossInitialMargin = set_rosetta_attr(rosetta_resolve_attr(self, 'grossInitialMargin'), 'unit->currency', rosetta_resolve_attr(rosetta_resolve_attr(self, "standardizedSchedule"), "notionalCurrency"))
    
    # post-conditions
    
    @rosetta_local_condition(_post_registry)
    def condition_0_PositiveGrossInitialMargin(self):
        """
        Ensure gross initial margin is greater than 0
        """
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "grossInitialMargin"), "value"), ">", 0)
    # Execute all registered post-conditions
    execute_local_conditions(_post_registry, 'Post-condition')
    
    return grossInitialMargin

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
