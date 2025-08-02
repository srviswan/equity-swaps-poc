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

__all__ = ['TelephoneNumber']


class TelephoneNumber(BaseDataClass):
    """
    A class to specify a telephone number as a type of phone number (e.g. work, personal, ...) alongside with the actual number.
    """
    telephoneNumberType: Optional[cdm.base.staticdata.party.TelephoneTypeEnum.TelephoneTypeEnum] = Field(None, description="The type of telephone number, e.g. work, mobile.")
    """
    The type of telephone number, e.g. work, mobile.
    """
    number: str = Field(..., description="The actual telephone number.")
    """
    The actual telephone number.
    """

import cdm 
import cdm.base.staticdata.party.TelephoneTypeEnum
