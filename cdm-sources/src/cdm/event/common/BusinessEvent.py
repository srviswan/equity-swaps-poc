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

__all__ = ['BusinessEvent']

from cdm.event.workflow.EventInstruction import EventInstruction

class BusinessEvent(EventInstruction):
    """
    A business event represents a life cycle event of a trade. The combination of the state changes results in a qualifiable life cycle event. An example of a Business Event is a PartialTermination which is a defined by a quantity change primitive event.
    """
    eventQualifier: Optional[str] = Field(None, description="The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).")
    """
    The CDM event qualifier, which corresponds to the outcome of the isEvent qualification logic which qualifies the lifecycle event as a function of its features (e.g. PartialTermination, ClearingSubmission, Novation, ...).
    """
    after: List[cdm.event.common.TradeState.TradeState] = Field([], description="Specifies the after trade state(s) created.")
    """
    Specifies the after trade state(s) created.
    """
    
    @rosetta_condition
    def condition_0_EventDate(self):
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "eventDate"))

import cdm 
import cdm.event.common.TradeState
