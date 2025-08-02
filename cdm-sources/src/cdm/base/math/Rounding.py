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

__all__ = ['Rounding']


class Rounding(BaseDataClass):
    """
    Defines rounding rules and precision to be used in the rounding of a number.
    """
    roundingDirection: cdm.base.math.RoundingDirectionEnum.RoundingDirectionEnum = Field(..., description="Specifies the rounding rounding rule as up, down, or nearest.")
    """
    Specifies the rounding rounding rule as up, down, or nearest.
    """
    precision: Optional[int] = Field(None, description="Specifies the rounding precision in terms of a number of decimal places when the number is evaluated in decimal form (not percentage), e.g. 0.09876543 rounded to the nearest 5 decimal places is 0.0987654.")
    """
    Specifies the rounding precision in terms of a number of decimal places when the number is evaluated in decimal form (not percentage), e.g. 0.09876543 rounded to the nearest 5 decimal places is  0.0987654.
    """

import cdm 
import cdm.base.math.RoundingDirectionEnum
