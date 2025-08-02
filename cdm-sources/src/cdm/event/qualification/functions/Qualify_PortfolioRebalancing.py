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

__all__ = ['Qualify_PortfolioRebalancing']


@replaceable
def Qualify_PortfolioRebalancing(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a portfolio rebalancing event from the fact that (i) the intent is PortfolioRebalancing, and (ii) the execution primitive exists
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_event =  (all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "PORTFOLIO_REBALANCING")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"), "execution")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
