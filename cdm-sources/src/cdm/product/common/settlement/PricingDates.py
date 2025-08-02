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

__all__ = ['PricingDates']


class PricingDates(BaseDataClass):
    """
    Specifies specific dates or parametric rules for the dates on which the price will be determined
    """
    specifiedDates: List[cdm.base.datetime.AdjustableDates.AdjustableDates] = Field([], description="Defines specified dates on which the price will be determined.")
    """
    Defines specified dates on which the price will be determined.
    """
    parametricDates: Optional[cdm.product.common.schedule.ParametricDates.ParametricDates] = Field(None, description="Defines rules for the dates on which the price will be determined.")
    """
    Defines rules for the dates on which the price will be determined.
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('specifiedDates', 'parametricDates', necessity=True)

import cdm 
import cdm.base.datetime.AdjustableDates
import cdm.product.common.schedule.ParametricDates
