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

__all__ = ['FloatingRateProcessingParameters']


class FloatingRateProcessingParameters(BaseDataClass):
    """
    Type to hold the processing parameters that should be or were used to calculate a floating amount.  These parameters can vary over a schedule so this type holds the acutal values applicable to this calculation.
    """
    initialRate: Optional[cdm.observable.asset.Price.Price] = Field(None, description="The rate to be applied for the initial period.")
    """
    The rate to be applied for the initial period.
    """
    multiplier: Optional[Decimal] = Field(None, description="floating rate multiplier.")
    """
    floating rate multiplier.
    """
    spread: Optional[Decimal] = Field(None, description="spread to be added to the floating rate.")
    """
    spread to be added to the floating rate.
    """
    treatment: Optional[cdm.product.asset.RateTreatmentEnum.RateTreatmentEnum] = Field(None, description="US rate treatment (Bond Equivalent Yield or Money Market Yield, if applicable.")
    """
    US rate treatment (Bond Equivalent Yield or Money Market Yield, if applicable.
    """
    capRate: Optional[Decimal] = Field(None, description="capt to be applied to the floating rate.")
    """
    capt to be applied to the floating rate.
    """
    floorRate: Optional[Decimal] = Field(None, description="floor to be applied to the floating rate.")
    """
    floor to be applied to the floating rate.
    """
    rounding: Optional[cdm.base.math.Rounding.Rounding] = Field(None, description="THe final rate rounding to be applied.")
    """
    THe final rate rounding to be applied.
    """
    negativeTreatment: Optional[cdm.product.asset.NegativeInterestRateTreatmentEnum.NegativeInterestRateTreatmentEnum] = Field(None, description="How to handle negative interest rates.")
    """
    How to handle negative interest rates.
    """

import cdm 
import cdm.observable.asset.Price
import cdm.product.asset.RateTreatmentEnum
import cdm.base.math.Rounding
import cdm.product.asset.NegativeInterestRateTreatmentEnum
