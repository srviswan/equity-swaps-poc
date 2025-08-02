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

__all__ = ['Qualify_Novation']


@replaceable
def Qualify_Novation(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a novation event from the fact that (i) the intent is Novation when specified, (ii) the primitives quantityChange and a contract formation exist, (iii) the remaining quantity = 0, (iv) the closedState of the contract is Novated, (v) the stepped-in contract has a different contract identifier than the novated contract, (vi) the stepped-in contract has the novation event date and the novation event effective date, and (vii) the contract counterparties have changed.
    
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
    is_event =  ((((((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "NOVATION")) and all_elements(rosetta_count(rosetta_resolve_attr(self, "closedTradeStates")), "=", 1)) and all_elements(rosetta_count(rosetta_resolve_attr(self, "openTradeStates")), "=", 1)) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"), "split"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(self, "closedTradeStates")), "trade"), "counterparty"), "partyReference"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(self, "openTradeStates")), "trade"), "counterparty"), "partyReference"))) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "tradeIdentifier"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeStates"), "trade"), "tradeIdentifier")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
