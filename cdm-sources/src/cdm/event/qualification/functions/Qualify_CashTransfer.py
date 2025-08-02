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

__all__ = ['Qualify_CashTransfer']


@replaceable
def Qualify_CashTransfer(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a cash transfer from the fact that the only component is a cashTransfer.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    transferInstructions = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"), "transfer")
    beforeTransfers = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"), "transferHistory")
    afterTransfers = rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "transferHistory")
    is_event =  ((all_elements(map(lambda item: self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "transfer")), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction")), "=", True) and all_elements((rosetta_count(rosetta_resolve_attr(self, "beforeTransfers")) + rosetta_count(rosetta_resolve_attr(self, "transferInstructions"))), "=", rosetta_count(rosetta_resolve_attr(self, "afterTransfers")))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "transferInstructions"), "transferState"), "transfer"), "quantity"), "unit"), "currency")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
