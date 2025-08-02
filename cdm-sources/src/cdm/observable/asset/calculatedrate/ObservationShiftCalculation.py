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

__all__ = ['ObservationShiftCalculation']


class ObservationShiftCalculation(BaseDataClass):
    """
    Parameters to describe the observation shift for a daily compounded or averaged floating rate. This type is used to represent modular computed rates in interestRatePayouts.
    """
    offsetDays: Optional[int] = Field(None, description="The number of days of observation shift.")
    """
    The number of days of observation shift.
    """
    calculationBase: Optional[cdm.observable.asset.calculatedrate.ObservationPeriodDatesEnum.ObservationPeriodDatesEnum] = Field(None, description="Whether the rate is calculated in advance, in arrears, or relative to a reset date.")
    """
    Whether the rate is calculated in advance, in arrears, or relative to a reset date.
    """
    additionalBusinessDays: Optional[cdm.base.datetime.BusinessCenters.BusinessCenters] = Field(None, description="Any additional business days that be applicable.")
    """
    Any additional business days that be applicable.
    """

import cdm 
import cdm.observable.asset.calculatedrate.ObservationPeriodDatesEnum
import cdm.base.datetime.BusinessCenters
