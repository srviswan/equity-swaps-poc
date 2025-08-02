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

__all__ = ['Price']

from cdm.observable.asset.PriceSchedule import PriceSchedule

class Price(PriceSchedule):
    """
    Specifies a price as a single value to be associated to a financial product. This data type extends PriceSchedule and requires that only the amount value exists.
    """
    
    @rosetta_condition
    def condition_0_AmountOnlyExists(self):
        """
        The amount must exist when the price represents a single value, and steps must be absent.
        """
        item = self
        return (rosetta_attr_exists(rosetta_resolve_attr(self, "value")) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "datedValue"))))

import cdm 
