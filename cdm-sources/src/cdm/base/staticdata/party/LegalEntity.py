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

__all__ = ['LegalEntity']


class LegalEntity(BaseDataClass):
    """
    A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
    """
    entityId: List[AttributeWithMeta[str] | str] = Field([], description="A legal entity identifier (e.g. RED entity code).")
    """
    A legal entity identifier (e.g. RED entity code).
    """
    name: AttributeWithMeta[str] | str = Field(..., description="The legal entity name.")
    """
    The legal entity name.
    """

import cdm 
