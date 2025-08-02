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

__all__ = ['MoneyRange']


class MoneyRange(BaseDataClass):
    """
    The money range defined as either a lower and upper money bound, or both.
    """
    lowerBound: Optional[cdm.base.math.MoneyBound.MoneyBound] = Field(None, description="The lower bound of a money range, e.g. greater than or equal to 1,000 USD.")
    """
    The lower bound of a money range, e.g. greater than or equal to 1,000 USD.
    """
    upperBound: Optional[cdm.base.math.MoneyBound.MoneyBound] = Field(None, description="The upper bound of a money range, e.g. less than 10,000 USD.")
    """
    The upper bound of a money range, e.g. less than 10,000 USD.
    """
    
    @rosetta_condition
    def condition_0_AtLeastOneOf(self):
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "lowerBound")) or rosetta_attr_exists(rosetta_resolve_attr(self, "upperBound")))

import cdm 
import cdm.base.math.MoneyBound
