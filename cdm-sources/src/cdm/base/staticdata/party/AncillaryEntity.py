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

__all__ = ['AncillaryEntity']


class AncillaryEntity(BaseDataClass):
    """
    Holds an identifier for an ancillary entity, either identified directly via its ancillary role or directly as a legal entity.
    """
    ancillaryParty: Optional[cdm.base.staticdata.party.AncillaryRoleEnum.AncillaryRoleEnum] = Field(None, description="Identifies a party via its ancillary role on a transaction (e.g. CCP or DCO through which the trade should be cleared.)")
    """
    Identifies a party via its ancillary role on a transaction (e.g. CCP or DCO through which the trade should be cleared.)
    """
    legalEntity: Optional[cdm.base.staticdata.party.LegalEntity.LegalEntity] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('ancillaryParty', 'legalEntity', necessity=True)

import cdm 
import cdm.base.staticdata.party.AncillaryRoleEnum
import cdm.base.staticdata.party.LegalEntity
