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

__all__ = ['PeriodBound']


class PeriodBound(BaseDataClass):
    """
    Indicator to specify if the period bound is defined as a period and whether the bound is inclusive.
    """
    period: cdm.base.datetime.Period.Period = Field(..., description="Specifies the period is to be used as the bound, e.g. 5Y.")
    """
    Specifies the period is to be used as the bound, e.g. 5Y.
    """
    inclusive: bool = Field(..., description="Specifies whether the period bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.")
    """
    Specifies whether the period bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
    """

import cdm 
import cdm.base.datetime.Period
