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

__all__ = ['AveragingCalculationMethod']


class AveragingCalculationMethod(BaseDataClass):
    """
    Defines the ways in which multiple values can be aggregated into a single value.
    """
    isWeighted: bool = Field(..., description="Identifies whether the average values will be weighted or unweighted.")
    """
    Identifies whether the average values will be weighted or unweighted.
    """
    calculationMethod: cdm.base.math.AveragingCalculationMethodEnum.AveragingCalculationMethodEnum = Field(..., description="Identifies which of the Pythagorean means is being used to compute an average value.")
    """
    Identifies which of the Pythagorean means is being used to compute an average value.
    """

import cdm 
import cdm.base.math.AveragingCalculationMethodEnum
