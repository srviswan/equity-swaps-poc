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

__all__ = ['AdjustedRelativeDateOffset']

from cdm.base.datetime.RelativeDateOffset import RelativeDateOffset

class AdjustedRelativeDateOffset(RelativeDateOffset):
    """
    A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
    """
    relativeDateAdjustments: Optional[cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.")
    """
    The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
    """

import cdm 
import cdm.base.datetime.BusinessDayAdjustments
