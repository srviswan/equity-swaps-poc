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

__all__ = ['TriggerEvent']


class TriggerEvent(BaseDataClass):
    """
    Observation point for trigger.
    """
    schedule: List[cdm.base.datetime.AveragingSchedule.AveragingSchedule] = Field([], description="A derivative schedule.")
    """
    A derivative schedule.
    """
    triggerDates: Optional[cdm.base.datetime.DateList.DateList] = Field(None, description="The trigger Dates.")
    """
    The trigger Dates.
    """
    trigger: cdm.observable.event.Trigger.Trigger = Field(..., description="The trigger level")
    """
    The trigger level
    """
    featurePayment: Optional[cdm.observable.event.FeaturePayment.FeaturePayment] = Field(None, description="The feature payment, i.e. the payment made following trigger occurrence.")
    """
    The feature payment, i.e. the payment made following trigger occurrence.
    """

import cdm 
import cdm.base.datetime.AveragingSchedule
import cdm.base.datetime.DateList
import cdm.observable.event.Trigger
import cdm.observable.event.FeaturePayment
