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

__all__ = ['FxLinkedNotionalAmount']


class FxLinkedNotionalAmount(BaseDataClass):
    """
    A data to:  describe the cashflow representation for FX linked notionals.
    """
    resetDate: Optional[datetime.date] = Field(None, description="The reset date.")
    """
    The reset date.
    """
    adjustedFxSpotFixingDate: Optional[datetime.date] = Field(None, description="The date on which the FX spot rate is observed. This date should already be adjusted for any applicable business day convention.")
    """
    The date on which the FX spot rate is observed. This date should already be adjusted for any applicable business day convention.
    """
    observedFxSpotRate: Optional[Decimal] = Field(None, description="The actual observed FX spot rate.")
    """
    The actual observed FX spot rate.
    """
    notionalAmount: Optional[Decimal] = Field(None, description="The calculation period notional amount.")
    """
    The calculation period notional amount.
    """

import cdm 
