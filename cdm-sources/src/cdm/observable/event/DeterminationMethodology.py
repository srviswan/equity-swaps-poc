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

__all__ = ['DeterminationMethodology']


class DeterminationMethodology(BaseDataClass):
    """
    Specifies the method according to which an amount or a date is determined.
    """
    determinationMethod: Optional[cdm.observable.common.DeterminationMethodEnum.DeterminationMethodEnum] = Field(None, description="Represents a more granular dimention of observation. Typically relevent for resolving a unique equity price, which can be expressed as trade-weighted or volume-weighted averages.")
    """
    Represents a more granular dimention of observation. Typically relevent for resolving a unique equity price, which can be expressed as trade-weighted or volume-weighted averages.
    """
    averagingMethod: Optional[cdm.base.math.AveragingCalculationMethodEnum.AveragingCalculationMethodEnum] = Field(None, description="Specifies enumerations for the type of averaging calculation.")
    """
    Specifies enumerations for the type of averaging calculation.
    """

import cdm 
import cdm.observable.common.DeterminationMethodEnum
import cdm.base.math.AveragingCalculationMethodEnum
