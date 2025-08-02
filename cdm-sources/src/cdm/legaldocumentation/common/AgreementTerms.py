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

__all__ = ['AgreementTerms']


class AgreementTerms(BaseDataClass):
    """
    Specification of the content of a legal agreement.
    """
    agreement: cdm.legaldocumentation.contract.Agreement.Agreement = Field(..., description="Specification of the standard set of terms that define a legal agreement.")
    """
    Specification of the standard set of terms that define a legal agreement.
    """
    clauseLibrary: Optional[bool] = Field(None, description="Specification of whether the agreement terms have been negotiated using the clause library methodology.")
    """
    Specification of whether the agreement terms have been negotiated using the clause library methodology.
    """
    counterparty: List[cdm.base.staticdata.party.Counterparty.Counterparty] = Field([], description="Specification of the roles of the counterparties to the agreement.")
    """
    Specification of the roles of the counterparties to the agreement.
    """
    @rosetta_condition
    def cardinality_counterparty(self):
        return check_cardinality(self.counterparty, 2, 2)
    

import cdm 
import cdm.legaldocumentation.contract.Agreement
import cdm.base.staticdata.party.Counterparty
