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

__all__ = ['DateRange']


class DateRange(BaseDataClass):
    """
    A class defining a contiguous series of calendar dates. The date range is defined as all the dates between and including the start and the end date. The start date must fall on or before the end date.
    """
    startDate: datetime.date = Field(..., description="The first date of a date range.")
    """
    The first date of a date range.
    """
    endDate: datetime.date = Field(..., description="The last date of a date range.")
    """
    The last date of a date range.
    """
    
    @rosetta_condition
    def condition_0_DatesOrdered(self):
        """
        The start date must fall on or before the end date (a date range of only one date is allowed).
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "startDate"), "<=", rosetta_resolve_attr(self, "endDate"))

import cdm 
