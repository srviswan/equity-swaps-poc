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

__all__ = ['WorkflowStepApproval']


class WorkflowStepApproval(BaseDataClass):
    """
    Party approvals associated to the current WorkflowStep. 
    """
    approved: bool = Field(..., description="Flag denoting whether the workflow step is approved or not")
    """
    Flag denoting whether the workflow step is approved or not
    """
    party: AttributeWithReference | cdm.base.staticdata.party.Party.Party = Field(..., description="Reference to the Party who is approving/rejecting this workflow step")
    """
    Reference to the Party who is approving/rejecting this workflow step
    """
    rejectedReason: Optional[str] = Field(None, description="Optional reason for rejecting the workflow step")
    """
    Optional reason for rejecting the workflow step
    """
    timestamp: cdm.event.workflow.EventTimestamp.EventTimestamp = Field(..., description="Timestamp of the approval")
    """
    Timestamp of the approval
    """

import cdm 
import cdm.base.staticdata.party.Party
import cdm.event.workflow.EventTimestamp
