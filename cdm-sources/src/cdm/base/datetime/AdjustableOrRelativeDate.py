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

__all__ = ['AdjustableOrRelativeDate']


class AdjustableOrRelativeDate(BaseDataClass):
    """
    A class giving the choice between defining a date as an explicit date together with applicable adjustments or as relative to some other (anchor) date.
    """
    adjustableDate: Optional[cdm.base.datetime.AdjustableDate.AdjustableDate] = Field(None, description="A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.")
    """
    A date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
    """
    relativeDate: Optional[cdm.base.datetime.AdjustedRelativeDateOffset.AdjustedRelativeDateOffset] = Field(None, description="A date specified as some offset to another date (the anchor date).")
    """
    A date specified as some offset to another date (the anchor date).
    """
    
    @rosetta_condition
    def condition_0_AdjustableOrRelativeDateChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('adjustableDate', 'relativeDate', necessity=True)

import cdm 
import cdm.base.datetime.AdjustableDate
import cdm.base.datetime.AdjustedRelativeDateOffset
