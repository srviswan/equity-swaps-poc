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

__all__ = ['ObservationDates']


class ObservationDates(BaseDataClass):
    """
    Describes date details for a set of observation dates in parametric or non-parametric form.
    """
    observationSchedule: Optional[cdm.product.common.schedule.ObservationSchedule.ObservationSchedule] = Field(None, description="Specifies a schedule of dates (non-parametric) on which market observations take place, and allows for the optional definition of weights where applicable. When no weight is specified, then weight of each date is assumed to be 1.0")
    """
    Specifies a schedule of dates (non-parametric) on which market observations take place, and allows for the optional definition of weights where applicable.  When no weight is specified, then weight of each date is assumed to be 1.0
    """
    periodicSchedule: Optional[cdm.base.datetime.PeriodicDates.PeriodicDates] = Field(None, description="Specifies the date range and frequency on which market observations take place. Weights can be assigned to dates in the schedule by assigning the weight and corresponding observationReference in the observationSchedule.")
    """
    Specifies the date range and frequency on which market observations take place.  Weights can be assigned to dates in the schedule by assigning the weight and corresponding observationReference in the observationSchedule.
    """
    parametricDates: Optional[cdm.product.common.schedule.ParametricDates.ParametricDates] = Field(None, description="Specifies parametric terms to determine which days within a given calculation period the price would be observed. Typically associated with Commodities. ")
    """
    Specifies parametric terms to determine which days within a given calculation period the price would be observed. Typically associated with Commodities. 
    """

import cdm 
import cdm.product.common.schedule.ObservationSchedule
import cdm.base.datetime.PeriodicDates
import cdm.product.common.schedule.ParametricDates
