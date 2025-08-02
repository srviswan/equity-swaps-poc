# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.RelatedParty import RelatedParty
from cdm.base.staticdata.party.PartyRoleEnum import PartyRoleEnum

__all__ = ['FilterRelatedPartyByRole']


@replaceable
def FilterRelatedPartyByRole(relatedParties: list[RelatedParty] | None, partyRoleEnum: PartyRoleEnum) -> RelatedParty:
    """
    Filters the list of RelatedParty based on the provided partyRoleEnum.
    
    Parameters 
    ----------
    relatedParties : RelatedParty
    
    partyRoleEnum : PartyRoleEnum
    
    Returns
    -------
    filteredRelatedParties : RelatedParty
    
    """
    self = inspect.currentframe()
    
    
    filteredRelatedParties = rosetta_filter(rosetta_resolve_attr(self, "relatedParties"), lambda item: all_elements(rosetta_resolve_attr(self, "role"), "=", rosetta_resolve_attr(self, "partyRoleEnum")))
    
    
    return filteredRelatedParties

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
