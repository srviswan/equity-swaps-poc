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

__all__ = ['Qualify_ValuationUpdate']


@replaceable
def Qualify_ValuationUpdate(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a valuation update from the fact that the only component is a valuation.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    instruction = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"))
    is_event =  self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "primitiveInstruction"), "valuation"))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
