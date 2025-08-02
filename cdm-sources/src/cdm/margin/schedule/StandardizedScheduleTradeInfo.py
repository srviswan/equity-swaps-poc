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

__all__ = ['StandardizedScheduleTradeInfo']


class StandardizedScheduleTradeInfo(BaseDataClass):
    assetClass: Optional[cdm.margin.schedule.StandardizedScheduleAssetClassEnum.StandardizedScheduleAssetClassEnum] = Field(None, description="")
    productClass: Optional[cdm.margin.schedule.StandardizedScheduleProductClassEnum.StandardizedScheduleProductClassEnum] = Field(None, description="")
    grossInitialMargin: Optional[cdm.observable.asset.Money.Money] = Field(None, description="")
    markToMarketValue: Optional[cdm.observable.asset.Money.Money] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_PositiveGrossInitialMargin(self):
        """
        Ensure gross initial margin is greater than 0
        """
        item = self
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "grossInitialMargin"), "value"), ">", 0)
    
    @rosetta_condition
    def condition_1_SameCurrencies(self):
        """
        Ensure that only a single currency exists
        """
        item = self
        return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "grossInitialMargin"), "unit"), "currency"), "=", rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "markToMarketValue"), "unit"), "currency"))

import cdm 
import cdm.margin.schedule.StandardizedScheduleAssetClassEnum
import cdm.margin.schedule.StandardizedScheduleProductClassEnum
import cdm.observable.asset.Money
