# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.TradeState import TradeState
from cdm.event.common.TransferInstruction import TransferInstruction

__all__ = ['Create_Transfer']


@replaceable
def Create_Transfer(instruction: TransferInstruction, tradeState: TradeState) -> TradeState:
    """
    Defines how a transfer should be constructed, when representing the exchange of cash between parties.
    
    Parameters 
    ----------
    instruction : TransferInstruction
    
    tradeState : TradeState
    Represents the trade and associated state on which to construct the Transfer data type.
    
    Returns
    -------
    transfer : TradeState
    
    """
    self = inspect.currentframe()
    
    
    transfer =  rosetta_resolve_attr(self, "tradeState")
    transfer.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, transfer), 'transferHistory'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "transferState"))
    
    
    return transfer

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
