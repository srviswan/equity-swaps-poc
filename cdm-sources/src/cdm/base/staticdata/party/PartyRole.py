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

__all__ = ['PartyRole']


class PartyRole(BaseDataClass):
    """
    A class to specify the role(s) that party(ies) may have in relation to the execution, contract or other legal agreement.
    """
    partyReference: AttributeWithReference | cdm.base.staticdata.party.Party.Party = Field(..., description="A reference to the party to which the role refers to.")
    """
    A reference to the party to which the role refers to.
    """
    role: cdm.base.staticdata.party.PartyRoleEnum.PartyRoleEnum = Field(..., description="The party role.")
    """
    The party role.
    """
    ownershipPartyReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="A reference to the party that has ownership of this party role information. FpML specifies that For shared trade information, this attribute will reference the originator of the data (for example, an execution facility or clearing house).")
    """
    A reference to the party that has ownership of this party role information. FpML specifies that For shared trade information, this attribute will reference the originator of the data (for example, an execution facility or clearing house).
    """

import cdm 
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.PartyRoleEnum
