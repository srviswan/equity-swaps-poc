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

__all__ = ['Offset']

from cdm.base.datetime.Period import Period

class Offset(Period):
    """
    A class defining an offset used in calculating a new date relative to a reference date, e.g. calendar days, business days, commodity Business days, etc.
    """
    dayType: Optional[cdm.base.datetime.DayTypeEnum.DayTypeEnum] = Field(None, description="In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.")
    """
    In the case of an offset specified as a number of days, this element defines whether consideration is given as to whether a day is a good business day or not. If a day type of business days is specified then non-business days are ignored when calculating the offset. The financial business centers to use for determination of business days are implied by the context in which this element is used. This element must only be included when the offset is specified as a number of days. If the offset is zero days then the dayType element should not be included.
    """
    
    @rosetta_condition
    def condition_0_DayType(self):
        """
        FpML specifies that the dayType must only be included when the offset is specified as a number of days, while should not be included if the offset is zero days.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "dayType")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((any_elements(rosetta_resolve_attr(self, "period"), "<>", rosetta_resolve_attr(PeriodEnum, "D")) or all_elements(rosetta_resolve_attr(self, "periodMultiplier"), "=", 0)), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.DayTypeEnum
from cdm.base.datetime.PeriodEnum import PeriodEnum
