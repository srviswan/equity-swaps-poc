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

__all__ = ['StandardizedSchedule']


class StandardizedSchedule(BaseDataClass):
    assetClass: cdm.margin.schedule.StandardizedScheduleAssetClassEnum.StandardizedScheduleAssetClassEnum = Field(..., description="")
    productClass: cdm.margin.schedule.StandardizedScheduleProductClassEnum.StandardizedScheduleProductClassEnum = Field(..., description="")
    notional: Decimal = Field(..., description="")
    notionalCurrency: str = Field(..., description="")
    durationInYears: Optional[Decimal] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_PositiveNotional(self):
        """
        Ensure notional is greater than 0
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "notional"), ">", 0)
    
    @rosetta_condition
    def condition_1_ValidCurrency(self):
        """
        Ensure Currency is an ISO 3-Letter Currency Code
        """
        item = self
        return rosetta_attr_exists(ISOCurrencyCodeEnum(rosetta_resolve_attr(self, "notionalCurrency")))
    
    @rosetta_condition
    def condition_2_PositiveDuration(self):
        """
        Ensure duration is greater than 0.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "durationInYears"), ">", 0)

import cdm 
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum
import cdm.margin.schedule.StandardizedScheduleProductClassEnum
