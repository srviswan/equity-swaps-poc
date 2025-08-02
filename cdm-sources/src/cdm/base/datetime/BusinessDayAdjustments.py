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

__all__ = ['BusinessDayAdjustments']


class BusinessDayAdjustments(BaseDataClass):
    """
    A class defining the business day convention and financial business centers used for adjusting any relevant date if it would otherwise fall on a day that is not a business day in the specified business center.
    """
    businessDayConvention: cdm.base.datetime.BusinessDayConventionEnum.BusinessDayConventionEnum = Field(..., description="The convention for adjusting a date if it would otherwise fall on a day that is not a business day.")
    """
    The convention for adjusting a date if it would otherwise fall on a day that is not a business day.
    """
    businessCenters: Optional[cdm.base.datetime.BusinessCenters.BusinessCenters] = Field(None, description="The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.")
    """
    The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
    """

import cdm 
import cdm.base.datetime.BusinessDayConventionEnum
import cdm.base.datetime.BusinessCenters
