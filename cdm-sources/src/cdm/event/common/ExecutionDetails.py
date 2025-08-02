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

__all__ = ['ExecutionDetails']


class ExecutionDetails(BaseDataClass):
    """
    Defines specific attributes that relate to trade executions.
    """
    executionType: cdm.event.common.ExecutionTypeEnum.ExecutionTypeEnum = Field(..., description="Identifies the type of execution, e.g. via voice, electronically...")
    """
    Identifies the type of execution, e.g. via voice, electronically...
    """
    executionVenue: Optional[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="Represents the venue on which a trade was executed.")
    """
    Represents the venue on which a trade was executed.
    """
    packageReference: Optional[cdm.base.staticdata.identifier.IdentifiedList.IdentifiedList] = Field(None, description="A reference to the package linking the trade with other trades, in case the trade was executed as part of a package (hence this attribute is optional).")
    """
    A reference to the package linking the trade with other trades, in case the trade was executed as part of a package (hence this attribute is optional).
    """
    
    @rosetta_condition
    def condition_0_ExecutionVenue(self):
        """
        When the execution type is set to 'Electronically', the execution venue must be specified.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "executionVenue"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "executionType"), "=", rosetta_resolve_attr(ExecutionTypeEnum, "ELECTRONIC")), _then_fn0, _else_fn0)

import cdm 
import cdm.event.common.ExecutionTypeEnum
import cdm.base.staticdata.party.LegalEntity
import cdm.base.staticdata.identifier.IdentifiedList
from cdm.event.common.ExecutionTypeEnum import ExecutionTypeEnum
