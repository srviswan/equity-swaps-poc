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

__all__ = ['FloatingRateIndexDefinition']


class FloatingRateIndexDefinition(BaseDataClass):
    fro: cdm.observable.asset.fro.FloatingRateIndexIdentification.FloatingRateIndexIdentification = Field(..., description="The underlying FRO name and designated maturity.")
    """
    The underlying FRO name and designated maturity.
    """
    calculationDefaults: Optional[cdm.observable.asset.fro.FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaults] = Field(None, description="Any calculation default values.")
    """
    Any calculation default values.
    """

import cdm 
import cdm.observable.asset.fro.FloatingRateIndexIdentification
import cdm.observable.asset.fro.FloatingRateIndexCalculationDefaults
