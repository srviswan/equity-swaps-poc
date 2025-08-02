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
from cdm.base.staticdata.party.PartyRoleEnum import PartyRoleEnum

__all__ = ['Qualify_ClearedTrade']


@replaceable
def Qualify_ClearedTrade(businessEvent: BusinessEvent) -> bool:
    """
    
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
    is_event =  (((((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "CLEARING")) and all_elements(rosetta_count(rosetta_resolve_attr(self, "closedTradeStates")), "=", 1)) and all_elements(rosetta_count(rosetta_resolve_attr(self, "openTradeStates")), "=", 2)) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"), "split"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(self, "closedTradeStates")), "trade"), "counterparty"), "partyReference"))) and all_elements(map(lambda item: ((any_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "counterparty"), "partyReference"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference")) and any_elements(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "tradeIdentifier"), "<>", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "tradeIdentifier"))) and contains(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "partyRole"), "role"), rosetta_resolve_attr(PartyRoleEnum, "CLEARING_ORGANIZATION"))), rosetta_resolve_attr(self, "openTradeStates")), "=", True))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
