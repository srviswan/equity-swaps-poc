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

__all__ = ['Qualify_CorporateActionDetermined']


@replaceable
def Qualify_CorporateActionDetermined(businessEvent: BusinessEvent) -> bool:
    """
    The qualification of the ocurrence of a corporate action form the fact that a corporate action is present in either the observation or the observation history structures.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_event =  ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"), "observation"), "observationEvent"), "corporateAction")) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "before"), "observationHistory"), "corporateAction"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "after"), "observationHistory"), "corporateAction")))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
