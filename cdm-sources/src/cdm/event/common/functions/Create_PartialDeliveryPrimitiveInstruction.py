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
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_PartialDeliveryPrimitiveInstruction']


@replaceable
def Create_PartialDeliveryPrimitiveInstruction(tradeState: TradeState, deliveredPriceQuantity: list[PriceQuantity]) -> PrimitiveInstruction:
    """
    Creates the primitive instruction for partial delivery of a repo transaction at settlement.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be closed.
    
    deliveredPriceQuantity : PriceQuantity
    The price and quantity of the delivered amount.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    self = inspect.currentframe()
    
    
    instruction = _get_rosetta_object('PrimitiveInstruction', 'split', _get_rosetta_object('SplitInstruction', 'breakdown', [Create_TerminationInstruction(rosetta_resolve_attr(self, "tradeState"))]))
    instruction = set_rosetta_attr(rosetta_resolve_attr(self, 'instruction'), 'split->breakdown', [PrimitiveInstruction(quantityChange=QuantityChangeInstruction(change=rosetta_resolve_attr(self, "deliveredPriceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot"), "lotIdentifier")))])
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
