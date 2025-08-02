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

__all__ = ['MultipleCreditNotations']


class MultipleCreditNotations(BaseDataClass):
    """
    Represetns a class to specify multiple credit notations alongside a conditional 'any' or 'all' qualifier.
    """
    condition: cdm.base.math.QuantifierEnum.QuantifierEnum = Field(..., description="An enumerated element, to qualify whether All or Any credit notation applies.")
    """
    An enumerated element, to qualify whether All or Any credit notation applies.
    """
    creditNotation: List[AttributeWithMeta[cdm.observable.asset.CreditNotation.CreditNotation] | cdm.observable.asset.CreditNotation.CreditNotation] = Field([], description="At least two credit notations much be specified.")
    """
    At least two credit notations much be specified.
    """
    @rosetta_condition
    def cardinality_creditNotation(self):
        return check_cardinality(self.creditNotation, 2, None)
    
    mismatchResolution: Optional[cdm.observable.asset.CreditNotationMismatchResolutionEnum.CreditNotationMismatchResolutionEnum] = Field(None, description="")
    referenceAgency: Optional[cdm.observable.asset.CreditRatingAgencyEnum.CreditRatingAgencyEnum] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_ReferenceAgency(self):
        """
        If the mismatch resolution is ReferenceAgency, ensure that the reference agency is specified.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "referenceAgency"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "mismatchResolution"), "=", rosetta_resolve_attr(CreditNotationMismatchResolutionEnum, "REFERENCE_AGENCY")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.math.QuantifierEnum
import cdm.observable.asset.CreditNotation
import cdm.observable.asset.CreditNotationMismatchResolutionEnum
import cdm.observable.asset.CreditRatingAgencyEnum
from cdm.observable.asset.CreditNotationMismatchResolutionEnum import CreditNotationMismatchResolutionEnum
