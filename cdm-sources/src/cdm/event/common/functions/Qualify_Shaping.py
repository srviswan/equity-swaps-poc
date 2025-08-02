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
from cdm.event.common.functions.TradeNoExecutionDetails import TradeNoExecutionDetails

__all__ = ['Qualify_Shaping']


@replaceable
def Qualify_Shaping(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a shaping event from the fact that (i) the only primitive is a split where the original trade is closed, (ii) the parties before and after the split remain the same (by contrast with an allocation, for instance) and (iii) the split trades contain a package component in their execution details. This package ties together the resulting shapes trades' identifiers and must be the same across all shaped trades. Note that SplitPrimitive type has a condition to check that the post-split quantities sum to the pre-split quantity.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    instruction = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"))
    beforeTradeState = rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "before")
    closedTradeState = get_only_element(FilterClosedTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after")))
    openTradeStates = FilterOpenTradeStates(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    packageRef = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "openTradeStates"), "trade"), "executionDetails"), "packageReference")
    openTradeNoExecutionDetails = map(lambda item: TradeNoExecutionDetails(rosetta_resolve_attr(item, "trade")), rosetta_resolve_attr(self, "openTradeStates"))
    is_event =  ((((((rosetta_attr_exists(rosetta_resolve_attr(self, "beforeTradeState")) and rosetta_attr_exists(rosetta_resolve_attr(self, "closedTradeState"))) and all_elements(rosetta_count(rosetta_resolve_attr(self, "openTradeStates")), ">", 1)) and self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "primitiveInstruction"), "split"))) and all_elements(map(lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(item, "trade"), "counterparty"), "partyReference"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "counterparty"), "partyReference")), rosetta_resolve_attr(self, "openTradeStates")), "=", True)) and all_elements(rosetta_count(rosetta_resolve_attr(self, "packageRef")), "=", rosetta_count(rosetta_resolve_attr(self, "openTradeNoExecutionDetails")))) and all_elements(rosetta_count(set(rosetta_resolve_attr(self, "packageRef"))), "=", 1))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
