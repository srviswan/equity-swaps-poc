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

__all__ = ['Inventory']


class Inventory(BaseDataClass):
    """
    A data type that can be used to describe an inventory of securities.
    """
    inventoryRecord: List[cdm.event.position.InventoryRecord.InventoryRecord] = Field([], description="An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.")
    """
    An array holding the list of inventory being described. Each element in the inventoryRecord array represents an individual piece of inventory i.e. a security.
    """

import cdm 
import cdm.event.position.InventoryRecord
