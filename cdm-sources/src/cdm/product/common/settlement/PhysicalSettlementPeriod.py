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

__all__ = ['PhysicalSettlementPeriod']


class PhysicalSettlementPeriod(BaseDataClass):
    businessDaysNotSpecified: Optional[bool] = Field(None, description="An explicit indication that a number of business days are not specified and therefore ISDA fallback provisions should apply.")
    """
    An explicit indication that a number of business days are not specified and therefore ISDA fallback provisions should apply.
    """
    businessDays: Optional[int] = Field(None, description="A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.")
    """
    A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
    """
    maximumBusinessDays: Optional[int] = Field(None, description="A maximum number of business days. Its precise meaning is dependant on the context in which this element is used. Intended to be used to limit a particular ISDA fallback provision.")
    """
    A maximum number of business days. Its precise meaning is dependant on the context in which this element is used. Intended to be used to limit a particular ISDA fallback provision.
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('businessDaysNotSpecified', 'businessDays', 'maximumBusinessDays', necessity=True)
    
    @rosetta_condition
    def condition_1_BusinessDays(self):
        """
        FpML specifies businessDays as a NonNegativeInteger.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "businessDays"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "businessDays")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_MaximumBusinessDays(self):
        """
        FpML specifies maximumBusinessDays as a NonNegativeInteger.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "maximumBusinessDays"), ">=", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "maximumBusinessDays")), _then_fn0, _else_fn0)

import cdm 
