# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.PartyRole import PartyRole
from cdm.base.staticdata.party.PartyRoleEnum import PartyRoleEnum

__all__ = ['IsValidPartyRole']


@replaceable
def IsValidPartyRole(partyRoles: list[PartyRole] | None, validRoles: list[PartyRoleEnum]) -> bool:
    """
    
    Parameters 
    ----------
    partyRoles : PartyRole
    
    validRoles : PartyRoleEnum
    
    Returns
    -------
    isValid : boolean
    
    """
    self = inspect.currentframe()
    
    
    isValid =  (lambda item: all_elements(item, "=", True))(map(lambda item: contains(rosetta_resolve_attr(self, "validRoles"), rosetta_resolve_attr(self, "role")), rosetta_resolve_attr(self, "partyRoles")))
    
    
    return isValid

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
