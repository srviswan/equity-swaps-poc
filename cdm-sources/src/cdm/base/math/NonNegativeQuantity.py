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

__all__ = ['NonNegativeQuantity']

from cdm.base.math.Quantity import Quantity

class NonNegativeQuantity(Quantity):
    """
    Specifies a quantity as a non-negative number, which condition is enforced through a data rule that only applies to the extending class.
    """
    
    @rosetta_condition
    def condition_0_NonNegativeQuantity_amount(self):
        """
        For a non-negative quantity, the amount attribute must be positive.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "value"), ">=", 0.0)

import cdm 
