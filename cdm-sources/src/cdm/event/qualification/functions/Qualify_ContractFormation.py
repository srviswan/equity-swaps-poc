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

__all__ = ['Qualify_ContractFormation']


@replaceable
def Qualify_ContractFormation(businessEvent: BusinessEvent) -> bool:
    """
    Qualifies a business event as a contract formation from the fact that the only component is a single Contract Formation Primitive.
    
    Parameters 
    ----------
    businessEvent : BusinessEvent
    
    Returns
    -------
    is_event : boolean
    
    """
    self = inspect.currentframe()
    
    
    primitiveInstruction = get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "instruction"), "primitiveInstruction"))
    is_event =  ((((self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "contractFormation")) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "contractFormation"))) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution"))) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution"))) or ((not rosetta_attr_exists(rosetta_resolve_attr(self, "primitiveInstruction"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "businessEvent"), "intent"), "=", rosetta_resolve_attr(EventIntentEnum, "CONTRACT_FORMATION"))))
    
    
    return is_event

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
