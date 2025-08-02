# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.workflow.EventInstruction import EventInstruction
from cdm.event.common.TradeState import TradeState
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule

__all__ = ['ResolveRepurchaseTransferInstruction']


@replaceable
def ResolveRepurchaseTransferInstruction(tradeState: TradeState, repurchaseDate: datetime.date) -> EventInstruction:
    """
    Resolves an instruction for settlement of a Repurchase Event
    
    Parameters 
    ----------
    tradeState : TradeState
    
    repurchaseDate : date
    
    Returns
    -------
    repurchaseInstruction : EventInstruction
    
    """
    self = inspect.currentframe()
    
    
    changeQuantity = (lambda item: set(item))(map(lambda item: NonNegativeQuantitySchedule(value=0.0, unit=rosetta_resolve_attr(self, "unit")), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot"), "priceQuantity"), "quantity")))
    changePriceQuantity = PriceQuantity(quantity=rosetta_resolve_attr(self, "changeQuantity"))
    repurchaseInstruction = _get_rosetta_object('EventInstruction', 'intent', rosetta_resolve_attr(EventIntentEnum, "REPURCHASE"))
    repurchaseInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'repurchaseInstruction'), 'instruction->before', rosetta_resolve_attr(self, "tradeState"))
    repurchaseInstruction = set_rosetta_attr(rosetta_resolve_attr(self, 'repurchaseInstruction'), 'instruction->primitiveInstruction->quantityChange', QuantityChangeInstruction(change=rosetta_resolve_attr(self, "changePriceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[]))
    
    
    return repurchaseInstruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
