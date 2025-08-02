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

__all__ = ['MeasureSchedule']

from cdm.base.math.MeasureBase import MeasureBase

class MeasureSchedule(MeasureBase):
    """
    A set of measures, all in the same unit, where the values are defined through a schedule of steps. The initial value may be defined either as part of the steps, or using the single amount attribute.
    """
    datedValue: List[cdm.base.math.DatedValue.DatedValue] = Field([], description="A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.")
    """
    A schedule of step date and value pairs. On each step date the associated step value becomes effective. The step dates are used to order the steps by ascending order. This attribute is optional so the data type may be used to define a schedule with a single value.
    """
    
    @rosetta_condition
    def condition_0_ValueExists(self):
        """
        A schedule may be specified as a single value or as a set of date-value pairs. Both attributes may be specified, in which case the single amount number is the initial value.
        """
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "value")) or rosetta_attr_exists(rosetta_resolve_attr(self, "datedValue")))

import cdm 
import cdm.base.math.DatedValue
