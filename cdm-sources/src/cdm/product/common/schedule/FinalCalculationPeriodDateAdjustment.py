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

__all__ = ['FinalCalculationPeriodDateAdjustment']


class FinalCalculationPeriodDateAdjustment(BaseDataClass):
    """
    A data to:  define business date convention adjustment to final payment period per leg.
    """
    relevantUnderlyingDateReference: AttributeWithReference | cdm.base.datetime.AdjustableOrRelativeDates.AdjustableOrRelativeDates = Field(..., description="Reference to the unadjusted cancellation effective dates.")
    """
    Reference to the unadjusted cancellation effective dates.
    """
    swapStreamReference: AttributeWithReference | cdm.product.asset.InterestRatePayout.InterestRatePayout = Field(..., description="Reference to the leg, where date adjustments may apply.")
    """
    Reference to the leg, where date adjustments may apply.
    """
    businessDayConvention: cdm.base.datetime.BusinessDayConventionEnum.BusinessDayConventionEnum = Field(..., description="Override business date convention. This takes precedence over leg level information.")
    """
    Override business date convention. This takes precedence over leg level information.
    """

import cdm 
import cdm.base.datetime.AdjustableOrRelativeDates
import cdm.product.asset.InterestRatePayout
import cdm.base.datetime.BusinessDayConventionEnum
