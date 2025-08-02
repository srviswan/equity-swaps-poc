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

__all__ = ['EquityAdditionalTerms']


class EquityAdditionalTerms(BaseDataClass):
    """
    Transaction AdditionalTerms that apply to Equity asset class.
    """
    extraordinaryEvents: Optional[cdm.legaldocumentation.master.ExtraordinaryEvents.ExtraordinaryEvents] = Field(None, description="")
    determinationTerms: List[cdm.legaldocumentation.master.DeterminationRolesAndTerms.DeterminationRolesAndTerms] = Field([], description="")
    @rosetta_condition
    def cardinality_determinationTerms(self):
        return check_cardinality(self.determinationTerms, 1, None)
    
    substitutionProvision: Optional[cdm.legaldocumentation.master.UnderlierSubstitutionProvision.UnderlierSubstitutionProvision] = Field(None, description="")

import cdm 
import cdm.legaldocumentation.master.ExtraordinaryEvents
import cdm.legaldocumentation.master.DeterminationRolesAndTerms
import cdm.legaldocumentation.master.UnderlierSubstitutionProvision
