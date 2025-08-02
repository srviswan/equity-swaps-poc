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
from cdm.event.position.functions.InterpolateForwardRate import InterpolateForwardRate
from cdm.base.math.functions.FilterQuantityByCurrency import FilterQuantityByCurrency

__all__ = ['FxMarkToMarket']


@replaceable
def FxMarkToMarket(trade: Trade) -> Decimal:
    """
    Representation of sample mark to market calculation provided by a member firm.
    
    Parameters 
    ----------
    trade : Trade
    
    Returns
    -------
    value : number
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_SettlementPayoutExists(self):
        """
        The settlementPayout on the contract must exist.
        """
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product"), "economicTerms"), "payout"), "SettlementPayout"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    settlementPayout = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product"), "economicTerms"), "payout"), "SettlementPayout"))
    quotedCurrency = get_only_element(set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"), "priceQuantity"), "price"), "unit"), "currency")))
    baseCurrency = get_only_element(set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"), "priceQuantity"), "price"), "perUnitOf"), "currency")))
    quantities = rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot")), "priceQuantity"), "quantity")
    quotedQuantity = rosetta_resolve_attr(get_only_element(FilterQuantityByCurrency(rosetta_resolve_attr(self, "quantities"), rosetta_resolve_attr(self, "quotedCurrency"))), "value")
    baseQuantity = rosetta_resolve_attr(get_only_element(FilterQuantityByCurrency(rosetta_resolve_attr(self, "quantities"), rosetta_resolve_attr(self, "baseCurrency"))), "value")
    interpolatedRate = InterpolateForwardRate(rosetta_resolve_attr(self, "settlementPayout"))
    value =  (((rosetta_resolve_attr(self, "quotedQuantity") / rosetta_resolve_attr(self, "interpolatedRate")) - rosetta_resolve_attr(self, "baseQuantity")) * rosetta_resolve_attr(self, "interpolatedRate"))
    
    
    return value

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
