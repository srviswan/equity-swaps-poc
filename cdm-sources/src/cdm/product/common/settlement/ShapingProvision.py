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

__all__ = ['ShapingProvision']


class ShapingProvision(BaseDataClass):
    """
    Defines the applicable settlement limits that may require a settlement to be 'shaped', i.e. broken-down into smaller amounts.
    """
    shapeSchedule: List[cdm.observable.asset.Money.Money] = Field([], description="Defines applicable settlement limits in each currency.")
    """
    Defines applicable settlement limits in each currency.
    """
    @rosetta_condition
    def cardinality_shapeSchedule(self):
        return check_cardinality(self.shapeSchedule, 1, None)
    

import cdm 
import cdm.observable.asset.Money
