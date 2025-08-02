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

__all__ = ['PartyChangeInstruction']


class PartyChangeInstruction(BaseDataClass):
    """
    Specifies instruction to change the party on a trade. This primitive instruction is used in a number of scenarios including: clearing, allocation and novation. The instrution must include a trade identifier, because a change of party effectively results in a different trade.
    """
    counterparty: cdm.base.staticdata.party.Counterparty.Counterparty = Field(..., description="The new counterparty who is stepping into the trade. The stepping out counterparty is inferred based on the counterparty role that is being updated.")
    """
    The new counterparty who is stepping into the trade. The stepping out counterparty is inferred based on the counterparty role that is being updated.
    """
    ancillaryParty: Optional[cdm.base.staticdata.party.AncillaryParty.AncillaryParty] = Field(None, description="Specifies an ancillary party to be added onto the new transaction, e.g. the original executing party in an allocation.")
    """
    Specifies an ancillary party to be added onto the new transaction, e.g. the original executing party in an allocation.
    """
    partyRole: Optional[cdm.base.staticdata.party.PartyRole.PartyRole] = Field(None, description="Specifies an additional party roles to be added on to the new transaction.")
    """
    Specifies an additional party roles to be added on to the new transaction.
    """
    tradeId: List[cdm.event.common.TradeIdentifier.TradeIdentifier] = Field([], description="The identifier to be assigned to the new trade post change of party.")
    """
    The identifier to be assigned to the new trade post change of party.
    """
    @rosetta_condition
    def cardinality_tradeId(self):
        return check_cardinality(self.tradeId, 1, None)
    

import cdm 
import cdm.base.staticdata.party.Counterparty
import cdm.base.staticdata.party.AncillaryParty
import cdm.base.staticdata.party.PartyRole
import cdm.event.common.TradeIdentifier
