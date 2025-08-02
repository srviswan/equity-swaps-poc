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

__all__ = ['LocationIdentifier']

from cdm.base.staticdata.identifier.Identifier import Identifier

class LocationIdentifier(Identifier):
    """
    Specifies a location identifier. An issuer and an identifier type can be associated with the actual identifier value as a way to properly qualify it.
    """
    locationIdentifierType: Optional[cdm.base.staticdata.identifier.CommodityLocationIdentifierTypeEnum.CommodityLocationIdentifierTypeEnum] = Field(None, description="Specifies the nature of a location identifier.")
    """
    Specifies the nature of a location identifier.
    """
    
    @rosetta_condition
    def condition_0_IdentifierType(self):
        """
        The element specifying the nature of a location identifier can only be applied to a single identifier.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_count(rosetta_resolve_attr(self, "assignedIdentifier")), "=", 1)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "locationIdentifierType")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.identifier.CommodityLocationIdentifierTypeEnum
