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

__all__ = ['Qualify_SecuritySettlement']


@replaceable
def Qualify_SecuritySettlement(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of a security settlement from the fact that (i) it is composed of a cashTransfer component and a securityTransfer component, and (ii) the cash and security move in opposite directions.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    transfers = TransfersForDate(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "transferHistory"), "transfer"), rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "eventDate"))
    is_event =  ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "transfers"), "asset"), "Instrument"), "Security")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "transfers"), "quantity"), "unit"), "currency"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(FilterCashTransfers(rosetta_resolve_attr(self, "transfers"))), "payerReceiver"), "payerPartyReference"), "=", rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(FilterSecurityTransfers(rosetta_resolve_attr(self, "transfers"))), "payerReceiver"), "receiverPartyReference")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
