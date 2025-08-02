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

__all__ = ['AssetDeliveryInformation']


class AssetDeliveryInformation(BaseDataClass):
    """
    Contains the information relative to the delivery of the asset.
    """
    periods: Optional[cdm.product.asset.AssetDeliveryPeriods.AssetDeliveryPeriods] = Field(None, description="Defines the periods of delivery, including the delivery profile.")
    """
    Defines the periods of delivery, including the delivery profile.
    """
    location: List[cdm.base.staticdata.identifier.LocationIdentifier.LocationIdentifier] = Field([], description="Defines the location of the delivery of the commodity.")
    """
    Defines the location of the delivery of the commodity.
    """
    deliveryCapacity: Optional[cdm.base.math.Quantity.Quantity] = Field(None, description="The number of units included in the transaction for each delivery interval")
    """
    The number of units included in the transaction for each delivery interval
    """

import cdm 
import cdm.product.asset.AssetDeliveryPeriods
import cdm.base.staticdata.identifier.LocationIdentifier
import cdm.base.math.Quantity
