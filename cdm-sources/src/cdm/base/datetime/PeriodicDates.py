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

__all__ = ['PeriodicDates']


class PeriodicDates(BaseDataClass):
    """
    A class for specifying a calculation period schedule.
    """
    startDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.")
    """
    The start date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the effective date. It is always specified in the case of equity swaps and credit default swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
    """
    endDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="The end date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the termination date. It is always specified in the case of equity swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.")
    """
    The end date of the calculation period. FpML specifies that for interest rate swaps this date must only be specified if it is not equal to the termination date. It is always specified in the case of equity swaps with periodic payments. This date may be subject to adjustment in accordance with a business day convention.
    """
    periodFrequency: Optional[cdm.base.datetime.CalculationPeriodFrequency.CalculationPeriodFrequency] = Field(None, description="The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.")
    """
    The frequency at which calculation period end dates occur with the regular part of the calculation period schedule and their roll date convention.
    """
    periodDatesAdjustments: Optional[cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.")
    """
    The specification of the business day convention and financial business centers used for adjusting any calculation period date if it would otherwise fall on a day that is not a business day in the specified business center.
    """
    dayType: Optional[cdm.base.datetime.DayTypeEnum.DayTypeEnum] = Field(None, description="Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.")
    """
    Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
    """

import cdm 
import cdm.base.datetime.AdjustableOrRelativeDate
import cdm.base.datetime.CalculationPeriodFrequency
import cdm.base.datetime.BusinessDayAdjustments
import cdm.base.datetime.DayTypeEnum
