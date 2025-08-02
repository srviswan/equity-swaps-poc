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

__all__ = ['CalculationPeriodBase']


class CalculationPeriodBase(BaseDataClass):
    """
    The calculation period adjusted start and end dates, which are the baseline arguments needed to compute an interest accrual calculation.
    """
    adjustedStartDate: Optional[datetime.date] = Field(None, description="The calculation period start date, adjusted according to any relevant business day convention.")
    """
    The calculation period start date, adjusted according to any relevant business day convention.
    """
    adjustedEndDate: Optional[datetime.date] = Field(None, description="The calculation period end date, adjusted according to any relevant business day convention.")
    """
    The calculation period end date, adjusted according to any relevant business day convention.
    """

import cdm 
