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

__all__ = ['FloatingRate']

from cdm.product.asset.FloatingRateBase import FloatingRateBase

class FloatingRate(FloatingRateBase):
    floatingRateMultiplierSchedule: Optional[cdm.product.common.schedule.RateSchedule.RateSchedule] = Field(None, description="A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.")
    """
    A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
    """
    rateTreatment: Optional[cdm.product.asset.RateTreatmentEnum.RateTreatmentEnum] = Field(None, description="The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.")
    """
    The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
    """
    calculationParameters: Optional[cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters.FloatingRateCalculationParameters] = Field(None, description="Support for modular calculated rates, such such as lockout compound calculations.")
    """
    Support for modular calculated rates, such such as lockout compound calculations.
    """
    fallbackRate: Optional[cdm.observable.asset.calculatedrate.FallbackRateParameters.FallbackRateParameters] = Field(None, description="Definition of any fallback rate that may be applicable.")
    """
    Definition of any fallback rate that may be applicable.
    """

import cdm 
import cdm.product.common.schedule.RateSchedule
import cdm.product.asset.RateTreatmentEnum
import cdm.observable.asset.calculatedrate.FloatingRateCalculationParameters
import cdm.observable.asset.calculatedrate.FallbackRateParameters
