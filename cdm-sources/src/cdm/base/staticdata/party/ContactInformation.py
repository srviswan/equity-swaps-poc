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

__all__ = ['ContactInformation']


class ContactInformation(BaseDataClass):
    """
    A class to specify contact information associated with a party: telephone, postal/street address, email and web page.
    """
    telephone: List[cdm.base.staticdata.party.TelephoneNumber.TelephoneNumber] = Field([], description="The telephone number.")
    """
    The telephone number.
    """
    address: List[cdm.base.staticdata.party.Address.Address] = Field([], description="The street/postal address.")
    """
    The street/postal address.
    """
    email: List[str] = Field([], description="The email address.")
    """
    The email address.
    """
    webPage: List[str] = Field([], description="The web page. This attribute is not specified as part of the FpML ContactInformation complex type.")
    """
    The web page. This attribute is not specified as part of the FpML ContactInformation complex type.
    """

import cdm 
import cdm.base.staticdata.party.TelephoneNumber
import cdm.base.staticdata.party.Address
