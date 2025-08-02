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

__all__ = ['ObservationDate']


class ObservationDate(BaseDataClass):
    """
    Specifies a single date on which market observations take place and specifies optional associated weighting.
    """
    unadjustedDate: Optional[datetime.date] = Field(None, description="A date subject to adjustment.")
    """
    A date subject to adjustment.
    """
    adjustedDate: Optional[datetime.date] = Field(None, description="The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).")
    """
    The date once the adjustment has been performed. (Note that this date may change if the business center holidays change).
    """
    weight: Optional[Decimal] = Field(None, description="Specifies the degree of importance of the observation.")
    """
    Specifies the degree of importance of the observation.
    """
    observationReference: Optional[str] = Field(None, description="Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.")
    """
    Specifies an identification key for the market observation. This attribute can be used as a reference to assign weights to a series of dates defined in a parametricSchedule.
    """
    
    @rosetta_condition
    def condition_0_ObservationDate(self):
        """
        Either an unadjusted date or an adjusted date needs to be specified.
        """
        item = self
        return self.check_one_of_constraint('unadjustedDate', 'adjustedDate', necessity=True)

import cdm 
