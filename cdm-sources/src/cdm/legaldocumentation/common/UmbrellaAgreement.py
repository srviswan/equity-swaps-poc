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

__all__ = ['UmbrellaAgreement']


class UmbrellaAgreement(BaseDataClass):
    """
    A class to specify a set of legal entities which are part of a legal agreement beyond the two contracting parties to that agreement. This data representation reflects the ISDA Create representation.
    """
    isApplicable: bool = Field(..., description="The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)")
    """
    The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)
    """
    language: Optional[str] = Field(None, description="The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.")
    """
    The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.
    """
    parties: List[cdm.legaldocumentation.common.UmbrellaAgreementEntity.UmbrellaAgreementEntity] = Field([], description="Underlying principals to the umbrella agreement.")
    """
    Underlying principals to the umbrella agreement.
    """
    
    @rosetta_condition
    def condition_0_UmbrellaAgreementExists(self):
        """
        Umbrella Agreement language and parties should not exist when Umbrella Agreement terms are Not Applicable.
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "language")) and rosetta_attr_exists(rosetta_resolve_attr(self, "parties")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "isApplicable"), "=", True), _then_fn0, _else_fn0)

import cdm 
import cdm.legaldocumentation.common.UmbrellaAgreementEntity
