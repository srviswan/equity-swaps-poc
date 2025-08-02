# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.margin.schedule.functions.GetGrossInitialMarginFromStandardizedSchedule import GetGrossInitialMarginFromStandardizedSchedule
from cdm.margin.schedule.StandardizedScheduleTradeInfo import StandardizedScheduleTradeInfo
from cdm.event.common.ValuationTypeEnum import ValuationTypeEnum
from cdm.margin.schedule.functions.BuildStandardizedSchedule import BuildStandardizedSchedule
from cdm.event.common.Exposure import Exposure
from cdm.margin.schedule.StandardizedScheduleInitialMargin import StandardizedScheduleInitialMargin

__all__ = ['GetNetInitialMarginFromExposure']


@replaceable
def GetNetInitialMarginFromExposure(exposure: Exposure | None) -> StandardizedScheduleInitialMargin:
    """
    Computes the net initial margin, taking the gross initial margin result and the mark to market value for each trade in the portfolio.
    
    Parameters 
    ----------
    exposure : Exposure
    
    Returns
    -------
    initialMargin : StandardizedScheduleInitialMargin
    
    """
    _post_registry = {}
    self = inspect.currentframe()
    
    
    tradePortfolio = rosetta_resolve_attr(rosetta_resolve_attr(self, "exposure"), "tradePortfolio")
    positions = rosetta_resolve_attr(rosetta_resolve_attr(self, "tradePortfolio"), "positions")
    tradeInitialMargin = map(lambda item: StandardizedScheduleTradeInfo(assetClass=rosetta_resolve_attr(BuildStandardizedSchedule(rosetta_resolve_attr(rosetta_resolve_attr(item, "tradeReference"), "trade")), "assetClass"), productClass=rosetta_resolve_attr(BuildStandardizedSchedule(rosetta_resolve_attr(rosetta_resolve_attr(item, "tradeReference"), "trade")), "productClass"), grossInitialMargin=GetGrossInitialMarginFromStandardizedSchedule(BuildStandardizedSchedule(rosetta_resolve_attr(rosetta_resolve_attr(item, "tradeReference"), "trade"))), markToMarketValue=(lambda item: rosetta_resolve_attr(self, "amount"))((lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(item, "tradeReference"), "valuationHistory"), lambda item: all_elements(rosetta_resolve_attr(self, "method"), "=", rosetta_resolve_attr(ValuationTypeEnum, "MARK_TO_MARKET")))))), rosetta_resolve_attr(self, "positions"))
    totalGIM = sum(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeInitialMargin"), "grossInitialMargin"), "value"))
    netCurrentReplacementCost = sum(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeInitialMargin"), "markToMarketValue"), "value"))
    grossCurrentReplacementCost = (lambda item: sum(rosetta_resolve_attr(self, "value")))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeInitialMargin"), "markToMarketValue"), lambda item: all_elements(rosetta_resolve_attr(item, "value"), ">", 0)))
    netToGrossRatio = (rosetta_resolve_attr(self, "netCurrentReplacementCost") / rosetta_resolve_attr(self, "grossCurrentReplacementCost"))
    initialMargin = rosetta_resolve_attr(self, "tradeInitialMargin")
    initialMargin = _get_rosetta_object('StandardizedScheduleInitialMargin', 'netInitialMargin', _get_rosetta_object('Money', 'value', ((0.4 * rosetta_resolve_attr(self, "totalGIM")) + ((0.6 * rosetta_resolve_attr(self, "totalGIM")) * rosetta_resolve_attr(self, "netToGrossRatio")))))
    initialMargin = set_rosetta_attr(rosetta_resolve_attr(self, 'initialMargin'), 'netInitialMargin->unit->currency', get_only_element(set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeInitialMargin"), "markToMarketValue"), "unit"), "currency"))))
    
    # post-conditions
    
    @rosetta_local_condition(_post_registry)
    def condition_0_NonNegativeNetInitialMargin(self):
        """
        Ensure net initial margin is non-negative
        """
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "initialMargin"), "netInitialMargin"), "value"), ">=", 0)
    
    @rosetta_local_condition(_post_registry)
    def condition_1_TotalGIMAddition(self):
        """
        Ensure that only a single currency exists
        """
        return all_elements(rosetta_count(set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeInitialMargin"), "grossInitialMargin"), "unit"), "currency"))), "=", 1)
    
    @rosetta_local_condition(_post_registry)
    def condition_2_NGRAddition(self):
        """
        Ensure that only a single currency exists
        """
        return all_elements(rosetta_count(set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeInitialMargin"), "markToMarketValue"), "unit"), "currency"))), "=", 1)
    # Execute all registered post-conditions
    execute_local_conditions(_post_registry, 'Post-condition')
    
    return initialMargin

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
