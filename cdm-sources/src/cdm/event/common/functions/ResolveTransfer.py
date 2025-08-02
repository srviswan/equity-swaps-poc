# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.InterestCashSettlementAmount import InterestCashSettlementAmount
from cdm.event.common.CalculateTransferInstruction import CalculateTransferInstruction
from cdm.event.common.functions.EquityCashSettlementAmount import EquityCashSettlementAmount
from cdm.event.common.Transfer import Transfer
from cdm.event.common.functions.SecurityFinanceCashSettlementAmount import SecurityFinanceCashSettlementAmount

__all__ = ['ResolveTransfer']


@replaceable
def ResolveTransfer(instruction: CalculateTransferInstruction) -> Transfer:
    """
    Defines how to calculate the amount due to be transferred after a Reset Event.
    
    Parameters 
    ----------
    instruction : CalculateTransferInstruction
    
    Returns
    -------
    transfer : Transfer
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn2():
        return InterestCashSettlementAmount(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "tradeState"), rosetta_resolve_attr(self, "payout"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "resets"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "date"))
    
    def _else_fn2():
        return True
    
    def _then_fn1():
        return EquityCashSettlementAmount(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "tradeState"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "date"))
    
    def _else_fn1():
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout"), "rateSpecification"), "FloatingRateSpecification")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "InterestRatePayout"), "rateSpecification"), "FixedRateSpecification"))), _then_fn2, _else_fn2)
    
    def _then_fn0():
        return SecurityFinanceCashSettlementAmount(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "tradeState"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "date"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "quantity"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payerReceiver"))
    
    def _else_fn0():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "PerformancePayout")), _then_fn1, _else_fn1)
    
    payout = rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payout")
    transfer =  if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "payout"), "AssetPayout")), _then_fn0, _else_fn0)
    transfer = _get_rosetta_object('Transfer', 'settlementDate', _get_rosetta_object('AdjustableOrAdjustedOrRelativeDate', 'adjustedDate', rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "date")))
    
    
    return transfer

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
