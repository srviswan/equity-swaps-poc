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

__all__ = ['ExerciseEvent']


class ExerciseEvent(BaseDataClass):
    """
    A data defining:  the adjusted dates associated with a particular exercise event.
    """
    adjustedExerciseDate: datetime.date = Field(..., description="The date on which the option exercise takes place. This date should already be adjusted for any applicable business day convention.")
    """
    The date on which the option exercise takes place. This date should already be adjusted for any applicable business day convention.
    """
    adjustedRelevantSwapEffectiveDate: datetime.date = Field(..., description="The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.")
    """
    The effective date of the underlying swap associated with a given exercise date. This date should already be adjusted for any applicable business day convention.
    """
    adjustedCashSettlementValuationDate: Optional[datetime.date] = Field(None, description="The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.")
    """
    The date by which the cash settlement amount must be agreed. This date should already be adjusted for any applicable business day convention.
    """
    adjustedCashSettlementPaymentDate: Optional[datetime.date] = Field(None, description="The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business day convention.")
    """
    The date on which the cash settlement amount is paid. This date should already be adjusted for any applicable business day convention.
    """
    adjustedExerciseFeePaymentDate: Optional[datetime.date] = Field(None, description="The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.")
    """
    The date on which the exercise fee amount is paid. This date should already be adjusted for any applicable business day convention.
    """

import cdm 
