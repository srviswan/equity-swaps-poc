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

__all__ = ['CalculationFrequency']


class CalculationFrequency(BaseDataClass):
    """
    Represents the parameters for describing how often something (such as collateral interest) is to be calculated.
    """
    period: cdm.base.datetime.Period.Period = Field(..., description="Specifies the time period at which calculation is performed, e.g. 1 month.")
    """
    Specifies the time period at which calculation is performed, e.g. 1 month.
    """
    monthOfYear: Optional[Decimal] = Field(None, description="Specifies the month of the year if used.")
    """
    Specifies the month of the year if used.
    """
    dayOfMonth: Optional[Decimal] = Field(None, description="Specifies the day of the month if used.")
    """
    Specifies the day of the month if used.
    """
    dayOfWeek: Optional[cdm.base.datetime.DayOfWeekEnum.DayOfWeekEnum] = Field(None, description="Specifies the day of the week if used.")
    """
    Specifies the day of the week if used.
    """
    weekOfMonth: Optional[Decimal] = Field(None, description="Specifies the week of the month if used.")
    """
    Specifies the week of the month if used.
    """
    offsetDays: Decimal = Field(..., description="Specifies how many days from the trigger event should the payment occur.")
    """
    Specifies how many days from the trigger event should the payment occur.
    """
    dateLocation: cdm.base.datetime.BusinessCenterTime.BusinessCenterTime = Field(..., description="Specifies where is the time measured.")
    """
    Specifies where is the time measured.
    """
    businessCenter: List[cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum] = Field([], description="Specifies the business center for adjustment of calculation period.")
    """
    Specifies the business center for adjustment of calculation period.
    """
    
    @rosetta_condition
    def condition_0_Moy(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "monthOfYear"), "<=", 12)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "monthOfYear")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_Dom(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "dayOfMonth"), "<=", 31)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "dayOfMonth")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_Wom(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "weekOfMonth"), "<=", 5)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "weekOfMonth")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_MoyTerm(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "period"), "period"), "=", rosetta_resolve_attr(PeriodEnum, "Y"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "monthOfYear")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_DomTerm(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "period"), "period"), "=", rosetta_resolve_attr(PeriodEnum, "M"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "dayOfMonth")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_5_DowTerm(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "period"), "period"), "=", rosetta_resolve_attr(PeriodEnum, "W"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "dayOfWeek")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_6_WomTerm(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "period"), "period"), "=", rosetta_resolve_attr(PeriodEnum, "M"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "weekOfMonth")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.datetime.Period
import cdm.base.datetime.DayOfWeekEnum
import cdm.base.datetime.BusinessCenterTime
import cdm.base.datetime.BusinessCenterEnum
from cdm.base.datetime.PeriodEnum import PeriodEnum
