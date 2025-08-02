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

__all__ = ['FloatingRateSettingDetails']


class FloatingRateSettingDetails(BaseDataClass):
    """
    Type for reporting the raw (untreated) observed or calculated rate for a calculation period.  If this is a calculated rate, it allows details of the observations and the resulting rate to be returned.
    """
    calculationDetails: Optional[cdm.observable.asset.calculatedrate.CalculatedRateDetails.CalculatedRateDetails] = Field(None, description="Calculated rate details (observation dates, values, and weights).")
    """
    Calculated rate details (observation dates, values, and weights).
    """
    observationDate: Optional[datetime.date] = Field(None, description="The day upon which the rate was observed (for term rates).")
    """
    The day upon which the rate was observed (for term rates).
    """
    resetDate: Optional[datetime.date] = Field(None, description="The day for which the rate is needed (e.g. period beginning or end date).")
    """
    The day for which the rate is needed (e.g. period beginning or end date).
    """
    floatingRate: Decimal = Field(..., description="The resulting rate that was observed or calculated.")
    """
    The resulting rate that was observed or calculated.
    """

import cdm 
import cdm.observable.asset.calculatedrate.CalculatedRateDetails
