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

__all__ = ['WorkflowState']


class WorkflowState(BaseDataClass):
    """
    A class to specify workflow information, which is conceptually applicable to all lifecycle events.
    """
    workflowStatus: cdm.event.workflow.WorkflowStatusEnum.WorkflowStatusEnum = Field(..., description="The workflow status indicator, e.g. Accepted, Rejected, ...")
    """
    The workflow status indicator, e.g. Accepted, Rejected, ...
    """
    comment: Optional[str] = Field(None, description="A comment field to be associated with the workflow, e.g. to specify why a transaction event was rejected by a party.")
    """
    A comment field to be associated with the workflow, e.g. to specify why a transaction event was rejected by a party.
    """
    partyCustomisedWorkflow: List[cdm.event.workflow.PartyCustomisedWorkflow.PartyCustomisedWorkflow] = Field([], description="Workflow data that is specific to certain market participants and is expressed as part of the CDM in a very generic manner, which can be party-specific. The initial use cases have been derived from the CME clearing and the DTCC TIW submissions.")
    """
    Workflow data that is specific to certain market participants and is expressed as part of the CDM in a very generic manner, which can be party-specific. The initial use cases have been derived from the CME clearing and the DTCC TIW submissions.
    """
    warehouseIdentity: Optional[cdm.event.workflow.WarehouseIdentityEnum.WarehouseIdentityEnum] = Field(None, description="The identity of the warehouse, if any, that is executing that workflow step.")
    """
    The identity of the warehouse, if any, that is executing that workflow step.
    """

import cdm 
import cdm.event.workflow.WorkflowStatusEnum
import cdm.event.workflow.PartyCustomisedWorkflow
import cdm.event.workflow.WarehouseIdentityEnum
