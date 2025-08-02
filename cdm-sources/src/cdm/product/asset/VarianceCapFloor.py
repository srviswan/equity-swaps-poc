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

__all__ = ['VarianceCapFloor']


class VarianceCapFloor(BaseDataClass):
    varianceCap: bool = Field(..., description="If present and true, then variance cap is applicable.")
    """
    If present and true, then variance cap is applicable.
    """
    unadjustedVarianceCap: Optional[Decimal] = Field(None, description="For use when varianceCap is applicable. Contains the scaling factor of the Variance Cap that can differ on a trade-by-trade basis in the European market. For example, a Variance Cap of 2.5^2 x Variance Strike Price has an unadjustedVarianceCap of 2.5.")
    """
    For use when varianceCap is applicable. Contains the scaling factor of the Variance Cap that can differ on a trade-by-trade basis in the European market. For example, a Variance Cap of 2.5^2 x Variance Strike Price has an unadjustedVarianceCap of 2.5.
    """
    boundedVariance: Optional[cdm.product.asset.BoundedVariance.BoundedVariance] = Field(None, description="Conditions which bound variance. The contract specifies one or more boundary levels. These levels are expressed as prices for confirmation purposes Underlyer price must be equal to or higher than Lower Barrier is known as Up Conditional Swap Underlyer price must be equal to or lower than Upper Barrier is known as Down Conditional Swap Underlyer price must be equal to or higher than Lower Barrier and must be equal to or lower than Upper Barrier is known as Barrier Conditional Swap.")
    """
    Conditions which bound variance. The contract specifies one or more boundary levels. These levels are expressed as prices for confirmation purposes Underlyer price must be equal to or higher than Lower Barrier is known as Up Conditional Swap Underlyer price must be equal to or lower than Upper Barrier is known as Down Conditional Swap Underlyer price must be equal to or higher than Lower Barrier and must be equal to or lower than Upper Barrier is known as Barrier Conditional Swap.
    """
    
    @rosetta_condition
    def condition_0_PositiveUnadjustedVarianceCap(self):
        """
        Unadjusted variance cap must be positive
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "unadjustedVarianceCap"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "unadjustedVarianceCap")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_CapFloorApplicability(self):
        """
        Caps/floors can and must be specified if varianceCap is set to true. If false, barriers cannot be established
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "unadjustedVarianceCap")) or rosetta_attr_exists(rosetta_resolve_attr(self, "boundedVariance")))
        
        def _else_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "unadjustedVarianceCap"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "boundedVariance"))))
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "varianceCap"), "=", True), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.BoundedVariance
