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

__all__ = ['FixedAmountCalculationDetails']


class FixedAmountCalculationDetails(BaseDataClass):
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
    fixedRate: Decimal = Field(..., description="The value of the fixed rate that was used.")
    """
    The value of the fixed rate that was used.
    """
    yearFraction: Decimal = Field(..., description="The fraction of a year that this calculation represents, according to the day count fraction method.")
    """
    The fraction of a year that this calculation represents, according to the day count fraction method.
    """
    calculatedAmount: Decimal = Field(..., description="The amount of the cash flow that was computed, including any spreads and other processing.")
    """
    The amount of the cash flow that was computed, including any spreads and other processing.
    """

import cdm 
import cdm.product.common.schedule.CalculationPeriodBase
import cdm.observable.asset.Money
