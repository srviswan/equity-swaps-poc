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

__all__ = ['UnderlierSubstitutionProvision']


class UnderlierSubstitutionProvision(BaseDataClass):
    """
    Where parties describe any substitution terms.
    """
    whoMaySubstitute: List[cdm.base.staticdata.party.CounterpartyRoleEnum.CounterpartyRoleEnum] = Field([], description="Designates which Counterparty to the transaction who has the right to trigger a substitution or to provide related determination e.g. for instance to qualify the effectiveness of an Event which may be a trigger for substitution, determine the replacement Share to substitute, etc. ; cardinality of this object is 2, in case parties jointly have this role.")
    """
    Designates which Counterparty to the transaction who has the right to trigger a substitution or to provide related determination e.g. for instance to qualify the effectiveness of an Event which may be a trigger for substitution, determine the replacement Share to substitute, etc. ; cardinality of this object is 2, in case parties jointly have this role.
    """
    @rosetta_condition
    def cardinality_whoMaySubstitute(self):
        return check_cardinality(self.whoMaySubstitute, 1, 2)
    
    substitutionBeSpokeTerms: List[cdm.legaldocumentation.master.Clause.Clause] = Field([], description="Where parties describe any substitution terms e.g. for instance the election criteria for an Asset to be eligible as the Substitute Asset to the prior Affected Asset in terms of sector of activity, currency, market capitalisation, liquidity, volatility, or any additional features that parties would agree to take into considerations, etc.")
    """
    Where parties describe any substitution terms e.g. for instance the election criteria for an Asset to be eligible as the Substitute Asset to the prior Affected Asset in terms of sector of activity, currency, market capitalisation, liquidity, volatility, or any additional features that parties would agree to take into considerations, etc.
    """
    substitutionTriggerEvents: List[cdm.legaldocumentation.master.ExtraordinaryEvents.ExtraordinaryEvents] = Field([], description="Where the parties may optionnally explictly specify the list of Events to be considered as a trigger for a Substitution.")
    """
    Where the parties may optionnally explictly specify the list of Events to be considered as a trigger for a Substitution.
    """
    disputingParty: Optional[cdm.base.staticdata.party.CounterpartyRoleEnum.CounterpartyRoleEnum] = Field(None, description="Where the party who is not granted with the substitution role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of WhoMaySubstitute, yet PartyB could be Disputing Party in regard of such Role.")
    """
    Where the party who is not granted with the substitution role at least has a right to dispute the determination given by the counterparty with such role. As an example, a given PartyA is the unique Counterparty with the Role of WhoMaySubstitute, yet PartyB could be Disputing Party in regard of such Role.
    """
    
    @rosetta_condition
    def condition_0_DisputingPartyCannotHaveOriginalRole(self):
        item = self
        return any_elements(rosetta_resolve_attr(self, "whoMaySubstitute"), "<>", rosetta_resolve_attr(self, "disputingParty"))

import cdm 
import cdm.base.staticdata.party.CounterpartyRoleEnum
import cdm.legaldocumentation.master.Clause
import cdm.legaldocumentation.master.ExtraordinaryEvents
