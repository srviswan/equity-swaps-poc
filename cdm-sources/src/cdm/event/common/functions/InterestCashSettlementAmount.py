# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.functions.ExtractCounterpartyByRole import ExtractCounterpartyByRole
from cdm.product.asset.functions.FloatingAmount import FloatingAmount
from cdm.product.asset.functions.FixedAmount import FixedAmount
from cdm.product.template.Payout import Payout
from cdm.event.common.Reset import Reset
from cdm.event.common.TradeState import TradeState
from cdm.event.common.Transfer import Transfer

__all__ = ['InterestCashSettlementAmount']


@replaceable
def InterestCashSettlementAmount(tradeState: TradeState, payout: Payout, resets: list[Reset], date: datetime.date) -> Transfer:
    """
    Defines the performance calculations relevant for a fixed or floating rate payout.
    
    Parameters 
    ----------
    tradeState : TradeState
    
    payout : Payout
    
    resets : Reset
    
    date : date
    
    Returns
    -------
    interestCashSettlementAmount : Transfer
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_IsInterestRatePayout(self):
        """
        Payout must be an InterestRatePayout.
        """
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn1():
        return FloatingAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(self, "resets")), "resetValue"), "value"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "priceQuantity"), "quantitySchedule"), "value"), rosetta_resolve_attr(self, "date"), [])
    
    def _else_fn1():
        return True
    
    def _then_fn0():
        return FixedAmount(rosetta_resolve_attr(self, "interestRatePayout"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "priceQuantity"), "quantitySchedule"), "value"), rosetta_resolve_attr(self, "date"), [])
    
    def _else_fn0():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FloatingRateSpecification")), _then_fn1, _else_fn1)
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "payer")
    
    def _else_fn1():
        return rosetta_resolve_attr(self, "receiver")
    
    def _then_fn2():
        return rosetta_resolve_attr(self, "receiver")
    
    def _else_fn2():
        return rosetta_resolve_attr(self, "payer")
    
    interestRatePayout = rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout")
    performance = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "rateSpecification"), "FixedRateSpecification")), _then_fn0, _else_fn0)
    payer = rosetta_resolve_attr(ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "counterparty"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "payerReceiver"), "payer")), "partyReference")
    receiver = rosetta_resolve_attr(ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "counterparty"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "payerReceiver"), "receiver")), "partyReference")
    interestCashSettlementAmount = _get_rosetta_object('Transfer', 'quantity', _get_rosetta_object('NonNegativeQuantity', 'value', rosetta_resolve_attr(self, "performance")))
    interestCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'interestCashSettlementAmount'), 'quantity->unit->currency', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRatePayout"), "priceQuantity"), "quantitySchedule"), "unit"), "currency"))
    interestCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'interestCashSettlementAmount'), 'payerReceiver->payerPartyReference', if_cond_fn(all_elements(rosetta_resolve_attr(self, "performance"), ">=", 0), _then_fn0, _else_fn0))
    interestCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'interestCashSettlementAmount'), 'payerReceiver->receiverPartyReference', if_cond_fn(all_elements(rosetta_resolve_attr(self, "performance"), ">=", 0), _then_fn1, _else_fn1))
    interestCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'interestCashSettlementAmount'), 'settlementDate->adjustedDate', rosetta_resolve_attr(self, "date"))
    interestCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'interestCashSettlementAmount'), 'settlementOrigin', {rosetta_resolve_attr(self, "payout"): True})
    
    
    return interestCashSettlementAmount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
