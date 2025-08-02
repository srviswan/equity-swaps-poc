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

__all__ = ['FutureValueAmount']


class FutureValueAmount(BaseDataClass):
    """
    A class defining a currency and a future value date.
    """
    quantity: Optional[AttributeWithAddress[cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] | cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] = Field(None, description="")
    currency: AttributeWithMeta[str] | str = Field(..., description="The currency in which the an amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.")
    """
    The currency in which the an amount is denominated. The list of valid currencies is not presently positioned as an enumeration as part of the CDM because that scope is limited to the values specified by ISDA and FpML. As a result, implementers have to make reference to the relevant standard, such as the ISO 4217 standard for currency codes.
    """
    calculationPeriodNumberOfDays: int = Field(..., description="The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.")
    """
    The number of days from the adjusted calculation period start date to the adjusted value date, calculated in accordance with the applicable day count fraction.
    """
    valueDate: datetime.date = Field(..., description="Adjusted value date of the future value amount.")
    """
    Adjusted value date of the future value amount.
    """
    
    @rosetta_condition
    def condition_0_PositiveCalculationPeriodNumberOfDays(self):
        """
        FpML specifies calculationPeriodNumberOfDays as a positiveInteger.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "calculationPeriodNumberOfDays"), ">=", 0)

import cdm 
import cdm.base.math.NonNegativeQuantitySchedule
