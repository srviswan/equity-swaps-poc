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

__all__ = ['Period']


class Period(BaseDataClass):
    """
    A class to define recurring periods or time offsets.
    """
    periodMultiplier: int = Field(..., description="A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.")
    """
    A time period multiplier, e.g. 1, 2 or 3 etc. A negative value can be used when specifying an offset relative to another date, e.g. -2 days.
    """
    period: cdm.base.datetime.PeriodEnum.PeriodEnum = Field(..., description="A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).")
    """
    A time period, e.g. a day, week, month or year of the stream. If the periodMultiplier value is 0 (zero) then period must contain the value D (day).
    """
    
    @rosetta_condition
    def condition_0_DayPeriod(self):
        """
        FpML specifies that if the periodMultiplier value is 0 (zero) then period must contain the value D (day).
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "period"), "=", rosetta_resolve_attr(PeriodEnum, "D"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "periodMultiplier"), "=", 0), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.PeriodEnum
from cdm.base.datetime.PeriodEnum import PeriodEnum
