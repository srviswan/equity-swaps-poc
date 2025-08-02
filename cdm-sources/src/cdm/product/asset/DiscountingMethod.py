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

__all__ = ['DiscountingMethod']


class DiscountingMethod(BaseDataClass):
    """
    A data defining:  discounting information. The 2000 ISDA definitions, section 8.4. discounting (related to the calculation of a discounted fixed amount or floating amount) apply. This type must only be included if discounting applies.
    """
    discountingType: cdm.product.asset.DiscountingTypeEnum.DiscountingTypeEnum = Field(..., description="The discounting method that is applicable.")
    """
    The discounting method that is applicable.
    """
    discountRate: Optional[Decimal] = Field(None, description="A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.")
    """
    A discount rate, expressed as a decimal, to be used in the calculation of a discounted amount. A discount amount of 5% would be represented as 0.05.
    """
    discountRateDayCountFraction: Optional[AttributeWithMeta[cdm.base.datetime.daycount.DayCountFractionEnum.DayCountFractionEnum] | cdm.base.datetime.daycount.DayCountFractionEnum.DayCountFractionEnum] = Field(None, description="A discount day count fraction to be used in the calculation of a discounted amount.")
    """
    A discount day count fraction to be used in the calculation of a discounted amount.
    """
    
    @rosetta_condition
    def condition_0_DiscountRate(self):
        """
        In FpML discountingRate and discountRateDayCountFraction are part of an optional node, with discountingRate as the required element as part of that node.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "discountRate"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "discountRateDayCountFraction")), _then_fn0, _else_fn0)

import cdm 
import cdm.product.asset.DiscountingTypeEnum
import cdm.base.datetime.daycount.DayCountFractionEnum
