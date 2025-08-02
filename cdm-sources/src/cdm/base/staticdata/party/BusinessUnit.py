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

__all__ = ['BusinessUnit']


class BusinessUnit(BaseDataClass):
    """
    A class to specify an organizational unit.
    """
    name: str = Field(..., description="A name used to describe the organizational unit")
    """
    A name used to describe the organizational unit
    """
    identifier: Optional[cdm.base.staticdata.identifier.Identifier.Identifier] = Field(None, description="An identifier used to uniquely identify the organizational unit")
    """
    An identifier used to uniquely identify the organizational unit
    """
    contactInformation: Optional[cdm.base.staticdata.party.ContactInformation.ContactInformation] = Field(None, description="The contact information for such business unit, when different from the contact information associated with the party.")
    """
    The contact information for such business unit, when different from the contact information associated with the party.
    """

import cdm 
import cdm.base.staticdata.identifier.Identifier
import cdm.base.staticdata.party.ContactInformation
