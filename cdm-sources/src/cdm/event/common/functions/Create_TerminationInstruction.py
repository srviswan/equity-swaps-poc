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
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule

__all__ = ['Create_TerminationInstruction']


@replaceable
def Create_TerminationInstruction(tradeState: TradeState) -> PrimitiveInstruction:
    """
    Creates the relevant primitive instruction for a termination, which consists in a quantity change to bring the quantity to zero.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be termintaed.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    self = inspect.currentframe()
    
    
    changeQuantity = (lambda item: set(item))(map(lambda item: NonNegativeQuantitySchedule(value=0.0, unit=rosetta_resolve_attr(item, "unit")), rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "priceQuantity"), "quantity")))
    changePriceQuantity = PriceQuantity(quantity=rosetta_resolve_attr(self, "changeQuantity"))
    instruction = _get_rosetta_object('PrimitiveInstruction', 'quantityChange', QuantityChangeInstruction(change=rosetta_resolve_attr(self, "changePriceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[]))
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
