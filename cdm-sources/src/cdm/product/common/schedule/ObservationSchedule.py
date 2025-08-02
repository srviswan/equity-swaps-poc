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

__all__ = ['ObservationSchedule']


class ObservationSchedule(BaseDataClass):
    """
    Specifies a single date on which market observations take place and specifies optional associated weighting.
    """
    observationDate: List[cdm.product.common.schedule.ObservationDate.ObservationDate] = Field([], description="Specifies an adjusted or unadjusted date for a market observation.")
    """
    Specifies an adjusted or unadjusted date for a market observation.
    """
    dateAdjustments: Optional[cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustments] = Field(None, description="The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.")
    """
    The business day convention and financial business centers used for adjusting the date if it would otherwise fall on a day that is not a business date in the specified business centers.
    """
    
    @rosetta_condition
    def condition_0_AdjustedDate(self):
        """
        FpML specifies a choice between adjustedDate and [unadjustedDate (required), dateAdjutsments (required), adjustedDate (optional)].
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "observationDate"), "unadjustedDate")) and rosetta_attr_exists(rosetta_resolve_attr(self, "dateAdjustments")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "observationDate"), "adjustedDate"))), _then_fn0, _else_fn0)

import cdm 
import cdm.product.common.schedule.ObservationDate
import cdm.base.datetime.BusinessDayAdjustments
