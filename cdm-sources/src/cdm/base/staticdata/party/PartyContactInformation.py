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

__all__ = ['PartyContactInformation']


class PartyContactInformation(BaseDataClass):
    """
    A class to specify contact information within a party: address and, optionally, associated business unit and person. This class also supports the ISDA CSA representation as a single string, through the address attribute.
    """
    partyReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="The reference to the party to which the contact information refers to.")
    """
    The reference to the party to which the contact information refers to.
    """
    contactInformation: Optional[cdm.base.staticdata.party.ContactInformation.ContactInformation] = Field(None, description="The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s), it should be associated with those.")
    """
    The postal/street address, telephone number, email address and/or web page. If the contact information is specific to the associated business unit(s), it should be associated with those.
    """
    businessUnit: List[cdm.base.staticdata.party.BusinessUnit.BusinessUnit] = Field([], description="Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).")
    """
    Optional organization unit information used to describe the organization units (e.g. trading desks) involved in a transaction or business process, incl. the contact information (when relevant).
    """
    person: List[cdm.base.staticdata.party.NaturalPerson.NaturalPerson] = Field([], description="Optional information about people involved in a transaction or business process. (These are employees of the party.)")
    """
    Optional information about people involved in a transaction or business process. (These are employees of the party.)
    """
    additionalInformation: Optional[str] = Field(None, description="Specification of special instructions of the relevant party.")
    """
    Specification of special instructions of the relevant party.
    """

import cdm 
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.ContactInformation
import cdm.base.staticdata.party.BusinessUnit
import cdm.base.staticdata.party.NaturalPerson
