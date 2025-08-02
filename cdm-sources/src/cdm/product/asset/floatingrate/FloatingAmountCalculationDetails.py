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

__all__ = ['FloatingAmountCalculationDetails']


class FloatingAmountCalculationDetails(BaseDataClass):
    """
    Type for reporting the detailed results of calculating a cash flow for a calculation period.  This is enhanced relative to the FpML-based cashflows structure to allow more information to be returned about daily compounded rates.
    """
    calculationPeriod: cdm.product.common.schedule.CalculationPeriodBase.CalculationPeriodBase = Field(..., description="The calculation period for which the floating calculation was performed.")
    """
    The calculation period for which the floating calculation was performed.
    """
    calculationPeriodNotionalAmount: cdm.observable.asset.Money.Money = Field(..., description="The notional in effect during the calculation period.")
    """
    The notional in effect during the calculation period.
    """
    floatingRate: Optional[cdm.product.asset.floatingrate.FloatingRateSettingDetails.FloatingRateSettingDetails] = Field(None, description="The details of the floating rate setting. (If it is a calculated rate, details of that calculation will be inside that.")
    """
    The details of the floating rate setting.  (If it is a calculated rate, details of that calculation will be inside that.
    """
    processingDetails: Optional[cdm.product.asset.floatingrate.FloatingRateProcessingDetails.FloatingRateProcessingDetails] = Field(None, description="Details fo the floating rate treatment after the rate is observed or calculated. This will include details of things like multipliers, spreads, caps and floors, and the raw and treated rates.")
    """
    Details fo the floating rate treatment after the rate is observed or calculated.  This will include details of things like multipliers, spreads, caps and floors, and the raw and treated rates.
    """
    appliedRate: Decimal = Field(..., description="The rate that was actually applied, after all calculations and treatments.")
    """
    The rate that was actually applied, after all calculations and treatments.
    """
    yearFraction: Decimal = Field(..., description="The fraction of a year that this calculation represents, according to the day count fraction method.")
    """
    The fraction of a year that this calculation represents, according to the day count fraction method.
    """
    calculatedAmount: Decimal = Field(..., description="The amount of the cash flow that was computed, including any spreads and other processing.")
    """
    The amount of the cash flow that was computed, including any spreads and other processing.
    """
    spreadExclusiveCalculatedAMount: Decimal = Field(..., description="The amount of the cash flow excluding any spread, for subsequent processing.")
    """
    The amount of the cash flow excluding any spread, for subsequent processing.
    """

import cdm 
import cdm.product.common.schedule.CalculationPeriodBase
import cdm.observable.asset.Money
import cdm.product.asset.floatingrate.FloatingRateSettingDetails
import cdm.product.asset.floatingrate.FloatingRateProcessingDetails
