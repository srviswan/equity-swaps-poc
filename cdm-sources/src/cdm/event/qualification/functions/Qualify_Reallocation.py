# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_Reallocation']


@replaceable
def Qualify_Reallocation(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a reallocation event from the fact that (i) a quantity change primitive exists, (ii) a split primitive exists, and (iii) the intent is Reallocation.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeTradeState = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"))
    closedTradeStates = FilterClosedTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    openTradeStates = FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    is_event =  ((((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "REALLOCATION")) and all_elements(rosetta_count(rosetta_resolve_attr(self, "closedTradeStates")), "=", 0)) and all_elements(rosetta_count(rosetta_resolve_attr(self, "openTradeStates")), "=", 2)) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"), "split"))) and all_elements(map(lambda item: ((any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "counterparty"), "partyReference"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference")) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeIdentifier"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "tradeIdentifier"))) or ((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "counterparty"), "partyReference"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeIdentifier"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "tradeIdentifier"))) and QuantityDecreased(rosetta_resolve_attr(self, "beforeTradeState"), [item]))), rosetta_resolve_attr(self, "openTradeStates")), "=", True))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
