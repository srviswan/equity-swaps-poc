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

__all__ = ['FallbackRateParameters']


class FallbackRateParameters(BaseDataClass):
    """
    Defines the structure needed to represent fallback rate parameters. This type is used to represent modular computed rates in interestRatePayouts.
    """
    floatingRateIndex: cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum = Field(..., description="The floating rate index that is used as the basis of the fallback rate.")
    """
    The floating rate index that is used as the basis of the fallback rate.
    """
    effectiveDate: Optional[datetime.date] = Field(None, description="The date the fallback rate takes effect.")
    """
    The date the fallback rate takes effect.
    """
    calculationParameters: Optional[cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters.FloatingRateCalculationParameters] = Field(None, description="Support for modular calculated rates, such such as lockout compound calculations.")
    """
    Support for modular calculated rates, such such as lockout compound calculations.
    """
    spreadAdjustment: Optional[Decimal] = Field(None, description="The economic spread applied to the underlying fallback rate to replicate the original risky rate.")
    """
    The economic spread applied to the underlying fallback rate to replicate the original risky rate.
    """

import cdm 
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters
