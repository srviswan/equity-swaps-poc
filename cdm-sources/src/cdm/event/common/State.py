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

__all__ = ['State']


class State(BaseDataClass):
    """
    Defines the state of a trade at a point in the Trade's life cycle. Trades have many state dimensions, all of which are represented here. For example, states useful for position keeping are represented alongside those needed for regulatory reporting.
    """
    closedState: Optional[cdm.legaldocumentation.common.ClosedState.ClosedState] = Field(None, description="Represents the qualification of what led to the trade's closure alongside the dates on which this closure took effect.")
    """
    Represents the qualification of what led to the trade's closure alongside the dates on which this closure took effect.
    """
    positionState: Optional[cdm.event.position.PositionStatusEnum.PositionStatusEnum] = Field(None, description="Identifies the state of the position, to distinguish if just executed, formed, already settled, closed, etc.")
    """
    Identifies the state of the position, to distinguish if just executed, formed, already settled, closed, etc.
    """
    
    @rosetta_condition
    def condition_0_ClosedStateExists(self):
        """
        When the position state is identified as closed, the closed state must also be specified.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "closedState"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "positionState"), "=", rosetta_resolve_attr(PositionStatusEnum, "CLOSED")), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.common.ClosedState
import cdm.event.position.PositionStatusEnum
from cdm.event.position.PositionStatusEnum import PositionStatusEnum
