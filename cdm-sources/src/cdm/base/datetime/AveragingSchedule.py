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

__all__ = ['AveragingSchedule']


class AveragingSchedule(BaseDataClass):
    """
    Class to representing a method for generating a series of dates.
    """
    startDate: datetime.date = Field(..., description="Date on which this period begins.")
    """
    Date on which this period begins.
    """
    endDate: datetime.date = Field(..., description="Date on which this period ends.")
    """
    Date on which this period ends.
    """
    averagingPeriodFrequency: cdm.base.datetime.CalculationPeriodFrequency.CalculationPeriodFrequency = Field(..., description="The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.")
    """
    The frequency at which averaging period occurs with the regular part of the valuation schedule and their roll date convention.
    """

import cdm 
import cdm.base.datetime.CalculationPeriodFrequency
