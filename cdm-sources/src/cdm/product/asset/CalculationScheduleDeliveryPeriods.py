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

__all__ = ['CalculationScheduleDeliveryPeriods']

from cdm.product.asset.AssetDeliveryPeriods import AssetDeliveryPeriods

class CalculationScheduleDeliveryPeriods(AssetDeliveryPeriods):
    """
    Period and time profile over which the delivery takes place.
    """
    deliveryCapacity: Optional[cdm.base.math.Quantity.Quantity] = Field(None, description="The number of units included in the transaction for each delivery interval")
    """
    The number of units included in the transaction for each delivery interval
    """
    priceTimeIntervalQuantity: Optional[cdm.observable.asset.Price.Price] = Field(None, description="Price per quantity per delivery time interval.")
    """
    Price per quantity per delivery time interval.
    """

import cdm 
import cdm.base.math.Quantity
import cdm.observable.asset.Price
