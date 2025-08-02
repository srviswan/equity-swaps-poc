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

__all__ = ['MarginCallExposure']

from cdm.event.common.MarginCallBase import MarginCallBase

class MarginCallExposure(MarginCallBase):
    """
    Represents attributes required for mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
    """
    overallExposure: cdm.event.common.Exposure.Exposure = Field(..., description="Represents the whole overall mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).")
    """
    Represents the whole overall mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
    """
    simmIMExposure: Optional[cdm.event.common.Exposure.Exposure] = Field(None, description="Represents Initial Margin (IM) exposure derived from ISDA SIMM calculation.")
    """
    Represents Initial Margin (IM) exposure derived from ISDA SIMM calculation.
    """
    scheduleGridIMExposure: Optional[cdm.event.common.Exposure.Exposure] = Field(None, description="Represents Initial Margin (IM) exposure derived from schedule or Grid calculation.")
    """
    Represents Initial Margin (IM) exposure derived from schedule or Grid calculation.
    """
    
    @rosetta_condition
    def condition_0_OverallExposureSumOfSimmAndScheduleIM(self):
        """
        Represents a condition to ensure that if Simm IM exposure and Schedule/Grid IM exposure are specified the sum value must equate to overall exposure amount.
        """
        item = self
        def _then_fn0():
            return ((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "overallExposure"), "aggregateValue"), "value"), "=", (rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "simmIMExposure"), "aggregateValue"), "value") + rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "scheduleGridIMExposure"), "aggregateValue"), "value"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "overallExposure"), "aggregateValue"), "unit"), "currency"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "simmIMExposure"), "aggregateValue"), "unit"), "currency"))) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "overallExposure"), "aggregateValue"), "unit"), "currency"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "scheduleGridIMExposure"), "aggregateValue"), "unit"), "currency")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "simmIMExposure")) and rosetta_attr_exists(rosetta_resolve_attr(self, "scheduleGridIMExposure"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_ExposureSimmAndScheduleIMOnly(self):
        """
        Specifies a condition to ensure that if margin exposure is defined as Simm IM and Schedule/Grid IM Exposure this is only applicable if the Reg margin type is defined as RegIM (Regulatory Initial Margin).
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "regMarginType"), "=", rosetta_resolve_attr(RegMarginTypeEnum, "REG_IM"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "simmIMExposure")) and rosetta_attr_exists(rosetta_resolve_attr(self, "scheduleGridIMExposure"))), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.Exposure
from cdm.event.common.RegMarginTypeEnum import RegMarginTypeEnum
