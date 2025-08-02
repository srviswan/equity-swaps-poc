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

__all__ = ['BusinessDateRange']

from cdm.base.datetime.DateRange import DateRange

class BusinessDateRange(DateRange):
    """
    A class defining a range of contiguous business days by defining an unadjusted first date, an unadjusted last date and a business day convention and business centers for adjusting the first and last dates if they would otherwise fall on a non business day in the specified business centers. The days between the first and last date must also be good business days in the specified centers to be counted in the range.
    """
    businessDayConvention: cdm.base.datetime.BusinessDayConventionEnum.BusinessDayConventionEnum = Field(..., description="The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).")
    """
    The convention for adjusting a date if it would otherwise fall on a day that is not a business day, as specified by an ISDA convention (e.g. Following, Precedent).
    """
    businessCenters: Optional[cdm.base.datetime.BusinessCenters.BusinessCenters] = Field(None, description="The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.")
    """
    The business center(s), specified either explicitly or by reference to those specified somewhere else in the instance document.
    """

import cdm 
import cdm.base.datetime.BusinessDayConventionEnum
import cdm.base.datetime.BusinessCenters
