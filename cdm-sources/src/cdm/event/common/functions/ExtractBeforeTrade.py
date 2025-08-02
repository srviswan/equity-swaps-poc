# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.Trade import Trade
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['ExtractBeforeTrade']


@replaceable
def ExtractBeforeTrade(businessEvent: BusinessEvent) -> Trade:
    """
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    trade : Trade
    
    """
    self = inspect.currentframe()
    
    
    trade =  rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction")), "before"), "trade")
    
    
    return trade

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
