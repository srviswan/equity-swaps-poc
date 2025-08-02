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

__all__ = ['ReferencePool']


class ReferencePool(BaseDataClass):
    """
    This type contains all the reference pool items to define the reference entity and reference obligation(s) in the basket.
    """
    referencePoolItem: List[cdm.product.asset.ReferencePoolItem.ReferencePoolItem] = Field([], description="This type contains all the constituent weight and reference information.")
    """
    This type contains all the constituent weight and reference information.
    """
    @rosetta_condition
    def cardinality_referencePoolItem(self):
        return check_cardinality(self.referencePoolItem, 1, None)
    
    
    @rosetta_condition
    def condition_0_FpML_cd_44_openUnits(self):
        """
        FpML validation rule cd-44 - All referencePoolItem/constituentWeight must have the same name of child element.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "referencePoolItem"), "constituentWeight"), "basketPercentage")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "referencePoolItem"), "constituentWeight"), "openUnits")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_FpML_cd_44_basketPercentage(self):
        """
        FpML validation rule cd-44 - All referencePoolItem/constituentWeight must have the same name of child element.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "referencePoolItem"), "constituentWeight"), "openUnits")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "referencePoolItem"), "constituentWeight"), "basketPercentage")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.ReferencePoolItem
