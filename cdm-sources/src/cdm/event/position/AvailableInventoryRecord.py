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

__all__ = ['AvailableInventoryRecord']

from cdm.event.position.InventoryRecord import InventoryRecord

class AvailableInventoryRecord(InventoryRecord):
    """
    An individual piece of available inventory. This represents a single security and its associated criteria. The criteria are used to describe any restrictions on the securities.
    """
    expirationDateTime: Optional[datetime.datetime] = Field(None, description="There may be a set period/time restriction associated to the security.")
    """
    There may be a set period/time restriction associated to the security.
    """
    collateral: List[cdm.product.collateral.CollateralProvisions.CollateralProvisions] = Field([], description="The type of collateral can often be required when determining if the piece of availability being described is suitable for a party.")
    """
    The type of collateral can often be required when determining if the piece of availability being described is suitable for a party.
    """
    partyRole: List[cdm.base.staticdata.party.PartyRole.PartyRole] = Field([], description="An individual security may be held by several agents. Including the party role at this level allows us to reference the party holding this specific item.")
    """
    An individual security may be held by several agents. Including the party role at this level allows us to reference the party holding this specific item.
    """
    quantity: Optional[cdm.base.math.Quantity.Quantity] = Field(None, description="The quantity of the security")
    """
    The quantity of the security
    """
    interestRate: Optional[cdm.observable.asset.Price.Price] = Field(None, description="An optional element which can be used to hold a rate associated to this piece of availability.")
    """
    An optional element which can be used to hold a rate associated to this piece of availability.
    """
    
    @rosetta_condition
    def condition_0_InterestRate(self):
        """
        Where an Interest Rate has been specified then the Price Type must be set to interest rate
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "interestRate"), "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "interestRate")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_ValidPartyRole(self):
        """
        Restrict roles to be only those that would be associated to an individual piece of availability
        """
        item = self
        return IsValidPartyRole(rosetta_resolve_attr(self, "partyRole"), [rosetta_resolve_attr(PartyRoleEnum, "AGENT_LENDER"), rosetta_resolve_attr(PartyRoleEnum, "BENEFICIAL_OWNER"), rosetta_resolve_attr(PartyRoleEnum, "CUSTODIAN"), rosetta_resolve_attr(PartyRoleEnum, "LENDER")])

import cdm 
import cdm.product.collateral.CollateralProvisions
import cdm.base.staticdata.party.PartyRole
import cdm.base.math.Quantity
import cdm.observable.asset.Price
from cdm.observable.asset.PriceTypeEnum import PriceTypeEnum
from cdm.event.position.functions.IsValidPartyRole import IsValidPartyRole
from cdm.base.staticdata.party.PartyRoleEnum import PartyRoleEnum
