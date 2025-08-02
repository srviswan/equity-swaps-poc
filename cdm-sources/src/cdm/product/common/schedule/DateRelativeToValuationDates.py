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

__all__ = ['DateRelativeToValuationDates']


class DateRelativeToValuationDates(BaseDataClass):
    """
    A data to:  provide the ability to point to multiple payment nodes in the document through the unbounded paymentDatesReference.
    """
    valuationDatesReference: List[AttributeWithReference | cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDates] = Field([], description="A set of href pointers to valuation period dates defined somewhere else in the document.")
    """
    A set of href pointers to valuation period dates defined somewhere else in the document.
    """
    @rosetta_condition
    def cardinality_valuationDatesReference(self):
        return check_cardinality(self.valuationDatesReference, 1, None)
    

import cdm 
import cdm.observable.asset.PerformanceValuationDates
