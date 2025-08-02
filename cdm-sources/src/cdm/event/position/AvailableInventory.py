# pylint: disable=line-too-long, invalid-name, missing-function-docstring
# pylint: disable=bad-indentation, trailing-whitespace, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import
# pylint: disable=wildcard-import, wrong-import-order, missing-class-docstring
# pylint: disable=missing-module-docstring
from __future__ import annotations
from typing import List, Optional
import datetime
import inspect
from decimal import Decimal
from pydantic import Field
from rosetta.runtime.utils import (
    BaseDataClass, rosetta_condition, rosetta_resolve_attr
)
from rosetta.runtime.utils import *

__all__ = ['AvailableInventory']


class AvailableInventory(BaseDataClass):
    """
    A data type that can be used to describe the inventory of securities that a party holds. The securities are held in the AvailableInventoryRecord, with each item in the array being an individual security and its associated criteria. Criteria can include the quantity available, the rate at which the security is available to borrow at, as well as other details that can affect the decision as to whether a party wants to utilise the securities listed.
    """
    availableInventoryType: cdm.event.position.AvailableInventoryTypeEnum.AvailableInventoryTypeEnum = Field(..., description="Defines the purpose of this inventory.")
    """
    Defines the purpose of this inventory.
    """
    messageInformation: Optional[cdm.event.workflow.MessageInformation.MessageInformation] = Field(None, description="Allows details related to the availability messaging use case to be defined")
    """
    Allows details related to the availability messaging use case to be defined
    """
    party: List[cdm.base.staticdata.party.Party.Party] = Field([], description="Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.")
    """
    Defines all parties involved for the list of inventory records in this set of inventory. For example, when used to describe securities lending availability, this could hold the sender of the availability, the intended recipient, the beneficial owner(s), the lender (which may differ from the sender as the lender may have the same piece of availability going through multiple agents), an agent or a venue.
    """
    partyRole: List[cdm.base.staticdata.party.PartyRole.PartyRole] = Field([], description="Defines the role(s) that party(ies) may have in relation to the inventory.")
    """
    Defines the role(s) that party(ies) may have in relation to the inventory.
    """
    availableInventoryRecord: List[cdm.event.position.AvailableInventoryRecord.AvailableInventoryRecord] = Field([], description="An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.")
    """
    An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
    """
    
    @rosetta_condition
    def condition_0_ValidPartyRole(self):
        """
        Restrict roles to be only those that would be associated to the overall list of availability
        """
        item = self
        return IsValidPartyRole(rosetta_resolve_attr(self, "partyRole"), [rosetta_resolve_attr(PartyRoleEnum, "AGENT_LENDER"), rosetta_resolve_attr(PartyRoleEnum, "BENEFICIAL_OWNER"), rosetta_resolve_attr(PartyRoleEnum, "BORROWER"), rosetta_resolve_attr(PartyRoleEnum, "CUSTODIAN"), rosetta_resolve_attr(PartyRoleEnum, "LENDER")])

import cdm 
import cdm.event.position.AvailableInventoryTypeEnum
import cdm.event.workflow.MessageInformation
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.PartyRole
import cdm.event.position.AvailableInventoryRecord
from cdm.event.position.functions.IsValidPartyRole import IsValidPartyRole
from cdm.base.staticdata.party.PartyRoleEnum import PartyRoleEnum
