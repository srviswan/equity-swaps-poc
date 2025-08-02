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

__all__ = ['DateRelativeToCalculationPeriodDates']


class DateRelativeToCalculationPeriodDates(BaseDataClass):
    """
    A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
    """
    calculationPeriodDatesReference: List[AttributeWithReference | cdm.product.common.schedule.CalculationPeriodDates.CalculationPeriodDates] = Field([], description="A set of href pointers to calculation period dates defined somewhere else in the document.")
    """
    A set of href pointers to calculation period dates defined somewhere else in the document.
    """
    @rosetta_condition
    def cardinality_calculationPeriodDatesReference(self):
        return check_cardinality(self.calculationPeriodDatesReference, 1, None)
    

import cdm 
import cdm.product.common.schedule.CalculationPeriodDates
