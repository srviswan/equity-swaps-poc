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

__all__ = ['AdjustableOrRelativeDates']


class AdjustableOrRelativeDates(BaseDataClass):
    """
    A class giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments or as relative to some other series of (anchor) dates.
    """
    adjustableDates: Optional[cdm.base.datetime.AdjustableDates.AdjustableDates] = Field(None, description="A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.")
    """
    A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
    """
    relativeDates: Optional[cdm.base.datetime.RelativeDates.RelativeDates] = Field(None, description="A series of dates specified as some offset to another series of dates (the anchor dates).")
    """
    A series of dates specified as some offset to another series of dates (the anchor dates).
    """
    
    @rosetta_condition
    def condition_0_AdjustableOrRelativeDatesChoice(self):
        """
        Choice rule to represent an FpML choice construct.
        """
        item = self
        return self.check_one_of_constraint('adjustableDates', 'relativeDates', necessity=True)

import cdm 
import cdm.base.datetime.AdjustableDates
import cdm.base.datetime.RelativeDates
