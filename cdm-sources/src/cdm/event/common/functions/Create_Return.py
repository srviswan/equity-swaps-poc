# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ReturnInstruction import ReturnInstruction
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.functions.Create_QuantityChange import Create_QuantityChange
from cdm.event.common.TradeState import TradeState
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Create_Return']


@replaceable
def Create_Return(tradeState: TradeState, returnInstruction: ReturnInstruction, returnDate: datetime.date) -> BusinessEvent:
    """
    Defines the process of partially or fully returning a Security Lending Transaction.
    
    Parameters 
    ----------
    tradeState : TradeState
    Specifies a previously formed contractual product with a Security Finance payout. It is required that the description of the contractual product be contained within the previous business event, i.e. its lineage must contain the formation of a contractual product.
    
    returnInstruction : ReturnInstruction
    Specifies the information required to fully return the Stock Loan in accordance with the economic terms of the contractual product.
    
    returnDate : date
    Specifies the date of the full return.
    
    Returns
    -------
    returnEvent : BusinessEvent
    
    """
    self = inspect.currentframe()
    
    
    quantitySchedule = map(lambda item: NonNegativeQuantitySchedule(value=rosetta_resolve_attr(self, "value"), unit=rosetta_resolve_attr(self, "unit")), rosetta_resolve_attr(rosetta_resolve_attr(self, "returnInstruction"), "quantity"))
    changePriceQuantity = PriceQuantity(quantity=rosetta_resolve_attr(self, "quantitySchedule"))
    returnEvent = Create_QuantityChange(QuantityChangeInstruction(change=rosetta_resolve_attr(self, "changePriceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "DECREASE"), lotIdentifier=[]), rosetta_resolve_attr(self, "tradeState"))
    returnEvent = _get_rosetta_object('BusinessEvent', 'eventDate', rosetta_resolve_attr(self, "returnDate"))
    
    
    return returnEvent

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
