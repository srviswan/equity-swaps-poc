# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.workflow.WorkflowStep import WorkflowStep
from cdm.event.workflow.Workflow import Workflow

__all__ = ['Create_Workflow']


@replaceable
def Create_Workflow(steps: list[WorkflowStep]) -> Workflow:
    """
    Function to create a Workflow from a list of WorkflowStep.
    
    Parameters 
    ----------
    steps : WorkflowStep
    
    Returns
    -------
    workflow : Workflow
    
    """
    self = inspect.currentframe()
    
    
    workflow = rosetta_resolve_attr(self, "steps")
    
    
    return workflow

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
