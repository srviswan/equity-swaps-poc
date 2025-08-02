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

__all__ = ['InventoryRecord']


class InventoryRecord(BaseDataClass):
    """
    An individual piece of inventory. This represents a single security.
    """
    identifer: cdm.base.staticdata.identifier.AssignedIdentifier.AssignedIdentifier = Field(..., description="Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.")
    """
    Unique identifier for this record. This can be used to uniquely identify a specific piece of inventory.
    """
    security: cdm.base.staticdata.asset.common.Security.Security = Field(..., description="The security details.")
    """
    The security details.
    """

import cdm 
import cdm.base.staticdata.identifier.AssignedIdentifier
import cdm.base.staticdata.asset.common.Security
