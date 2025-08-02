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

__all__ = ['CounterpartyPositionState']


class CounterpartyPositionState(BaseDataClass):
    """
    Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each PositionState specifies where a Position is in its life-cycle. PositionState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
    """
    counterpartyPosition: cdm.event.position.CounterpartyPosition.CounterpartyPosition = Field(..., description="Represents the Position that has been effected by a business or life-cycle event.")
    """
    Represents the Position that has been effected by a business or life-cycle event.
    """
    state: Optional[cdm.event.common.State.State] = Field(None, description="Represents the State of the Position through its life-cycle.")
    """
    Represents the State of the Position through its life-cycle.
    """
    observationHistory: List[cdm.event.common.ObservationEvent.ObservationEvent] = Field([], description="Represents the observed events related to a particular product or process, such as credit events or corporate actions.")
    """
    Represents the observed events related to a particular product or process, such as credit events or corporate actions.
    """
    valuationHistory: List[cdm.event.common.Valuation.Valuation] = Field([], description="")

import cdm 
import cdm.event.position.CounterpartyPosition
import cdm.event.common.State
import cdm.event.common.ObservationEvent
import cdm.event.common.Valuation
