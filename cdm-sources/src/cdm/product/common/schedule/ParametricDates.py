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

__all__ = ['ParametricDates']


class ParametricDates(BaseDataClass):
    """
    Defines rules for the dates on which the price will be determined.
    """
    dayType: cdm.base.datetime.DayTypeEnum.DayTypeEnum = Field(..., description="Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.")
    """
    Denotes the enumerated values to specify the day type classification used in counting the number of days between two dates.
    """
    dayDistribution: Optional[cdm.product.asset.DayDistributionEnum.DayDistributionEnum] = Field(None, description="Denotes the method by which the pricing days are distributed across the pricing period.")
    """
    Denotes the method by which the pricing days are distributed across the pricing period.
    """
    dayOfWeek: List[cdm.base.datetime.DayOfWeekEnum.DayOfWeekEnum] = Field([], description="Indicates the days of the week on which the price will be determined.")
    """
    Indicates the days of the week on which the price will be determined.
    """
    @rosetta_condition
    def cardinality_dayOfWeek(self):
        return check_cardinality(self.dayOfWeek, 0, 7)
    
    dayFrequency: Optional[Decimal] = Field(None, description="Defines the occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.")
    """
    Defines the occurrence of the dayOfWeek within the pricing period on which pricing will take place, e.g. the 3rd Friday within each Calculation Period. If omitted, every dayOfWeek will be a pricing day.
    """
    lag: Optional[cdm.product.common.schedule.Lag.Lag] = Field(None, description="The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.")
    """
    The pricing period per calculation period if the pricing days do not wholly fall within the respective calculation period.
    """
    businessCenters: cdm.base.datetime.BusinessCenters.BusinessCenters = Field(..., description="The enumerated values to specify the business centers.")
    """
    The enumerated values to specify the business centers.
    """
    
    @rosetta_condition
    def condition_0_ParametricDatesChoice(self):
        item = self
        return self.check_one_of_constraint('dayDistribution', 'dayOfWeek', necessity=True)
    
    @rosetta_condition
    def condition_1_DayOfWeekMethod(self):
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "dayFrequency"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "dayOfWeek")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.DayTypeEnum
import cdm.product.asset.DayDistributionEnum
import cdm.base.datetime.DayOfWeekEnum
import cdm.product.common.schedule.Lag
import cdm.base.datetime.BusinessCenters
