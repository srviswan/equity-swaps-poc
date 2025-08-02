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

__all__ = ['MarginCallInstructionType']


class MarginCallInstructionType(BaseDataClass):
    """
    Represents enumeration values to specify the call notification type, direction, specific action type.
    """
    callType: cdm.event.common.CallTypeEnum.CallTypeEnum = Field(..., description="Indicates the status of the call message type, such as expected call, notification of a call or an actionable margin call.")
    """
    Indicates the status of the call message type, such as expected call, notification of a call or an actionable margin call.
    """
    visibilityIndicator: Optional[bool] = Field(None, description="Indicates the choice if the call instruction is visible or not to the other party.")
    """
    Indicates the choice if the call instruction is visible or not to the other party.
    """
    
    @rosetta_condition
    def condition_0_CallTypeExpectedVisibility(self):
        """
        Represents a condition to ensure that a visibility indicator is specifies then the call type must be an expected call.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "visibilityIndicator"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "callType"), "=", rosetta_resolve_attr(CallTypeEnum, "EXPECTED_CALL")), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.CallTypeEnum
from cdm.event.common.CallTypeEnum import CallTypeEnum
