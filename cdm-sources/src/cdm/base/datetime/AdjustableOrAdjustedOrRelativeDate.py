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

__all__ = ['AdjustableOrAdjustedOrRelativeDate']


class AdjustableOrAdjustedOrRelativeDate(BaseDataClass):
    """
    This Rosetta class specifies the date as either an unadjusted, adjusted or relative date. It supplements the features of the AdjustableOrAdjustedDate to support the credit default swap option premium, which uses the relative date construct.
    """
    unadjustedDate: Optional[datetime.date] = Field(None, description="A date subject to adjustment.")
    """
    A date subject to adjustment.
    """
    dateAdjustments: Optional[cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.")
    """
    The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
    """
    adjustedDate: Optional[AttributeWithMeta[datetime.date] | datetime.date] = Field(None, description="The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).")
    """
    The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
    """
    relativeDate: Optional[cdm.base.datetime.RelativeDateOffset.RelativeDateOffset] = Field(None, description="A date specified as some offset to another date (the anchor date).")
    """
    A date specified as some offset to another date (the anchor date).
    """
    
    @rosetta_condition
    def condition_0_AdjustedDate(self):
        """
        This data rule extends the data rule AdjustableOrAdjustedDate_adjustedDate by specifying logic applicable to the relative date.
        """
        item = self
        return (((rosetta_attr_exists(rosetta_resolve_attr(self, "adjustedDate")) or rosetta_attr_exists(rosetta_resolve_attr(self, "relativeDate"))) or rosetta_attr_exists(rosetta_resolve_attr(self, "unadjustedDate"))) or ((rosetta_attr_exists(rosetta_resolve_attr(self, "unadjustedDate")) and rosetta_attr_exists(rosetta_resolve_attr(self, "dateAdjustments"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "adjustedDate")))))

import cdm 
import cdm.base.datetime.BusinessDayAdjustments
import cdm.base.datetime.RelativeDateOffset
