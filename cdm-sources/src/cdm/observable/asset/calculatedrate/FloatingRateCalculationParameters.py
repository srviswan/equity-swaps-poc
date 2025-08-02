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

__all__ = ['FloatingRateCalculationParameters']


class FloatingRateCalculationParameters(BaseDataClass):
    """
    Defines the structures needed to represent the calculation parameters for daily averaged and compounded modular rates as defined in the 2021 ISDA Definitions in Section 7. This type is used to represent modular computed rates in interestRatePayouts.
    """
    calculationMethod: cdm.observable.asset.calculatedrate.CalculationMethodEnum.CalculationMethodEnum = Field(..., description="calculation type (averaging or compounding).")
    """
    calculation type (averaging or compounding).
    """
    observationShiftCalculation: Optional[cdm.observable.asset.calculatedrate.ObservationShiftCalculation.ObservationShiftCalculation] = Field(None, description="any obervation shift parameters if applicable.")
    """
    any obervation shift parameters if applicable.
    """
    lookbackCalculation: Optional[cdm.observable.asset.calculatedrate.OffsetCalculation.OffsetCalculation] = Field(None, description="any lookback parameters if applicable.")
    """
    any lookback  parameters if applicable.
    """
    lockoutCalculation: Optional[cdm.observable.asset.calculatedrate.OffsetCalculation.OffsetCalculation] = Field(None, description="any lockout parameters if applicable.")
    """
    any lockout  parameters if applicable.
    """
    applicableBusinessDays: Optional[cdm.base.datetime.BusinessCenters.BusinessCenters] = Field(None, description="the business days that are applicable for the calculation.")
    """
    the business days that are applicable for the calculation.
    """
    observationParameters: Optional[cdm.observable.asset.calculatedrate.ObservationParameters.ObservationParameters] = Field(None, description=" any applicable observation parameters, such as daily caps or floors.")
    """
     any applicable observation parameters, such as daily caps or floors.
    """

import cdm 
import cdm.observable.asset.calculatedrate.CalculationMethodEnum
import cdm.observable.asset.calculatedrate.ObservationShiftCalculation
import cdm.observable.asset.calculatedrate.OffsetCalculation
import cdm.base.datetime.BusinessCenters
import cdm.observable.asset.calculatedrate.ObservationParameters
