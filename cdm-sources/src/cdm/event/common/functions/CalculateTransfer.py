# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.CalculateTransferInstruction import CalculateTransferInstruction
from cdm.event.common.functions.Create_AssetTransfer import Create_AssetTransfer
from cdm.event.common.functions.Create_CashTransfer import Create_CashTransfer
from cdm.event.common.Transfer import Transfer

__all__ = ['CalculateTransfer']


@replaceable
def CalculateTransfer(instruction: CalculateTransferInstruction) -> Transfer:
    """
    Function specification to calculate a transfer, e.g. following a reset on a contract
    
    Parameters 
    ----------
    instruction : CalculateTransferInstruction
    
    Returns
    -------
    transfer : Transfer
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return Create_CashTransfer(rosetta_resolve_attr(self, "instruction"))
    
    def _else_fn0():
        return True
    
    def _then_fn1():
        return Create_AssetTransfer(rosetta_resolve_attr(self, "instruction"))
    
    def _else_fn1():
        return True
    
    transfer = if_cond_fn(((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payout"), "InterestRatePayout")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payout"), "PerformancePayout"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payout"), "AssetPayout"))), _then_fn0, _else_fn0)
    transfer.add_rosetta_attr(self, if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "payout"), "AssetPayout")), _then_fn1, _else_fn1))
    
    
    return transfer

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
