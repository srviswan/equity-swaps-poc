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

__all__ = ['Trigger']


class Trigger(BaseDataClass):
    """
    Trigger point at which feature is effective.
    """
    level: List[cdm.observable.asset.PriceSchedule.PriceSchedule] = Field([], description="The trigger level.")
    """
    The trigger level.
    """
    @rosetta_condition
    def cardinality_level(self):
        return check_cardinality(self.level, 0, 2)
    
    creditEvents: Optional[cdm.observable.event.CreditEvents.CreditEvents] = Field(None, description="")
    creditEventsReference: Optional[AttributeWithReference | cdm.observable.event.CreditEvents.CreditEvents] = Field(None, description="")
    triggerType: Optional[cdm.observable.event.TriggerTypeEnum.TriggerTypeEnum] = Field(None, description="The Triggering condition.")
    """
    The Triggering condition.
    """
    triggerTimeType: Optional[cdm.observable.event.TriggerTimeTypeEnum.TriggerTimeTypeEnum] = Field(None, description="The valuation time type of knock condition.")
    """
    The valuation time type of knock condition.
    """
    
    @rosetta_condition
    def condition_0_Choice1(self):
        """
         Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('level', 'creditEvents', 'creditEventsReference', necessity=True)

import cdm 
import cdm.observable.asset.PriceSchedule
import cdm.observable.event.CreditEvents
import cdm.observable.event.TriggerTypeEnum
import cdm.observable.event.TriggerTimeTypeEnum
