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

__all__ = ['FilterPartyRole']


@replaceable
def FilterPartyRole(partyRoles: list[PartyRole] | None, partyRoleEnum: PartyRoleEnum) -> PartyRole:
    """
    Filters the list of partyRoles based on the provided partyRoleEnum.
    
    Parameters 
    ----------
    partyRoles : PartyRole
    
    partyRoleEnum : PartyRoleEnum
    
    Returns
    -------
    filteredPartyRoles : PartyRole
    
    """
    self = inspect.currentframe()
    
    
    filteredPartyRoles = rosetta_filter(rosetta_resolve_attr(self, "partyRoles"), lambda item: all_elements(rosetta_resolve_attr(self, "role"), "=", rosetta_resolve_attr(self, "partyRoleEnum")))
    
    
    return filteredPartyRoles

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
