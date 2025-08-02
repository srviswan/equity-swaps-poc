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

__all__ = ['AddressForNotices']


class AddressForNotices(BaseDataClass):
    """
    Specification of the address and other details for notices.
    """
    primaryNotices: cdm.product.collateral.ContactElection.ContactElection = Field(..., description="Specification of primary notice details")
    """
    Specification of primary notice details
    """
    additionalNotices: List[cdm.base.staticdata.party.PartyContactInformation.PartyContactInformation] = Field([], description="The optional specification of additional information when a party requires notices to be delivered to more than one address.")
    """
    The optional specification of additional information when a party requires notices to be delivered to more than one address.
    """

import cdm 
import cdm.product.collateral.ContactElection
import cdm.base.staticdata.party.PartyContactInformation
