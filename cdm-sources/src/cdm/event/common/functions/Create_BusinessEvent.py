# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.Create_Split import Create_Split
from cdm.event.common.functions.Create_Exercise import Create_Exercise
from cdm.event.common.EventIntentEnum import EventIntentEnum
from cdm.event.common.Instruction import Instruction
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Create_BusinessEvent']


@replaceable
def Create_BusinessEvent(instruction: list[Instruction], intent: EventIntentEnum | None, eventDate: datetime.date, effectiveDate: datetime.date) -> BusinessEvent:
    """
    Creates a business event from instructions containing primitive instructions and optionally a trade state.
    
    Parameters 
    ----------
    instruction : Instruction
    
    intent : EventIntentEnum
    
    eventDate : date
    
    effectiveDate : date
    
    Returns
    -------
    businessEvent : BusinessEvent
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn1():
        return Create_Exercise(rosetta_resolve_attr(rosetta_resolve_attr(item, "primitiveInstruction"), "exercise"), rosetta_resolve_attr(item, "before"))
    
    def _else_fn1():
        return [Create_TradeState(rosetta_resolve_attr(item, "primitiveInstruction"), rosetta_resolve_attr(item, "before"))]
    
    def _then_fn0():
        return Create_Split(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "primitiveInstruction"), "split"), "breakdown"), rosetta_resolve_attr(item, "before"))
    
    def _else_fn0():
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(item, "primitiveInstruction"), "exercise")), _then_fn1, _else_fn1)
    
    businessEvent = rosetta_resolve_attr(self, "instruction")
    businessEvent = _get_rosetta_object('BusinessEvent', 'intent', rosetta_resolve_attr(self, "intent"))
    businessEvent = set_rosetta_attr(rosetta_resolve_attr(self, 'businessEvent'), 'eventDate', rosetta_resolve_attr(self, "eventDate"))
    businessEvent = set_rosetta_attr(rosetta_resolve_attr(self, 'businessEvent'), 'effectiveDate', rosetta_resolve_attr(self, "effectiveDate"))
    businessEvent.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, businessEvent), 'after'), (lambda item: flatten_list(item))(map(lambda item: if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(item, "primitiveInstruction"), "split")), _then_fn4, _else_fn4), rosetta_resolve_attr(self, "instruction"))))
    
    
    return businessEvent

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
