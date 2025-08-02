# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.QuantityDecreasedToZero import QuantityDecreasedToZero
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Qualify_Renegotiation']


@replaceable
def Qualify_Renegotiation(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a renegotiation event from the fact that (i) the intent is Renegotiation when specified, and (ii) the associated primitives instructions are the TermsChange, QuantityChange and the cash transfer.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    transfers = TransfersForDate(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "transferHistory"), "transfer"), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "eventDate"))
    is_event =  (((((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"))) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "CONTRACT_TERMS_AMENDMENT"))) and all_elements(map(lambda item: (self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "termsChange")) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "termsChange"))), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction")), "=", True)) and all_elements(QuantityDecreasedToZero(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after")), "=", False)) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "state"), "closedState"))))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
