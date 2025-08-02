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

__all__ = ['MultipleValuationDates']

from cdm.observable.asset.SingleValuationDate import SingleValuationDate

class MultipleValuationDates(SingleValuationDate):
    businessDaysThereafter: Optional[int] = Field(None, description="The number of business days between successive valuation dates when multiple valuation dates are applicable for cash settlement. ISDA 2003 Term: Business Days thereafter.")
    """
    The number of business days between successive valuation dates when multiple valuation dates are applicable for cash settlement. ISDA 2003 Term: Business Days thereafter.
    """
    numberValuationDates: Optional[int] = Field(None, description="Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.")
    """
    Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
    """
    
    @rosetta_condition
    def condition_0_BusinessDaysThereafter(self):
        """
        FpML specifies businessDaysThereafter as a PositiveInteger.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "businessDaysThereafter"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "businessDaysThereafter")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_NumberValuationDates(self):
        """
        FpML specifies numberValuationDates as a PositiveInteger.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "numberValuationDates"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "numberValuationDates")), _then_fn0, _else_fn0)

import cdm 
