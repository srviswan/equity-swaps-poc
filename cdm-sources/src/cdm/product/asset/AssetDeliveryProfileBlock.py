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

__all__ = ['AssetDeliveryProfileBlock']


class AssetDeliveryProfileBlock(BaseDataClass):
    """
    Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
    """
    startTime: Optional[datetime.time] = Field(None, description="The start time of the delivery interval for each block or shape.")
    """
    The start time of the delivery interval for each block or shape.
    """
    endTime: Optional[datetime.time] = Field(None, description="The end time of the delivery interval for each block or shape.")
    """
    The end time of the delivery interval for each block or shape.
    """
    dayOfWeek: List[cdm.base.datetime.DayOfWeekEnum.DayOfWeekEnum] = Field([], description="The days of the week of the delivery.")
    """
    The days of the week of the delivery.
    """
    @rosetta_condition
    def cardinality_dayOfWeek(self):
        return check_cardinality(self.dayOfWeek, 0, 7)
    
    deliveryCapacity: Optional[cdm.base.math.Quantity.Quantity] = Field(None, description="The number of units included in the transaction for each delivery interval")
    """
    The number of units included in the transaction for each delivery interval
    """
    priceTimeIntervalQuantity: Optional[cdm.observable.asset.Price.Price] = Field(None, description="Price per quantity per delivery time interval.")
    """
    Price per quantity per delivery time interval.
    """

import cdm 
import cdm.base.datetime.DayOfWeekEnum
import cdm.base.math.Quantity
import cdm.observable.asset.Price
