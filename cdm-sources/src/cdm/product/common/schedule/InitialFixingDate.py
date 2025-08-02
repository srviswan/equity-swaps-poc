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

__all__ = ['InitialFixingDate']


class InitialFixingDate(BaseDataClass):
    """
    A CDM class which purpose is to specify the initial fixing date either alongside the FpML interest rate specification as an offset of another date, or alongside the credit derivative specification as an unadjusted date.
    """
    relativeDateOffset: Optional[cdm.base.datetime.RelativeDateOffset.RelativeDateOffset] = Field(None, description="")
    initialFixingDate: Optional[datetime.date] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('relativeDateOffset', 'initialFixingDate', necessity=True)

import cdm 
import cdm.base.datetime.RelativeDateOffset
