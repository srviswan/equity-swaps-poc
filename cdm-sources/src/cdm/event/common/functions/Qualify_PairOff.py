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
from cdm.event.common.functions.NewTradeInstructionOnlyExists import NewTradeInstructionOnlyExists

__all__ = ['Qualify_PairOff']


@replaceable
def Qualify_PairOff(businessEvent: BusinessEvent) -> bool:
    """
    Qualifies an event as a pair-off when all the details of the existing trades are maintained, except for their execution details which are updated to include a package component. This package component must be unique across all trades.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    openTradeState = FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    newTradeInstruction = rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), lambda item: NewTradeInstructionOnlyExists(rosetta_resolve_attr(item, "primitiveInstruction")))
    packageRef = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeState"), "trade"), "executionDetails"), "packageReference")
    is_event =  (((((((all_elements(rosetta_count(rosetta_resolve_attr(self, "newTradeInstruction")), "=", rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeState"), "trade"), "product"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeInstruction"), "before"), "trade"), "product"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeState"), "trade"), "tradeLot"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeInstruction"), "before"), "trade"), "tradeLot"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeState"), "trade"), "counterparty"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeInstruction"), "before"), "trade"), "counterparty"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeState"), "trade"), "ancillaryParty"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeInstruction"), "before"), "trade"), "ancillaryParty"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeState"), "trade"), "adjustment"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeInstruction"), "before"), "trade"), "adjustment"))) and all_elements(rosetta_count(rosetta_resolve_attr(self, "packageRef")), "=", rosetta_count(rosetta_resolve_attr(self, "openTradeState")))) and all_elements(rosetta_count(set(rosetta_resolve_attr(self, "packageRef"))), "=", 1))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
