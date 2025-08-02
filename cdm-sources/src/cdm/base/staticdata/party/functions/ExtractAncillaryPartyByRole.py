# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.AncillaryParty import AncillaryParty
from cdm.base.staticdata.party.AncillaryRoleEnum import AncillaryRoleEnum

__all__ = ['ExtractAncillaryPartyByRole']


@replaceable
def ExtractAncillaryPartyByRole(ancillaryParties: list[AncillaryParty], roleEnumToExtract: AncillaryRoleEnum) -> AncillaryParty:
    """
    Extracts from a list of AncillaryParty data types, the AncillaryParty that corresponds to the AncillaryRoleEnum.
    
    Parameters 
    ----------
    ancillaryParties : AncillaryParty
    The list of ancillary parties to filter.
    
    roleEnumToExtract : AncillaryRoleEnum
    The ancillary role enum to filter by.
    
    Returns
    -------
    ancillaryParty : AncillaryParty
    
    """
    self = inspect.currentframe()
    
    
    ancillaryParty =  (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(self, "ancillaryParties"), lambda item: all_elements(rosetta_resolve_attr(self, "role"), "=", rosetta_resolve_attr(self, "roleEnumToExtract"))))
    
    
    return ancillaryParty

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
