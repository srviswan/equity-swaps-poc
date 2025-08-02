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

__all__ = ['SpreadSchedule']

from cdm.product.common.schedule.RateSchedule import RateSchedule

class SpreadSchedule(RateSchedule):
    """
    Adds an optional spread type element to the Schedule to identify a long or short spread value.
    """
    spreadScheduleType: Optional[AttributeWithMeta[cdm.product.asset.SpreadScheduleTypeEnum.SpreadScheduleTypeEnum] | cdm.product.asset.SpreadScheduleTypeEnum.SpreadScheduleTypeEnum] = Field(None, description="An element which purpose is to identify a long or short spread value.")
    """
    An element which purpose is to identify a long or short spread value.
    """

import cdm 
import cdm.product.asset.SpreadScheduleTypeEnum
