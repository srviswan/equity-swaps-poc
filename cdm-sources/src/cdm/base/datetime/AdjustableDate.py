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

__all__ = ['AdjustableDate']


class AdjustableDate(BaseDataClass):
    """
    A class for defining a date that shall be subject to adjustment if it would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
    """
    unadjustedDate: Optional[datetime.date] = Field(None, description="A date subject to adjustment. While in FpML this date is required, this cardinality constraint has been relaxed as part of the CDM in order to support the FRA representation, which effective and termination dates are specified in FpML as adjusted dates.")
    """
    A date subject to adjustment. While in FpML this date is required, this cardinality constraint has been relaxed as part of the CDM in order to support the FRA representation, which effective and termination dates are specified in FpML as adjusted dates.
    """
    dateAdjustments: Optional[cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.")
    """
    The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
    """
    dateAdjustmentsReference: Optional[AttributeWithReference | cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="A pointer style reference to date adjustments defined elsewhere in the document.")
    """
    A pointer style reference to date adjustments defined elsewhere in the document.
    """
    adjustedDate: Optional[AttributeWithMeta[datetime.date] | datetime.date] = Field(None, description="The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).")
    """
    The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
    """
    
    @rosetta_condition
    def condition_0_AdjustableDateChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('dateAdjustments', 'dateAdjustmentsReference', necessity=False)

import cdm 
import cdm.base.datetime.BusinessDayAdjustments
