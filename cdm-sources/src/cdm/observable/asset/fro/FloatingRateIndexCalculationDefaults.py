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

__all__ = ['FloatingRateIndexCalculationDefaults']


class FloatingRateIndexCalculationDefaults(BaseDataClass):
    """
    This holds the rate calculation defaults applicable for a floating rate index.
    """
    category: Optional[cdm.observable.asset.fro.FloatingRateIndexCategoryEnum.FloatingRateIndexCategoryEnum] = Field(None, description="The ISDA FRO category (e.g. screen rate or calculated rate).")
    """
    The ISDA FRO category (e.g. screen rate or calculated rate).
    """
    indexStyle: Optional[cdm.observable.asset.fro.FloatingRateIndexStyleEnum.FloatingRateIndexStyleEnum] = Field(None, description="The ISDA FRO style (e.g. term rate, swap rate, etc).")
    """
    The ISDA FRO style (e.g. term rate, swap rate, etc).
    """
    method: Optional[cdm.observable.asset.fro.FloatingRateIndexCalculationMethodEnum.FloatingRateIndexCalculationMethodEnum] = Field(None, description="The ISDA FRO calculation method (e.g. OIS Compounding).")
    """
    The ISDA FRO calculation method (e.g. OIS Compounding).
    """

import cdm 
import cdm.observable.asset.fro.FloatingRateIndexCategoryEnum
import cdm.observable.asset.fro.FloatingRateIndexStyleEnum
import cdm.observable.asset.fro.FloatingRateIndexCalculationMethodEnum
