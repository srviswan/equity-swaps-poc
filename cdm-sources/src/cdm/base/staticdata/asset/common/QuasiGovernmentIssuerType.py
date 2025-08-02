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

__all__ = ['QuasiGovernmentIssuerType']


class QuasiGovernmentIssuerType(BaseDataClass):
    """
    Represents a class to allow specification of different types of Quasi Government collateral.
    """
    sovereignEntity: bool = Field(..., description="True if sovereign entity (e.g. not separate legal personality from sovereign) or false if non-sovereign entity (e.g. separate legal personality from sovereign).")
    """
    True if sovereign entity (e.g. not separate legal personality from sovereign) or false if non-sovereign entity (e.g. separate legal personality from sovereign).
    """
    sovereignRecourse: Optional[bool] = Field(None, description="Applies to non-sovereign entity (e.g. separate legal personality from sovereign). True if entity has recourse to sovereign (e.g. debt guaranteed by government). False if entity does not have recourse to sovereign.")
    """
    Applies to non-sovereign entity (e.g. separate legal personality from sovereign).  True if entity has recourse to sovereign (e.g. debt guaranteed by government).  False if entity does not have recourse to sovereign.
    """
    
    @rosetta_condition
    def condition_0_NonSovereignEntityRecourse(self):
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "sovereignEntity"), "=", False)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "sovereignRecourse")), _then_fn0, _else_fn0)

import cdm 
