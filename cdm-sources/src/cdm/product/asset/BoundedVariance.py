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

__all__ = ['BoundedVariance']


class BoundedVariance(BaseDataClass):
    realisedVarianceMethod: cdm.product.asset.RealisedVarianceMethodEnum.RealisedVarianceMethodEnum = Field(..., description="The contract specifies which price must satisfy the boundary condition.")
    """
    The contract specifies which price must satisfy the boundary condition.
    """
    daysInRangeAdjustment: bool = Field(..., description="The contract specifies whether the notional should be scaled by the Number of Days in Range divided by the Expected N. The number of Days in Ranges refers to the number of returns that contribute to the realized volatility.")
    """
    The contract specifies whether the notional should be scaled by the Number of Days in Range divided by the Expected N. The number of Days in Ranges refers to the number of returns that contribute to the realized volatility.
    """
    upperBarrier: Optional[Decimal] = Field(None, description="All observations above this price level will be excluded from the variance calculation.")
    """
    All observations above this price level will be excluded from the variance calculation.
    """
    lowerBarrier: Optional[Decimal] = Field(None, description="All observations below this price level will be excluded from the variance calculation.")
    """
    All observations below this price level will be excluded from the variance calculation.
    """
    
    @rosetta_condition
    def condition_0_NonNegativeBarriers(self):
        """
        Barriers cannot be set to negative values
        """
        item = self
        def _then_fn1():
            return all_elements(rosetta_resolve_attr(self, "lowerBarrier"), ">=", 0)
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "upperBarrier"), ">=", 0) and if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "lowerBarrier")), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "upperBarrier")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.RealisedVarianceMethodEnum
