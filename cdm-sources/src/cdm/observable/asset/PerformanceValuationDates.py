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

__all__ = ['PerformanceValuationDates']


class PerformanceValuationDates(BaseDataClass):
    """
    Defines how and when a performance type option or performance type swap is to be valued.
    """
    determinationMethod: cdm.observable.common.DeterminationMethodEnum.DeterminationMethodEnum = Field(..., description="Specifies the method according to which an amount or a date is determined.")
    """
    Specifies the method according to which an amount or a date is determined.
    """
    valuationDates: Optional[cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDates] = Field(None, description="2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date")
    """
    2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
    """
    valuationDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date")
    """
    2018 ISDA CDM Equity Confirmation for Security Equity Swap: Pricing Date
    """
    valuationTime: Optional[cdm.base.datetime.BusinessCenterTime.BusinessCenterTime] = Field(None, description="The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.")
    """
    The specific time of day at which the calculation agent values the underlying. The SpecificTime is the only case when the valuationTime (time + business center location  e.g. 10:00:00 USNY) should be provided. You should be able to provide just the valuationTime without valuationTimeType, which infer that this is a specific time.
    """
    valuationTimeType: Optional[cdm.observable.common.TimeTypeEnum.TimeTypeEnum] = Field(None, description="The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.")
    """
    The time of day at which the calculation agent values the underlying, for example the official closing time of the exchange.
    """

import cdm 
import cdm.observable.common.DeterminationMethodEnum
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates
import cdm.base.datetime.AdjustableOrRelativeDate
import cdm.base.datetime.BusinessCenterTime
import cdm.observable.common.TimeTypeEnum
