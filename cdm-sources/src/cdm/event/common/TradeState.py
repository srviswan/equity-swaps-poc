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

__all__ = ['TradeState']


class TradeState(BaseDataClass):
    """
    Defines the fundamental financial information that can be changed by a Primitive Event and by extension any business or life-cycle event. Each TradeState specifies where a Trade is in its life-cycle. TradeState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
    """
    trade: cdm.event.common.Trade.Trade = Field(..., description="Represents the Trade that has been effected by a business or life-cycle event.")
    """
    Represents the Trade that has been effected by a business or life-cycle event.
    """
    state: Optional[cdm.event.common.State.State] = Field(None, description="Represents the State of the Trade through its life-cycle.")
    """
    Represents the State of the Trade through its life-cycle.
    """
    resetHistory: List[cdm.event.common.Reset.Reset] = Field([], description="Represents the updated Trade attributes which can change as the result of a reset event. Only the changed values are captured, leaving the remaining data attributes empty. See Create_Reset function for further details on how TradeState is used in the Reset event. The TradeState data type is used to maintain backwards compatibility with the current Reset mechanism.")
    """
    Represents the updated Trade attributes which can change as the result of a reset event. Only the changed values are captured, leaving the remaining data attributes empty. See Create_Reset function for further details on how TradeState is used in the Reset event. The TradeState data type is used to maintain backwards compatibility with the current Reset mechanism.
    """
    transferHistory: List[cdm.event.common.TransferState.TransferState] = Field([], description="Represents the updated Trade attributes which can change as the result of a transfer event.")
    """
    Represents the updated Trade attributes which can change as the result of a transfer event.
    """
    observationHistory: List[cdm.event.common.ObservationEvent.ObservationEvent] = Field([], description="Represents the observed events related to a particular product or process, such as credit events or corporate actions.")
    """
    Represents the observed events related to a particular product or process, such as credit events or corporate actions.
    """
    valuationHistory: List[cdm.event.common.Valuation.Valuation] = Field([], description="")

import cdm 
import cdm.event.common.Trade
import cdm.event.common.State
import cdm.event.common.Reset
import cdm.event.common.TransferState
import cdm.event.common.ObservationEvent
import cdm.event.common.Valuation
