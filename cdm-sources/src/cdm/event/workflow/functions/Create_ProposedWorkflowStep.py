# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.identifier.Identifier import Identifier
from cdm.base.staticdata.party.Party import Party
from cdm.event.common.ActionEnum import ActionEnum
from cdm.base.staticdata.party.Account import Account
from cdm.event.workflow.WorkflowStep import WorkflowStep
from cdm.event.workflow.EventTimestamp import EventTimestamp
from cdm.event.workflow.EventInstruction import EventInstruction
from cdm.event.workflow.MessageInformation import MessageInformation
from cdm.event.workflow.WorkflowStepApproval import WorkflowStepApproval

__all__ = ['Create_ProposedWorkflowStep']


@replaceable
def Create_ProposedWorkflowStep(messageInformation: MessageInformation | None, timestamp: list[EventTimestamp], eventIdentifier: list[Identifier], party: list[Party] | None, account: list[Account] | None, previousWorkflowStep: WorkflowStep | None, action: ActionEnum, proposedEvent: EventInstruction, approval: list[WorkflowStepApproval] | None) -> WorkflowStep:
    """
    Represents the proposal to create a business event that results in a workflow step containing an instruction, message details, identifiers, event timestamps, parties and accounts. The optional previous workflow step input provides workflow lineage to where there has been a correction or cancellation to the proposed step. The action is constrained so that when a previous workflow step is specified, the valid actions are as follows; New -> Correct and Correct -> Cancel. When a previous workflow is not specified, the action must be New.
    
    Parameters 
    ----------
    messageInformation : MessageInformation
    Contains all information pertaining the messaging header
    
    timestamp : EventTimestamp
    The dateTime and qualifier associated with this event.
    
    eventIdentifier : Identifier
    The identifiers that uniquely identify this lifecycle event.
    
    party : Party
    The specification of the parties involved in the WorkflowStep.
    
    account : Account
    Optional account information that could be associated to the event.
    
    previousWorkflowStep : WorkflowStep
    Optional previous WorkflowStep that provides lineage to WorkflowStep that precedes it.
    
    action : ActionEnum
    Specifies whether the event is new or a correction. The action cannot be a cancellation or new if the previous step is also new.
    
    proposedEvent : EventInstruction
    The proposed instruction for the step to initiate a workflow e.g. Clearing Instruction or Allocation Instruction
    
    approval : WorkflowStepApproval
    The approval status of all parties on the proposed event.
    
    Returns
    -------
    proposedWorkflowStep : WorkflowStep
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_CorrectAction(self):
        """
        When the previous step is new or corrected and contains an instruction (proposed), the following action can only be correct.
        """
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "CORRECT"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "proposedEvent")) and (all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "action"), "=", rosetta_resolve_attr(ActionEnum, "NEW")) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "action"), "=", rosetta_resolve_attr(ActionEnum, "CORRECT")))), _then_fn0, _else_fn0)
    
    @rosetta_local_condition(_pre_registry)
    def condition_1_NewAction(self):
        """
        When the previous step contains a business event, the following action can only be new.
        """
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "NEW"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((not rosetta_attr_exists(rosetta_resolve_attr(self, "previousWorkflowStep"))) or rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "businessEvent"))), _then_fn0, _else_fn0)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    proposedWorkflowStep = _get_rosetta_object('WorkflowStep', 'messageInformation', rosetta_resolve_attr(self, "messageInformation"))
    proposedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, proposedWorkflowStep), 'timestamp'), rosetta_resolve_attr(self, "timestamp"))
    proposedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, proposedWorkflowStep), 'eventIdentifier'), rosetta_resolve_attr(self, "eventIdentifier"))
    proposedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, proposedWorkflowStep), 'party'), rosetta_resolve_attr(self, "party"))
    proposedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, proposedWorkflowStep), 'account'), rosetta_resolve_attr(self, "account"))
    proposedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'proposedWorkflowStep'), 'previousWorkflowStep', {rosetta_resolve_attr(self, "previousWorkflowStep"): True})
    proposedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'proposedWorkflowStep'), 'proposedEvent', rosetta_resolve_attr(self, "proposedEvent"))
    proposedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, proposedWorkflowStep), 'approval'), rosetta_resolve_attr(self, "approval"))
    
    
    return proposedWorkflowStep

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
