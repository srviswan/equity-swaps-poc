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

__all__ = ['SingleValuationDate']


class SingleValuationDate(BaseDataClass):
    """
    A class to specify the number of business days after satisfaction of all conditions to settlement.
    """
    businessDays: Optional[int] = Field(None, description="A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.")
    """
    A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
    """
    
    @rosetta_condition
    def condition_0_NonNegativeBusinessDays(self):
        """
        FpML specifies businessDays as a NonNegativeInteger.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "businessDays"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "businessDays")), _then_fn0, _else_fn0)

import cdm 
