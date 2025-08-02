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

__all__ = ['BusinessCenterTime']


class BusinessCenterTime(BaseDataClass):
    """
    A class for defining a time with respect to a business day calendar location. For example, 11:00:00 GBLO.
    """
    hourMinuteTime: datetime.time = Field(..., description="A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.")
    """
    A time specified in hh:mm:ss format where the second component must be '00', e.g. 11am would be represented as 11:00:00.
    """
    businessCenter: AttributeWithMeta[cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum] | cdm.base.datetime.BusinessCenterEnum.BusinessCenterEnum = Field(..., description="A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location enumeration.")
    """
    A code identifying a business day calendar location. A business day calendar location is drawn from the list identified by the business day calendar location enumeration.
    """

import cdm 
import cdm.base.datetime.BusinessCenterEnum
