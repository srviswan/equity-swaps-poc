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

__all__ = ['Clause']


class Clause(BaseDataClass):
    """
    A type for documenting additional clause that cannot yet be represented with the model and yet needed for a digital representation of the agreement
    """
    identifier: Optional[str] = Field(None, description="The name or identifier associated to this clause ")
    """
    The  name or identifier associated to this clause 
    """
    terms: Optional[str] = Field(None, description="Content of this bespoke clause")
    """
    Content of this bespoke clause
    """
    subcomponents: List[cdm.legaldocumentation.master.Clause.Clause] = Field([], description="Additional hierarchichal components of the clause if relevant")
    """
    Additional hierarchichal components of the clause if relevant
    """
    
    @rosetta_condition
    def condition_0_(self):
        """
        The Clause should describe at least the additional terms,  additional subcomponents or both
        """
        item = self
        return self.check_one_of_constraint('terms', 'subcomponents', necessity=False)

import cdm 
import cdm.legaldocumentation.master.Clause
