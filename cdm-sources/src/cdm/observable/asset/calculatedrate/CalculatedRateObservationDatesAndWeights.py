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

__all__ = ['CalculatedRateObservationDatesAndWeights']


class CalculatedRateObservationDatesAndWeights(BaseDataClass):
    """
    Type for reporting the observations dates and the corresponding weights going into a daily calculated rate
    """
    observationDates: List[datetime.date] = Field([], description="The observation date upon which the rate is observed.")
    """
    The observation date upon which the rate is observed.
    """
    weights: List[Decimal] = Field([], description="The corresponding weight for each date.")
    """
    The corresponding weight for each date.
    """

import cdm 
