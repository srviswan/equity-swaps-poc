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

__all__ = ['FxRateSourceFixing']


class FxRateSourceFixing(BaseDataClass):
    """
    Describes a rate source to be fixed and the date the fixing occurs
    """
    settlementRateSource: cdm.observable.asset.FxSettlementRateSource.FxSettlementRateSource = Field(..., description="")
    fixingDate: cdm.base.datetime.AdjustableDate.AdjustableDate = Field(..., description="The date on which the fixing is scheduled to occur.")
    """
    The date on which the fixing is scheduled to occur.
    """

import cdm 
import cdm.observable.asset.FxSettlementRateSource
import cdm.base.datetime.AdjustableDate
