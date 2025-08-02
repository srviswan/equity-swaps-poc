# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ActionEnum import ActionEnum
from cdm.base.staticdata.identifier.Identifier import Identifier
from cdm.base.staticdata.party.Party import Party
from cdm.base.staticdata.party.Account import Account
from cdm.event.workflow.WorkflowStep import WorkflowStep
from cdm.event.workflow.EventTimestamp import EventTimestamp
from cdm.event.workflow.MessageInformation import MessageInformation
from cdm.event.common.BusinessEvent import BusinessEvent

__all__ = ['Create_WorkflowStep']


@replaceable
def Create_WorkflowStep(messageInformation: MessageInformation | None, timestamp: list[EventTimestamp], eventIdentifier: list[Identifier], party: list[Party] | None, account: list[Account] | None, previousWorkflowStep: WorkflowStep | None, action: ActionEnum, businessEvent: BusinessEvent | None) -> WorkflowStep:
    """
    Function to create a workflow step with a business event and associated details about the message, identifiers, event timestamps, parties and accounts involved in the step. The function should be used when there is already a fully formed business event with the action set to signify that the step is new, or a correction/cancellation of a previous step. The action is constrained so that when a previous workflow step is specified, the valid actions are as follows; New -> New, New -> Correct, New -> Cancel, Correct -> Correct and Correct -> Cancel. When a previous workflow is not specified, the action must be New.
    
    Parameters 
    ----------
    messageInformation : MessageInformation
    Contains all information pertaining the messaging header.
    
    timestamp : EventTimestamp
    The dateTime and qualifier associated with this event.
    
    eventIdentifier : Identifier
    The identifiers that uniquely identify this lifecycle event.
    
    party : Party
    The specification of the parties involved in the WorkflowStep.
    
    account : Account
    Optional account information that could be associated to the event.
    
    previousWorkflowStep : WorkflowStep
    Optional previous WorkflowStep that provides lineage to WorkflowStep that precedes it. If specified, the previous action is used to constrain the actions allows to the resulting workflow step.
    
    action : ActionEnum
    Specifies whether the event is a new, a correction or a cancellation. When a previous workflow step is specified, the allowed actions are as follows; New -> New, New -> Correct, New -> Cancel, Correct -> Correct and Correct -> Cancel. When a previous workflow is not specified, the action must be New. Two consecutive workflow steps with action New, is valid when you have multiple steps e.g. new execution -> new contract formation
    
    businessEvent : BusinessEvent
    Life cycle event for the step. The business event must be specified if the action is new or corrected, and must be absent in the case of a cancel where the previous step would provide the lineage to the business event.
    
    Returns
    -------
    workflowStep : WorkflowStep
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_PreviousBusinessEventExists(self):
        """
        The previous workflow step must contain a business event. Use Create_AcceptedWorkflowStep when the previous workflow step is a proposal.
        """
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "businessEvent"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "previousWorkflowStep")), _then_fn0, _else_fn0)
    
    @rosetta_local_condition(_pre_registry)
    def condition_1_ActionEnumChange(self):
        """
        Valid action transitions are: New -> New, New -> Correct, New -> Cancel, Correct -> New, Correct -> Correct and Correct -> Cancel
        """
        def _then_fn0():
            return ((all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "NEW")) or all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "CORRECT"))) or all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "CANCEL")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "action"), "=", rosetta_resolve_attr(ActionEnum, "NEW")) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "action"), "=", rosetta_resolve_attr(ActionEnum, "CORRECT"))), _then_fn0, _else_fn0)
    
    @rosetta_local_condition(_pre_registry)
    def condition_2_CancelledPreviousStep(self):
        """
        You cannot create a business event on a cancelled previous step
        """
        return any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "action"), "<>", rosetta_resolve_attr(ActionEnum, "CANCEL"))
    
    @rosetta_local_condition(_pre_registry)
    def condition_3_NewAction(self):
        """
        Action must be New if there is no previous step
        """
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "action"), "=", rosetta_resolve_attr(ActionEnum, "NEW"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((not rosetta_attr_exists(rosetta_resolve_attr(self, "previousWorkflowStep"))) or (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "previousWorkflowStep"), "action")))), _then_fn0, _else_fn0)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "previousWorkflowStep")
    
    def _else_fn0():
        return True
    
    workflowStep = _get_rosetta_object('WorkflowStep', 'action', rosetta_resolve_attr(self, "action"))
    workflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'workflowStep'), 'messageInformation', rosetta_resolve_attr(self, "messageInformation"))
    workflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, workflowStep), 'timestamp'), rosetta_resolve_attr(self, "timestamp"))
    workflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, workflowStep), 'eventIdentifier'), rosetta_resolve_attr(self, "eventIdentifier"))
    workflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, workflowStep), 'party'), rosetta_resolve_attr(self, "party"))
    workflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, workflowStep), 'account'), rosetta_resolve_attr(self, "account"))
    workflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'workflowStep'), 'previousWorkflowStep', {if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "previousWorkflowStep")), _then_fn0, _else_fn0): True})
    workflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'workflowStep'), 'businessEvent', rosetta_resolve_attr(self, "businessEvent"))
    
    
    return workflowStep

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
