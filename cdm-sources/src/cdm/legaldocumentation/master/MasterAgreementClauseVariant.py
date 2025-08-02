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

__all__ = ['MasterAgreementClauseVariant']


class MasterAgreementClauseVariant(BaseDataClass):
    """
    Sets the details for a specific variant associated to a clause in a Master Agreement
    """
    identifier: cdm.legaldocumentation.master.MasterAgreementVariantIdentifierEnum.MasterAgreementVariantIdentifierEnum = Field(..., description="Unique identifier for this variant")
    """
    Unique identifier for this variant
    """
    name: Optional[str] = Field(None, description="Optional textual description of the variant.")
    """
    Optional textual description of the variant.
    """
    counterparty: List[cdm.base.staticdata.party.CounterpartyRoleEnum.CounterpartyRoleEnum] = Field([], description="Optional counterparty role. This can be used where a clause needs to assign a different variant to the different parties on the agreement based upon their role i.e. Party A or Party B.")
    """
    Optional counterparty role. This can be used where a clause needs to assign a different variant to the different parties on the agreement based upon their role i.e. Party A or Party B.
    """
    @rosetta_condition
    def cardinality_counterparty(self):
        return check_cardinality(self.counterparty, 0, 2)
    
    otherParty: List[cdm.base.staticdata.party.PartyRoleEnum.PartyRoleEnum] = Field([], description="Optional party. This can be used where a clause needs to assign different variants to different parties who may or may not be on the agreement.")
    """
    Optional party. This can be used where a clause needs to assign different variants to different parties who may or may not be on the agreement.
    """
    variableSet: List[cdm.legaldocumentation.master.MasterAgreementVariableSet.MasterAgreementVariableSet] = Field([], description="For some variants of some clauses additional details are required to work out what has been elected. This array can be used to define the name and value of these variables. Please refer to the agreement documentation for more details of the variables that are available for any clause.")
    """
    For some variants of some clauses additional details are required to work out what has been elected. This array can be used to define the name and value of these variables. Please refer to the agreement documentation for more details of the variables that are available for any clause.
    """

import cdm 
import cdm.legaldocumentation.master.MasterAgreementVariantIdentifierEnum
import cdm.base.staticdata.party.CounterpartyRoleEnum
import cdm.base.staticdata.party.PartyRoleEnum
import cdm.legaldocumentation.master.MasterAgreementVariableSet
