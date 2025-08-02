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

__all__ = ['AssetDeliveryProfile']


class AssetDeliveryProfile(BaseDataClass):
    """
    Defines the delivery profile of the asset, including the load type and the delivery intervals.
    """
    loadType: Optional[cdm.product.asset.LoadTypeEnum.LoadTypeEnum] = Field(None, description="Identification of the delivery profile.")
    """
    Identification of the delivery profile.
    """
    block: List[cdm.product.asset.AssetDeliveryProfileBlock.AssetDeliveryProfileBlock] = Field([], description="Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.")
    """
    Defines a delivery profile block, including start and end time, days of the week, duration, delivery capacity and price time interval quantity.
    """
    bankHolidaysTreatment: Optional[cdm.product.asset.BankHolidayTreatmentEnum.BankHolidayTreatmentEnum] = Field(None, description="Specifies whether the dates defined include holidays or not.")
    """
    Specifies whether the dates defined include holidays or not.
    """

import cdm 
import cdm.product.asset.LoadTypeEnum
import cdm.product.asset.AssetDeliveryProfileBlock
import cdm.product.asset.BankHolidayTreatmentEnum
