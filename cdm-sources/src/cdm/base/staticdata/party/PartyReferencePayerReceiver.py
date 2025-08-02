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

__all__ = ['PartyReferencePayerReceiver']


class PartyReferencePayerReceiver(BaseDataClass):
    """
    Specifies the parties responsible for making and receiving payments defined by this structure.
    """
    payerPartyReference: AttributeWithReference | cdm.base.staticdata.party.Party.Party = Field(..., description="The party responsible for making the payments defined by this structure.")
    """
    The party responsible for making the payments defined by this structure.
    """
    payerAccountReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Account.Account] = Field(None, description="A reference to the account responsible for making the payments defined by this structure.")
    """
    A reference to the account responsible for making the payments defined by this structure.
    """
    receiverPartyReference: AttributeWithReference | cdm.base.staticdata.party.Party.Party = Field(..., description="The party that receives the payments corresponding to this structure.")
    """
    The party that receives the payments corresponding to this structure.
    """
    receiverAccountReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Account.Account] = Field(None, description="A reference to the account that receives the payments corresponding to this structure.")
    """
    A reference to the account that receives the payments corresponding to this structure.
    """

import cdm 
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.Account
