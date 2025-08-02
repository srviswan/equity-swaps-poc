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

__all__ = ['FloatingRateIndex']

from cdm.observable.asset.IndexBase import IndexBase

class FloatingRateIndex(IndexBase):
    """
    Specification of an interest rate index which can change over time, e.g. the SONIA (Sterling Overnight Index Average) in the UK.
    """
    floatingRateIndex: AttributeWithMeta[cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum] | cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum = Field(..., description="The reference index that is used to specify the floating interest rate.")
    """
    The reference index that is used to specify the floating interest rate.
    """
    indexTenor: Optional[cdm.base.datetime.Period.Period] = Field(None, description="The ISDA Designated Maturity, i.e. the floating rate tenor.")
    """
    The ISDA Designated Maturity, i.e. the floating rate tenor.
    """
    
    @rosetta_condition
    def condition_0_InterestRateAssetClass(self):
        """
        The asset class must be Interest Rate.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(AssetClassEnum, "INTEREST_RATE"))

import cdm 
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum
import cdm.base.datetime.Period
from cdm.base.staticdata.asset.common.AssetClassEnum import AssetClassEnum
