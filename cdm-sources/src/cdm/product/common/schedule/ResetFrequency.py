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

__all__ = ['ResetFrequency']

from cdm.base.datetime.Frequency import Frequency

class ResetFrequency(Frequency):
    """
    A class defining the reset frequency. In the case of a weekly reset, also specifies the day of the week that the reset occurs. If the reset frequency is greater than the calculation period frequency the this implies that more or more reset dates is established for each calculation period and some form of rate averaging is applicable. The specific averaging method of calculation is specified in FloatingRateCalculation. In case the reset frequency is of value T (term), the period is defined by the swap/swapStream/calculationPerioDates/effectiveDate and the swap/swapStream/calculationPerioDates/terminationDate.
    """
    weeklyRollConvention: Optional[cdm.product.common.schedule.WeeklyRollConventionEnum.WeeklyRollConventionEnum] = Field(None, description="The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.")
    """
    The day of the week on which a weekly reset date occurs. This element must be included if the reset frequency is defined as weekly and not otherwise.
    """
    
    @rosetta_condition
    def condition_0_FpML_ird_49(self):
        """
        FpML validation rule ird-49 - WeeklyRollConvention should exist if and only if the period is 'W'.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "period"), "=", rosetta_resolve_attr(PeriodExtendedEnum, "W"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "weeklyRollConvention")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.schedule.WeeklyRollConventionEnum
from cdm.base.datetime.PeriodExtendedEnum import PeriodExtendedEnum
