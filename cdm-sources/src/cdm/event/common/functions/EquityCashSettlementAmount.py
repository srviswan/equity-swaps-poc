# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.EquityPerformance import EquityPerformance
from cdm.product.asset.functions.ResolveEquityInitialPrice import ResolveEquityInitialPrice
from cdm.event.common.TradeState import TradeState
from cdm.event.common.Transfer import Transfer
from cdm.base.math.functions.Abs import Abs
from cdm.event.common.functions.ResolveCashSettlementDate import ResolveCashSettlementDate

__all__ = ['EquityCashSettlementAmount']


@replaceable
def EquityCashSettlementAmount(tradeState: TradeState, date: datetime.date) -> Transfer:
    """
    Represents Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 72. 'Equity Cash Settlement Amount' means, in respect of an Equity Cash Settlement Date, an amount in the Settlement Currency determined by the Calculation Agent as of the Equity Valuation Date to which the Equity Cash Settlement Amount relates, pursuant to the following formula: Equity Cash Settlement Amount = ABS(Rate Of Return) * Equity Notional Amount.
    
    Parameters 
    ----------
    tradeState : TradeState
    
    date : date
    
    Returns
    -------
    equityCashSettlementAmount : Transfer
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "payer")
    
    def _else_fn0():
        return rosetta_resolve_attr(self, "receiver")
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "receiver")
    
    def _else_fn1():
        return rosetta_resolve_attr(self, "payer")
    
    payout = (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), "economicTerms"), "payout"), lambda item: rosetta_attr_exists(rosetta_resolve_attr(self, "PerformancePayout"))))
    equityPerformancePayout = rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "PerformancePayout")
    equityPerformance = EquityPerformance(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "resetHistory")), "resetValue"), rosetta_resolve_attr(self, "date"))
    payer = rosetta_resolve_attr(ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "counterparty"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "equityPerformancePayout"), "payerReceiver"), "payer")), "partyReference")
    receiver = rosetta_resolve_attr(ExtractCounterpartyByRole(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "counterparty"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "equityPerformancePayout"), "payerReceiver"), "receiver")), "partyReference")
    equityCashSettlementAmount = _get_rosetta_object('Transfer', 'quantity', _get_rosetta_object('NonNegativeQuantity', 'value', Abs(rosetta_resolve_attr(self, "equityPerformance"))))
    equityCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'equityCashSettlementAmount'), 'quantity->unit->currency', rosetta_resolve_attr(rosetta_resolve_attr(ResolveEquityInitialPrice(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "priceQuantity"), "price")), "unit"), "currency"))
    equityCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'equityCashSettlementAmount'), 'payerReceiver->payerPartyReference', if_cond_fn(all_elements(rosetta_resolve_attr(self, "equityPerformance"), ">=", 0), _then_fn0, _else_fn0))
    equityCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'equityCashSettlementAmount'), 'payerReceiver->receiverPartyReference', if_cond_fn(all_elements(rosetta_resolve_attr(self, "equityPerformance"), ">=", 0), _then_fn1, _else_fn1))
    equityCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'equityCashSettlementAmount'), 'settlementDate->adjustedDate', ResolveCashSettlementDate(rosetta_resolve_attr(self, "tradeState")))
    equityCashSettlementAmount = set_rosetta_attr(rosetta_resolve_attr(self, 'equityCashSettlementAmount'), 'settlementOrigin', {rosetta_resolve_attr(self, "payout"): True})
    
    
    return equityCashSettlementAmount

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
