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

__all__ = ['AssetDeliveryPeriods']


class AssetDeliveryPeriods(BaseDataClass):
    """
    Defines the periods of delivery, including the delivery profile.
    """
    profile: List[cdm.product.asset.AssetDeliveryProfile.AssetDeliveryProfile] = Field([], description="Defines the delivery profile of the asset, including the load type and the delivery intervals.")
    """
    Defines the delivery profile of the asset, including the load type and the delivery intervals.
    """
    startDate: Optional[datetime.date] = Field(None, description="Delivery start date")
    """
    Delivery start date
    """
    endDate: Optional[datetime.date] = Field(None, description="Delivery end date")
    """
    Delivery end date
    """

import cdm 
import cdm.product.asset.AssetDeliveryProfile
