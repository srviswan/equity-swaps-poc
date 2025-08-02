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
from cdm.event.workflow.WorkflowStep import WorkflowStep
from cdm.event.workflow.EventTimestamp import EventTimestamp
from cdm.event.workflow.MessageInformation import MessageInformation

__all__ = ['Create_RejectedWorkflowStep']


@replaceable
def Create_RejectedWorkflowStep(messageInformation: MessageInformation | None, timestamp: list[EventTimestamp], eventIdentifier: list[Identifier], proposedWorkflowStep: WorkflowStep) -> WorkflowStep:
    """
    Represents the rejection of a proposed instruction that results in a workflow step containing the rejection flag, message details, identifiers, event timestamps, parties and accounts involved in the step. The previous workflow step input must exist to provide workflow lineage. This function will be further developed to provide the reasons for rejection.
    
    Parameters 
    ----------
    messageInformation : MessageInformation
    Contains all information pertaining the messaging header
    
    timestamp : EventTimestamp
    The dateTime and qualifier associated with this event.
    
    eventIdentifier : Identifier
    The identifiers that uniquely identify this lifecycle event.
    
    proposedWorkflowStep : WorkflowStep
    Required previous WorkflowStep that provides lineage to WorkflowStep that precedes it.
    
    Returns
    -------
    rejectedWorkflowStep : WorkflowStep
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_ProposedEventExists(self):
        """
        The previous proposed step being rejected must exist
        """
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "proposedWorkflowStep"), "proposedEvent"))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    rejectedWorkflowStep = _get_rosetta_object('WorkflowStep', 'messageInformation', rosetta_resolve_attr(self, "messageInformation"))
    rejectedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, rejectedWorkflowStep), 'timestamp'), rosetta_resolve_attr(self, "timestamp"))
    rejectedWorkflowStep.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, rejectedWorkflowStep), 'eventIdentifier'), rosetta_resolve_attr(self, "eventIdentifier"))
    rejectedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'rejectedWorkflowStep'), 'previousWorkflowStep', {rosetta_resolve_attr(self, "proposedWorkflowStep"): True})
    rejectedWorkflowStep = set_rosetta_attr(rosetta_resolve_attr(self, 'rejectedWorkflowStep'), 'rejected', True)
    
    
    return rejectedWorkflowStep

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
