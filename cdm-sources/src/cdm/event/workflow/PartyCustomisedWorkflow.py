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

__all__ = ['PartyCustomisedWorkflow']


class PartyCustomisedWorkflow(BaseDataClass):
    """
    A class to specify a party-related, non-standardized data in a generic form.
    """
    partyReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="Reference to the party to which the workflow pertains to.")
    """
    Reference to the party to which the workflow pertains to.
    """
    partyName: Optional[str] = Field(None, description="The party name to which the workflow pertains to.")
    """
    The party name to which the workflow pertains to.
    """
    customisedWorkflow: List[cdm.event.workflow.CustomisedWorkflow.CustomisedWorkflow] = Field([], description="Non-standardized data in a generic form.")
    """
    Non-standardized data in a generic form.
    """
    @rosetta_condition
    def cardinality_customisedWorkflow(self):
        return check_cardinality(self.customisedWorkflow, 1, None)
    
    
    @rosetta_condition
    def condition_0_PartyCustomisedWorkflowChoice(self):
        """
        The identification of the party to which the PartyCustomisedWorkflow pertains to can be done through either a party reference or the party name.
        """
        item = self
        return self.check_one_of_constraint('partyName', 'partyReference', necessity=True)

import cdm 
import cdm.base.staticdata.party.Party
import cdm.event.workflow.CustomisedWorkflow
