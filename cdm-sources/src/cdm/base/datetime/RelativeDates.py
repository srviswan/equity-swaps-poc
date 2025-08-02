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

__all__ = ['RelativeDates']

from cdm.base.datetime.RelativeDateOffset import RelativeDateOffset

class RelativeDates(RelativeDateOffset):
    """
    A class describing a set of dates defined as relative to another set of dates.
    """
    periodSkip: Optional[int] = Field(None, description="The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.")
    """
    The number of periods in the referenced date schedule that are between each date in the relative date schedule. Thus a skip of 2 would mean that dates are relative to every second date in the referenced schedule. If present this should have a value greater than 1.
    """
    scheduleBounds: Optional[cdm.base.datetime.DateRange.DateRange] = Field(None, description="The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.")
    """
    The first and last dates of a schedule. This can be used to restrict the range of values in a reference series of dates.
    """
    
    @rosetta_condition
    def condition_0_PeriodSkipGreaterThanOne(self):
        """
        FpML specifies that, if present, the period skip should have a value greater than 1.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "periodSkip"), ">", 1)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "periodSkip")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.DateRange
