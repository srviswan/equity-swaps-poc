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

__all__ = ['NumberRange']


class NumberRange(BaseDataClass):
    """
    The number range defined as either a lower and upper number bound, or both.
    """
    lowerBound: Optional[cdm.base.math.NumberBound.NumberBound] = Field(None, description="The lower bound of a number range, e.g. greater than or equal to 5.")
    """
    The lower bound of a number range, e.g. greater than or equal to 5.
    """
    upperBound: Optional[cdm.base.math.NumberBound.NumberBound] = Field(None, description="The upper bound of a number range, e.g. less than 10.")
    """
    The upper bound of a number range, e.g. less than 10.
    """
    
    @rosetta_condition
    def condition_0_AtLeastOneOf(self):
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "lowerBound")) or rosetta_attr_exists(rosetta_resolve_attr(self, "upperBound")))

import cdm 
import cdm.base.math.NumberBound
