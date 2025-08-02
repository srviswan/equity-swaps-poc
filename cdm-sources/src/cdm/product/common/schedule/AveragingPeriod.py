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

__all__ = ['AveragingPeriod']


class AveragingPeriod(BaseDataClass):
    """
    Period over which an average value is taken.
    """
    schedule: List[cdm.base.datetime.AveragingSchedule.AveragingSchedule] = Field([], description="A schedule for generating averaging observation dates.")
    """
    A schedule for generating averaging observation dates.
    """
    averagingDateTimes: Optional[cdm.base.datetime.DateTimeList.DateTimeList] = Field(None, description="An unweighted list of averaging observation date and times.")
    """
    An unweighted list of averaging observation date and times.
    """
    averagingObservations: Optional[cdm.product.common.schedule.AveragingObservationList.AveragingObservationList] = Field(None, description="A weighted list of averaging observation date and times.")
    """
    A weighted list of averaging observation date and times.
    """
    marketDisruption: Optional[AttributeWithMeta[cdm.observable.event.MarketDisruptionEnum.MarketDisruptionEnum] | cdm.observable.event.MarketDisruptionEnum.MarketDisruptionEnum] = Field(None, description="The market disruption event as defined by ISDA 2002 Definitions.")
    """
    The market disruption event as defined by ISDA 2002 Definitions.
    """
    
    @rosetta_condition
    def condition_0_AveragingPeriodChoice(self):
        """
         Choice rule to represent an FpML choice construct between unweighted and weighted averaging date and times.
        """
        item = self
        return self.check_one_of_constraint('averagingDateTimes', 'averagingObservations', necessity=False)

import cdm 
import cdm.base.datetime.AveragingSchedule
import cdm.base.datetime.DateTimeList
import cdm.product.common.schedule.AveragingObservationList
import cdm.observable.event.MarketDisruptionEnum
