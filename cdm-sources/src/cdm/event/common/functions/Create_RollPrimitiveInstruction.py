# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.Create_RollTermChangeInstruction import Create_RollTermChangeInstruction
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.functions.Create_TerminationInstruction import Create_TerminationInstruction
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.TradeState import TradeState
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_RollPrimitiveInstruction']


@replaceable
def Create_RollPrimitiveInstruction(tradeState: TradeState, effectiveRollDate: AdjustableOrRelativeDate, terminationDate: AdjustableOrRelativeDate, priceQuantity: list[PriceQuantity]) -> PrimitiveInstruction:
    """
    Creates the primitive instructions for a trade roll. A trade roll consists in closing an existing trade and entering into a new one which has the same characteristics as the old one, except with an extended termination date and (possibly) a different price.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be rolled.
    
    effectiveRollDate : AdjustableOrRelativeDate
    The date to close and open a new position.
    
    terminationDate : AdjustableOrRelativeDate
    The new termination date.
    
    priceQuantity : PriceQuantity
    The price and quantity of the trade to roll into.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    self = inspect.currentframe()
    
    
    instruction = _get_rosetta_object('PrimitiveInstruction', 'split', _get_rosetta_object('SplitInstruction', 'breakdown', [Create_TerminationInstruction(rosetta_resolve_attr(self, "tradeState"))]))
    instruction.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, instruction), 'split'), 'breakdown'), [PrimitiveInstruction(quantityChange=QuantityChangeInstruction(change=rosetta_resolve_attr(self, "priceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[]), termsChange=Create_RollTermChangeInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), rosetta_resolve_attr(self, "effectiveRollDate"), rosetta_resolve_attr(self, "terminationDate")))])
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
