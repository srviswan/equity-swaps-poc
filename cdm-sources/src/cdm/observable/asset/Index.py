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

__all__ = ['Index']


class Index(BaseDataClass):
    """
    An Index is an Observable which is computed based on the prices, rates or valuations of a number of assets that are tracked in a standardized way.  Examples include equity market indices as well as indices on interest rates, inflation and credit instruments.
    """
    CreditIndex: Optional[cdm.observable.asset.CreditIndex.CreditIndex] = Field(None, description="An index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.")
    """
    An index based on credit risk, typically composed using corporate debt instruments in a region or industry sector, e.g. the iTraxx indices.
    """
    EquityIndex: Optional[cdm.observable.asset.EquityIndex.EquityIndex] = Field(None, description="An index based on equity securities, e.g. the S&P 500.")
    """
    An index based on equity securities, e.g. the S&P 500.
    """
    InterestRateIndex: Optional[AttributeWithMeta[cdm.observable.asset.InterestRateIndex.InterestRateIndex] | cdm.observable.asset.InterestRateIndex.InterestRateIndex] = Field(None, description="An index based in interest rates or inflation rates in a certain market.")
    """
    An index based in interest rates or inflation rates in a certain market.
    """
    ForeignExchangeRateIndex: Optional[cdm.observable.asset.ForeignExchangeRateIndex.ForeignExchangeRateIndex] = Field(None, description="A rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.")
    """
    A rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
    """
    OtherIndex: Optional[cdm.observable.asset.OtherIndex.OtherIndex] = Field(None, description="An index created by a market participant which doesn't align with the other index types.")
    """
    An index created by a market participant which doesn't align with the other index types.
    """
    
    @rosetta_condition
    def condition_0_Choice(self):
        item = self
        return self.check_one_of_constraint('CreditIndex', 'EquityIndex', 'InterestRateIndex', 'ForeignExchangeRateIndex', 'OtherIndex', necessity=True)

import cdm 
import cdm.observable.asset.CreditIndex
import cdm.observable.asset.EquityIndex
import cdm.observable.asset.InterestRateIndex
import cdm.observable.asset.ForeignExchangeRateIndex
import cdm.observable.asset.OtherIndex
