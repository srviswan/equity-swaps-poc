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

__all__ = ['CalculatedRateObservations']


class CalculatedRateObservations(BaseDataClass):
    """
    Type for reporting observations that went into the final reported rate.
    """
    observationDates: List[datetime.date] = Field([], description="The observation date upon which the rate is observed.")
    """
    The observation date upon which the rate is observed.
    """
    weights: List[Decimal] = Field([], description="The corresponding weight for each date.")
    """
    The corresponding weight for each date.
    """
    observedRates: List[Decimal] = Field([], description="The value observed for that date")
    """
    The value observed for that date
    """
    processedRates: List[Decimal] = Field([], description="The value after any processing, such as application of caps or floors.")
    """
    The value after any processing, such as application of caps or floors.
    """

import cdm 
