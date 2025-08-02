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

__all__ = ['FixedPrice']


class FixedPrice(BaseDataClass):
    """
    A predefined price accorded by the counterparties.
    """
    price: Optional[AttributeWithAddress[cdm.observable.asset.PriceSchedule.PriceSchedule] | cdm.observable.asset.PriceSchedule.PriceSchedule] = Field(None, description="Fixed price step schedule, including an initial price specified as an absolute number.")
    """
    Fixed price step schedule, including an initial price specified as an absolute number.
    """
    
    @rosetta_condition
    def condition_0_NonNegativePrice_amount(self):
        """
        For a non-negative price, the amount attribute must be positive.
        """
        item = self
        def _then_fn1():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "price"), "datedValue"), "value"), ">=", 0.0)
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "price"), "value"), ">=", 0.0) and if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "price"), "datedValue")), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "price"), "value")), _then_fn0, _else_fn0)

import cdm 
import cdm.observable.asset.PriceSchedule
