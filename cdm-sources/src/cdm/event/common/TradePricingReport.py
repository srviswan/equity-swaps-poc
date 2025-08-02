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

__all__ = ['TradePricingReport']


class TradePricingReport(BaseDataClass):
    """
    The attributes that are specific for consensus based pricing reporting.
    """
    trade: cdm.event.common.Trade.Trade = Field(..., description="Represents the cosensus based pricing parameters on a trade basis.")
    """
    Represents the cosensus based pricing parameters on a trade basis.
    """
    pricingTime: cdm.base.datetime.TimeZone.TimeZone = Field(..., description="The regional exchange close time for the underlying contract,including time zone, at which the trades should be priced. This provides an indication for which regional snapshot should be used for pricing primarily for Global markets where there are multiple regional close times.")
    """
    The regional exchange close time for the underlying contract,including time zone, at which the trades should be priced. This provides an indication for which regional snapshot should be used for pricing primarily for Global markets where there are multiple regional close times.
    """
    discountingIndex: Optional[cdm.base.staticdata.asset.rates.FloatingRateIndexEnum.FloatingRateIndexEnum] = Field(None, description="It specifies the interest payable on collateral delivered under a CSA covering the trade.")
    """
    It specifies the interest payable on collateral delivered under a CSA covering the trade.
    """

import cdm 
import cdm.event.common.Trade
import cdm.base.datetime.TimeZone
import cdm.base.staticdata.asset.rates.FloatingRateIndexEnum
