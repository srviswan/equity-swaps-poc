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

__all__ = ['Qualify_Termination']


@replaceable
def Qualify_Termination(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a termination event from the fact that (i) the intent is Termination when specified, (ii) the only primitive is the quantityChange and there is only one such primitive involved, the (iii) the remaining quantity is null, and (iv) the closedState of the contract is Terminated.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    primitiveInstruction = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"))
    transfer = get_only_element(TransfersForDate(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "transferHistory"), "transfer"), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "eventDate")))
    is_event =  ((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"))) and (self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "quantityChange")) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "quantityChange")))) and all_elements(QuantityDecreasedToZero(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after")), "=", True)) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "state"), "closedState"), "state"), "=", rosetta_resolve_attr(ClosedStateEnum, "TERMINATED")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
