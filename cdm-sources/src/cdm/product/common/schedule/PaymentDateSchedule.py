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

__all__ = ['PaymentDateSchedule']


class PaymentDateSchedule(BaseDataClass):
    """
    The payment dates when specified as relative to a set of dates specified somewhere else in the instance document/transaction, e.g. the valuation dates as typically the case for equity swaps, or when specified as a calculation period schedule.
    """
    interimPaymentDates: List[cdm.base.datetime.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDates] = Field([], description="")
    finalPaymentDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="The last payment when specified as an adjustable or relative date, as in the FpML total return construct.")
    """
    The last payment when specified as an adjustable or relative date, as in the FpML total return construct.
    """

import cdm 
import cdm.base.datetime.AdjustableRelativeOrPeriodicDates
import cdm.base.datetime.AdjustableOrRelativeDate
