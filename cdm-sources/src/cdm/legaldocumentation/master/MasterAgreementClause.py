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

__all__ = ['MasterAgreementClause']


class MasterAgreementClause(BaseDataClass):
    """
    Defines clauses that make up a Master Agreement
    """
    identifer: cdm.legaldocumentation.master.MasterAgreementClauseIdentifierEnum.MasterAgreementClauseIdentifierEnum = Field(..., description="Unique identifier for the clause")
    """
    Unique identifier for the clause
    """
    name: Optional[str] = Field(None, description="Optional textual description of the clause.")
    """
    Optional textual description of the clause.
    """
    counterparty: List[cdm.base.staticdata.party.CounterpartyRoleEnum.CounterpartyRoleEnum] = Field([], description="Optional counterparty role. This can be used where a clause needs to be assigned to a specific party on the agreement based upon their role i.e. Party A or Party B.")
    """
    Optional counterparty role. This can be used where a clause needs to be assigned to a specific party on the agreement based upon their role i.e. Party A or Party B.
    """
    @rosetta_condition
    def cardinality_counterparty(self):
        return check_cardinality(self.counterparty, 0, 2)
    
    otherParty: List[cdm.base.staticdata.party.PartyRoleEnum.PartyRoleEnum] = Field([], description="Optional party. This can be required for umbrella agreements where a clause may need to be assigned to a specific party who may or may not be on the agreement.")
    """
    Optional party. This can be required for umbrella agreements where a clause may need to be assigned to a specific party who may or may not be on the agreement.
    """
    variant: List[cdm.legaldocumentation.master.MasterAgreementClauseVariant.MasterAgreementClauseVariant] = Field([], description="Allows multiple variants to be defined for a clause. This needs to be an array as some clauses can specify different variants for different parties. At least one variant must be specified for a clause.")
    """
    Allows multiple variants to be defined for a clause. This needs to be an array as some clauses can specify different variants for different parties. At least one variant must be specified for a clause.
    """
    @rosetta_condition
    def cardinality_variant(self):
        return check_cardinality(self.variant, 1, None)
    

import cdm 
import cdm.legaldocumentation.master.MasterAgreementClauseIdentifierEnum
import cdm.base.staticdata.party.CounterpartyRoleEnum
import cdm.base.staticdata.party.PartyRoleEnum
import cdm.legaldocumentation.master.MasterAgreementClauseVariant
