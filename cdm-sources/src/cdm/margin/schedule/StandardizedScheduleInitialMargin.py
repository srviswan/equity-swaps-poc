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

__all__ = ['StandardizedScheduleInitialMargin']


class StandardizedScheduleInitialMargin(BaseDataClass):
    tradeInfo: List[cdm.margin.schedule.StandardizedScheduleTradeInfo.StandardizedScheduleTradeInfo] = Field([], description="")
    netInitialMargin: cdm.observable.asset.Money.Money = Field(..., description="")
    
    @rosetta_condition
    def condition_0_NonNegativeNetInitialMargin(self):
        """
        Ensure net initial margin is non-negative
        """
        item = self
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "netInitialMargin"), "value"), ">=", 0)

import cdm 
import cdm.margin.schedule.StandardizedScheduleTradeInfo
import cdm.observable.asset.Money
