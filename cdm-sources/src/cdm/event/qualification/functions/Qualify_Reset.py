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

__all__ = ['Qualify_Reset']


@replaceable
def Qualify_Reset(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a reset event from the fact that the only primitive is the reset.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    beforeTradeState = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"))
    afterTradeState = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"))
    is_event =  ((all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after")), "=", 1) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "trade"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "afterTradeState"), "trade"))) and all_elements((rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "beforeTradeState"), "resetHistory")) + 1), "=", rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(self, "afterTradeState"), "resetHistory"))))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
