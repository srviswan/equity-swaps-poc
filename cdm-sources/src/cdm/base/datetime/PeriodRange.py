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

__all__ = ['PeriodRange']


class PeriodRange(BaseDataClass):
    """
    Indicates The period range defined as either a lower and upper period bound, or both.
    """
    lowerBound: Optional[cdm.base.datetime.PeriodBound.PeriodBound] = Field(None, description="Specifies the lower bound of a period range, e.g. greater than or equal to 5Y.")
    """
    Specifies the lower bound of a period range, e.g. greater than or equal to 5Y.
    """
    upperBound: Optional[cdm.base.datetime.PeriodBound.PeriodBound] = Field(None, description="Specifies the upper bound of a period range, e.g. less than to 10Y.")
    """
    Specifies the upper bound of a period range, e.g. less than to 10Y.
    """
    
    @rosetta_condition
    def condition_0_AtLeastOneOf(self):
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "lowerBound")) or rosetta_attr_exists(rosetta_resolve_attr(self, "upperBound")))

import cdm 
import cdm.base.datetime.PeriodBound
