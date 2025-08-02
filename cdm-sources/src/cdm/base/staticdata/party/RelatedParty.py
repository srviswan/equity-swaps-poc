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

__all__ = ['RelatedParty']


class RelatedParty(BaseDataClass):
    partyReference: AttributeWithReference | cdm.base.staticdata.party.Party.Party = Field(..., description="Reference to a party.")
    """
    Reference to a party.
    """
    accountReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Account.Account] = Field(None, description="Reference to an account.")
    """
    Reference to an account.
    """
    role: cdm.base.staticdata.party.PartyRoleEnum.PartyRoleEnum = Field(..., description="The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is ,Guarantor, the related party acts as a guarantor for the base party.")
    """
    The category of the relationship. The related party performs the role specified in this field for the base party. For example, if the role is ,Guarantor, the related party acts as a guarantor for the base party.
    """

import cdm 
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.Account
import cdm.base.staticdata.party.PartyRoleEnum
