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

__all__ = ['Identifier']


class Identifier(BaseDataClass):
    """
    A class to specify a generic identifier, applicable to CDM artefacts such as executions, contracts, lifecycle events and legal documents. An issuer can be associated with the actual identifier value as a way to properly qualify it.
    """
    issuerReference: Optional[AttributeWithReference | cdm.base.staticdata.party.Party.Party] = Field(None, description="The identifier issuer, when specified by reference to a party specified as part of the transaction.")
    """
    The identifier issuer, when specified by reference to a party specified as part of the transaction.
    """
    issuer: Optional[AttributeWithMeta[str] | str] = Field(None, description="The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).")
    """
    The identifier issuer, when specified explicitly alongside the identifier value (instead of being specified by reference to a party).
    """
    assignedIdentifier: List[cdm.base.staticdata.identifier.AssignedIdentifier.AssignedIdentifier] = Field([], description="The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.")
    """
    The identifier value. This level of indirection between the issuer and the identifier and its version provides the ability to associate multiple identifiers to one issuer, consistently with the FpML PartyTradeIdentifier.
    """
    @rosetta_condition
    def cardinality_assignedIdentifier(self):
        return check_cardinality(self.assignedIdentifier, 1, None)
    
    
    @rosetta_condition
    def condition_0_IssuerChoice(self):
        """
        The identifier issuer is specified either explicitly or by reference to one of the parties.
        """
        item = self
        return self.check_one_of_constraint('issuerReference', 'issuer', necessity=True)

import cdm 
import cdm.base.staticdata.party.Party
import cdm.base.staticdata.identifier.AssignedIdentifier
