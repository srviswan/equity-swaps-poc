# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.asset.functions.ResolvePerformancePeriodStartPrice import ResolvePerformancePeriodStartPrice
from cdm.event.common.Trade import Trade
from cdm.event.common.functions.EquityNotionalAmount import EquityNotionalAmount
from cdm.event.common.functions.RateOfReturn import RateOfReturn
from cdm.observable.asset.Price import Price

__all__ = ['EquityPerformance']


@replaceable
def EquityPerformance(trade: Trade, observation: Price, date: datetime.date) -> Decimal:
    """
    Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance' means, in respect of an Equity Cash Settlement Date, an amount in the Settlement Currency determined by the Calculation Agent as of the Equity Valuation Date to which the Equity Cash Settlement Amount relates, pursuant to the following formula: Equity Performance = (Rate Of Return)  Equity Notional Amount.
    
    Parameters 
    ----------
    trade : Trade
    
    observation : Price
    
    date : date
    
    Returns
    -------
    equityPerformance : number
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_PriceReturnTermsExists(self):
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product"), "economicTerms"), "payout"), "PerformancePayout"), "returnTerms"), "priceReturnTerms"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    performancePayout = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product"), "economicTerms"), "payout"), "PerformancePayout"))
    periodStartPrice = ResolvePerformancePeriodStartPrice(rosetta_resolve_attr(self, "performancePayout"), rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot")), "priceQuantity"), "price"), get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"), "priceQuantity"), "observable")), rosetta_resolve_attr(self, "date"))
    periodEndPrice = rosetta_resolve_attr(self, "observation")
    numberOfSecurities = (rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "performancePayout"), "priceQuantity"), "quantitySchedule"), "value") / rosetta_resolve_attr(rosetta_resolve_attr(self, "periodStartPrice"), "value"))
    rateOfReturn = RateOfReturn(rosetta_resolve_attr(self, "periodStartPrice"), rosetta_resolve_attr(self, "periodEndPrice"))
    notionalAmount = EquityNotionalAmount(rosetta_resolve_attr(self, "numberOfSecurities"), rosetta_resolve_attr(self, "periodEndPrice"))
    equityPerformance =  (rosetta_resolve_attr(self, "rateOfReturn") * rosetta_resolve_attr(self, "notionalAmount"))
    
    
    return equityPerformance

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
