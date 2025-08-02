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

__all__ = ['WorkflowStep']


class WorkflowStep(BaseDataClass):
    """
    A workflow step represents the state of a business event. The workflow step contains a reference to a previous WorkflowStep in order to preserve lineage. A workflow step is accepted if it contains a business event, proposed if proposedEvent is present and is rejected if the rejected flag is set.
    """
    businessEvent: Optional[cdm.event.common.BusinessEvent.BusinessEvent] = Field(None, description="Life cycle event for the step. The businessEvent is optional when a proposedEvent or rejection are present.")
    """
    Life cycle event for the step. The businessEvent is optional when a proposedEvent or rejection are present.
    """
    counterpartyPositionBusinessEvent: Optional[cdm.event.common.CounterpartyPositionBusinessEvent.CounterpartyPositionBusinessEvent] = Field(None, description="Documents the life cycle event for a position.")
    """
    Documents the life cycle event for a position.
    """
    proposedEvent: Optional[cdm.event.workflow.EventInstruction.EventInstruction] = Field(None, description="The proposed event for a workflow step. The proposedEvent is optional when the businessEvent or rejection are present")
    """
    The proposed event for a workflow step. The proposedEvent is optional when the businessEvent or rejection are present
    """
    rejected: Optional[bool] = Field(None, description="Flags this step as rejected.")
    """
    Flags this step as rejected.
    """
    approval: List[cdm.event.workflow.WorkflowStepApproval.WorkflowStepApproval] = Field([], description="Optional party approvals for the current workflow step. A workflow step can have any number of parties associated to it, thus this object is represented as a list. All parties that are expected to provide approval should have an item in this list that references them.")
    """
    Optional party approvals for the current workflow step. A workflow step can have any number of parties associated to it, thus this object is represented as a list. All parties that are expected to provide approval should have an item in this list that references them.
    """
    previousWorkflowStep: Optional[AttributeWithReference | cdm.event.workflow.WorkflowStep.WorkflowStep] = Field(None, description="Optional previous workflow step that provides lineage to workflow steps that precedes it.")
    """
    Optional previous workflow step that provides lineage to workflow steps that precedes it.
    """
    nextEvent: Optional[cdm.event.workflow.EventInstruction.EventInstruction] = Field(None, description="The intended next event can be specified, even if the instructions are not known yet.")
    """
    The intended next event can be specified, even if the instructions are not known yet.
    """
    messageInformation: Optional[cdm.event.workflow.MessageInformation.MessageInformation] = Field(None, description="Contains all information pertaining the FpML messaging header ")
    """
    Contains all information pertaining the FpML messaging header 
    """
    timestamp: List[cdm.event.workflow.EventTimestamp.EventTimestamp] = Field([], description="The set of timestamp(s) associated with the event as a collection of [dateTime, qualifier].")
    """
    The set of timestamp(s) associated with the event as a collection of [dateTime, qualifier].
    """
    @rosetta_condition
    def cardinality_timestamp(self):
        return check_cardinality(self.timestamp, 1, None)
    
    eventIdentifier: List[cdm.base.staticdata.identifier.Identifier.Identifier] = Field([], description="The identifier(s) that uniquely identify a lifecycle event. The unbounded cardinality is meant to provide the ability to associate identifiers that are issued by distinct parties. As an example, each of the parties to the event may choose to associate their own identifiers to the event.")
    """
    The identifier(s) that uniquely identify a lifecycle event. The unbounded cardinality is meant to provide the ability to associate identifiers that are issued by distinct parties. As an example, each of the parties to the event may choose to associate their own identifiers to the event.
    """
    @rosetta_condition
    def cardinality_eventIdentifier(self):
        return check_cardinality(self.eventIdentifier, 1, None)
    
    action: Optional[cdm.event.common.ActionEnum.ActionEnum] = Field(None, description="Specifies whether the event is a new, a correction or a cancellation.")
    """
    Specifies whether the event is a new, a correction or a cancellation.
    """
    party: List[cdm.base.staticdata.party.Party.Party] = Field([], description="The specification of the event parties. This attribute is optional, as not applicable to certain events (e.g. most of the observations).")
    """
    The specification of the event parties. This attribute is optional, as not applicable to certain events (e.g. most of the observations).
    """
    account: List[cdm.base.staticdata.party.Account.Account] = Field([], description="Optional account information that could be associated to the event.")
    """
    Optional account information that could be associated to the event.
    """
    lineage: Optional[cdm.event.common.Lineage.Lineage] = Field(None, description="The lineage attribute provides a linkage among lifecycle events through the globalKey hash value. One example is when a given lifecycle event is being corrected or cancelled. In such case, each subsequent event will have lineage into the prior version of that event. The second broad use case is when an event has a dependency upon either another event (e.g. the regular payment associated with a fix/float swap will have a lineage into the reset event, which will in turn have a lineage into the observation event for the floating rate and the contract) or a contract (e.g. the exercise of an option has a lineage into that option).")
    """
    The lineage attribute provides a linkage among lifecycle events through the globalKey hash value. One example is when a given lifecycle event is being corrected or cancelled. In such case, each subsequent event will have lineage into the prior version of that event. The second broad use case is when an event has a dependency upon either another event (e.g. the regular payment associated with a fix/float swap will have a lineage into the reset event, which will in turn have a lineage into the observation event for the floating rate and the contract) or a contract (e.g. the exercise of an option has a lineage into that option).
    """
    creditLimitInformation: Optional[cdm.event.workflow.CreditLimitInformation.CreditLimitInformation] = Field(None, description="")
    workflowState: Optional[cdm.event.workflow.WorkflowState.WorkflowState] = Field(None, description="The event workflow information, i.e. the workflow status, the associated comment and the partyCustomisedWorkflow which purpose is to provide the ability to associate custom workflow information to the CDM.")
    """
    The event workflow information, i.e. the workflow status, the associated comment and the partyCustomisedWorkflow which purpose is to provide the ability to associate custom workflow information to the CDM.
    """
    
    @rosetta_condition
    def condition_0_WorkflowStepStatus(self):
        item = self
        return ((((((rosetta_attr_exists(rosetta_resolve_attr(self, "businessEvent")) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "nextEvent"), "instruction")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "rejected")))) or ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "nextEvent"), "instruction")) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "businessEvent")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "rejected"))))) or ((rosetta_attr_exists(rosetta_resolve_attr(self, "rejected")) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "businessEvent")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "nextEvent"))))) or ((rosetta_attr_exists(rosetta_resolve_attr(self, "proposedEvent")) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "nextEvent")))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "rejected"))))) or (rosetta_attr_exists(rosetta_resolve_attr(self, "previousWorkflowStep")) and all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "CANCEL"))))
    
    @rosetta_condition
    def condition_1_CounterpartyPositionBusinessEventOrBusinessEventChoice(self):
        """
        Choice rule to control that either positionBusinessEvent is present or businessEvent is present, but not both at the same time.
        """
        item = self
        return self.check_one_of_constraint('counterpartyPositionBusinessEvent', 'businessEvent', necessity=True)

import cdm 
import cdm.event.common.BusinessEvent
import cdm.event.common.CounterpartyPositionBusinessEvent
import cdm.event.workflow.EventInstruction
import cdm.event.workflow.WorkflowStepApproval
import cdm.event.workflow.WorkflowStep
import cdm.event.workflow.MessageInformation
import cdm.event.workflow.EventTimestamp
import cdm.base.staticdata.identifier.Identifier
import cdm.event.common.ActionEnum
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.party.Account
import cdm.event.common.Lineage
import cdm.event.workflow.CreditLimitInformation
import cdm.event.workflow.WorkflowState
from cdm.event.common.ActionEnum import ActionEnum
