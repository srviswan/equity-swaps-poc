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

__all__ = ['UmbrellaAgreementEntity']

from cdm.base.staticdata.party.LegalEntity import LegalEntity

class UmbrellaAgreementEntity(LegalEntity):
    """
    A class to specify the legal entities that are part of the umbrella agreement.
    """
    terms: Optional[str] = Field(None, description="The terms that might be associated with each party to the umbrella agreement.")
    """
    The terms that might be associated with each party to the umbrella agreement.
    """

import cdm 
