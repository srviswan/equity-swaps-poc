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

__all__ = ['InterestRateIndex']


class InterestRateIndex(BaseDataClass):
    """
    An index based in interest rates or inflation rates in a certain market.
    """
    FloatingRateIndex: Optional[cdm.observable.asset.FloatingRateIndex.FloatingRateIndex] = Field(None, description="An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.")
    """
    An interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
    """
    InflationIndex: Optional[cdm.observable.asset.InflationIndex.InflationIndex] = Field(None, description="An index that measures inflation in a specific market, e.g. the US Consumer Price Index.")
    """
    An index that measures inflation in a specific market, e.g. the US Consumer Price Index.
    """
    
    @rosetta_condition
    def condition_0_Choice(self):
        item = self
        return self.check_one_of_constraint('FloatingRateIndex', 'InflationIndex', necessity=True)

import cdm 
import cdm.observable.asset.FloatingRateIndex
import cdm.observable.asset.InflationIndex
