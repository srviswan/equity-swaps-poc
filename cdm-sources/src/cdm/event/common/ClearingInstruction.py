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

__all__ = ['ClearingInstruction']


class ClearingInstruction(BaseDataClass):
    """
    All information required to perform the clear life cycle event; the clearing party (CCP), the two parties facing each other on the alpha contract, and optionally the parties acting as clearing members.
    """
    alphaContract: cdm.event.common.TradeState.TradeState = Field(..., description="The contract that will be submitted to the clearing house for clearing. The contract should indicate that it should be cleared by assigning a clearing organisation as a party role.")
    """
    The contract that will be submitted to the clearing house for clearing. The contract should indicate that it should be cleared by assigning a clearing organisation as a party role.
    """
    clearingParty: cdm.base.staticdata.party.Party.Party = Field(..., description="The Central Counter party (CCP) that the contract will be submitted to for clearing.")
    """
    The Central Counter party (CCP) that the contract will be submitted to for clearing.
    """
    party1: cdm.base.staticdata.party.Party.Party = Field(..., description="First party facing the CCP if it is clearing for its own account.")
    """
    First party facing the CCP if it is clearing for its own account.
    """
    party2: cdm.base.staticdata.party.Party.Party = Field(..., description="Second party facing the CCP if it is clearing for its own account.")
    """
    Second party facing the CCP if it is clearing for its own account.
    """
    clearerParty1: Optional[cdm.base.staticdata.party.Party.Party] = Field(None, description="Optional party facing the CCP, acting as clearing member for party1.")
    """
    Optional party facing the CCP, acting as clearing member for party1.
    """
    clearerParty2: Optional[cdm.base.staticdata.party.Party.Party] = Field(None, description="Optional party facing the CCP, acting as clearing member for party2.")
    """
    Optional party facing the CCP, acting as clearing member for party2.
    """
    isOpenOffer: Optional[bool] = Field(None, description="Open Offer")
    """
    Open Offer
    """

import cdm 
import cdm.event.common.TradeState
import cdm.base.staticdata.party.Party
