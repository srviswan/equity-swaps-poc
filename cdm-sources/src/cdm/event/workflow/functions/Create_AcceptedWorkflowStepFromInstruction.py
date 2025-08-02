# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.Create_BusinessEvent import Create_BusinessEvent
from cdm.event.workflow.WorkflowStep import WorkflowStep

__all__ = ['Create_AcceptedWorkflowStepFromInstruction']


@replaceable
def Create_AcceptedWorkflowStepFromInstruction(proposedWorkflowStep: WorkflowStep) -> WorkflowStep:
    """
    Represents the acceptance of a proposed instruction that results in a workflow step containing a business event, message details, identifiers, event timestamps, parties and accounts. The previous workflow step input must exist to provide workflow lineage. The instruction from the previous workflow step should be used with a [creation BusinessEvent] function to create the input business event passed into this function e.g. PartyChangeInstruction from the previous step is used with Create_PartyChange to produce the business event which should used as an input to this step.
    
    Parameters 
    ----------
    proposedWorkflowStep : WorkflowStep
    WorkflowStep as instruction.
    
    Returns
    -------
    acceptedWorkflowStep : WorkflowStep
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_ProposedEventExists(self):
        """
        The previous step being accepted must be a proposed step containing an instruction.
        """
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "proposedEvent"))
    
    @rosetta_local_condition(_pre_registry)
    def condition_1_CancelledProposedStep(self):
        """
        You cannot accept a business event on a cancelled previous step.
        """
        return any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "action"), "<>", rosetta_resolve_attr(ActionEnum, "CANCEL"))
    
    @rosetta_local_condition(_pre_registry)
    def condition_2_RejectedProposedStep(self):
        """
        The previous step cannot be rejected.
        """
        return any_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "rejected"), "<>", True)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    acceptedWorkflowStep = _get_rosetta_object('WorkflowStep', 'action', rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "action"))
    acceptedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'acceptedWorkflowStep'), 'messageInformation', rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "messageInformation"))
    acceptedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, acceptedWorkflowStep), 'timestamp'), rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "timestamp"))
    acceptedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, acceptedWorkflowStep), 'eventIdentifier'), rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "eventIdentifier"))
    acceptedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'acceptedWorkflowStep'), 'previousWorkflowStep', {rosetta_resolve_attr(self, "proposedWorkflowStep"): True})
    acceptedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'acceptedWorkflowStep'), 'nextEvent', rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "nextEvent"))
    acceptedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'acceptedWorkflowStep'), 'businessEvent', Create_BusinessEvent(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "proposedEvent"), "instruction"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "proposedEvent"), "intent"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "proposedEvent"), "eventDate"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "proposedEvent"), "effectiveDate")))
    acceptedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, acceptedWorkflowStep), 'party'), set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "acceptedWorkflowStep"), "businessEvent"), "after"), "trade"), "party")))
    acceptedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, acceptedWorkflowStep), 'account'), set(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "acceptedWorkflowStep"), "businessEvent"), "after"), "trade"), "account")))
    
    
    return acceptedWorkflowStep

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
