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

__all__ = ['SwapCurveValuation']


class SwapCurveValuation(BaseDataClass):
    """
    A class to specify a valuation swap curve, which is used as part of the strike construct for the bond and convertible bond options.
    """
    floatingRateIndex: cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum = Field(..., description="")
    indexTenor: Optional[cdm.base.datetime.Period.Period] = Field(None, description="The ISDA Designated Maturity, i.e. the tenor of the floating rate.")
    """
    The ISDA Designated Maturity, i.e. the tenor of the floating rate.
    """
    spread: Decimal = Field(..., description="Spread in basis points over the floating rate index.")
    """
    Spread in basis points over the floating rate index.
    """
    side: Optional[cdm.observable.asset.QuotationSideEnum.QuotationSideEnum] = Field(None, description="The side (bid/mid/ask) of the measure.")
    """
    The side (bid/mid/ask) of the measure.
    """

import cdm 
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum
import cdm.base.datetime.Period
import cdm.observable.asset.QuotationSideEnum
