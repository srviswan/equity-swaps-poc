# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.event.common.functions.Create_CancellationTermChangeInstruction import Create_CancellationTermChangeInstruction
from cdm.event.common.TradeState import TradeState
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_CancellationPrimitiveInstruction']


@replaceable
def Create_CancellationPrimitiveInstruction(tradeState: TradeState, newRepurchasePrice: Decimal | None, cancellationDate: AdjustableOrRelativeDate) -> PrimitiveInstruction:
    """
    Creates a primitive instruction for early cancellation.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be rolled.
    
    newRepurchasePrice : number
    The new repurchase price after the new termination date is set.
    
    cancellationDate : AdjustableOrRelativeDate
    The new termination date.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    self = inspect.currentframe()
    
    
    instruction = _get_rosetta_object('PrimitiveInstruction', 'split', _get_rosetta_object('SplitInstruction', 'breakdown', [Create_TerminationInstruction(rosetta_resolve_attr(self, "tradeState"))]))
    instruction.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, instruction), 'split'), 'breakdown'), [PrimitiveInstruction(quantityChange=QuantityChangeInstruction(change=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot"), "priceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[]), termsChange=Create_CancellationTermChangeInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), rosetta_resolve_attr(self, "cancellationDate")))])
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
