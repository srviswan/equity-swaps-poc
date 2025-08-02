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

__all__ = ['NonNegativeQuantitySchedule']

from cdm.base.math.QuantitySchedule import QuantitySchedule

class NonNegativeQuantitySchedule(QuantitySchedule):
    
    @rosetta_condition
    def condition_0_NonNegativeQuantity_amount(self):
        """
        For a non-negative quantity, all amount attribute must be positive.
        """
        item = self
        def _then_fn1():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "datedValue"), "value"), ">=", 0.0)
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "value"), ">=", 0.0) and if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "datedValue")), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "value")), _then_fn0, _else_fn0)

import cdm 
