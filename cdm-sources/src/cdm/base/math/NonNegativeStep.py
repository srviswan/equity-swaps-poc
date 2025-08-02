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

__all__ = ['NonNegativeStep']


class NonNegativeStep(BaseDataClass):
    """
    A class defining a step date and non-negative step value pair. This step definitions are used to define varying rate or amount schedules, e.g. a notional amortisation or a step-up coupon schedule.
    """
    stepDate: datetime.date = Field(..., description="The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.")
    """
    The date on which the associated stepValue becomes effective. This day may be subject to adjustment in accordance with a business day convention.
    """
    stepValue: Decimal = Field(..., description="The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.")
    """
    The non-negative rate or amount which becomes effective on the associated stepDate. A rate of 5% would be represented as 0.05.
    """
    
    @rosetta_condition
    def condition_0_StepValue(self):
        """
        FpML specified stepValue as a NonNegativeDecimal.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "stepValue"), ">=", 0.0)

import cdm 
