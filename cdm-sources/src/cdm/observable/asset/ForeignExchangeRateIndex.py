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

__all__ = ['ForeignExchangeRateIndex']

from cdm.observable.asset.IndexBase import IndexBase

class ForeignExchangeRateIndex(IndexBase):
    """
    Specification of a rate based on the exchange of a pair of cash assets in specific currencies, e.g. USD versus GBP.
    """
    quotedCurrencyPair: AttributeWithMeta[cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPair] | cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPair = Field(..., description="Describes the composition of a rate that has been quoted or is to be quoted.")
    """
    Describes the composition of a rate that has been quoted or is to be quoted.
    """
    primaryFxSpotRateSource: cdm.observable.asset.InformationSource.InformationSource = Field(..., description="Specifies the primary source from which a rate should be observed.")
    """
    Specifies the primary source from which a rate should be observed.
    """
    secondaryFxSpotRateSource: Optional[cdm.observable.asset.InformationSource.InformationSource] = Field(None, description="Specifies an alternative, or secondary, source from which a rate should be observed.")
    """
    Specifies an alternative, or secondary, source from which a rate should be observed.
    """
    
    @rosetta_condition
    def condition_0_FXAssetClass(self):
        """
        The asset class must be Foreign Exchange.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(AssetClassEnum, "FOREIGN_EXCHANGE"))

import cdm 
import cdm.observable.asset.QuotedCurrencyPair
import cdm.observable.asset.InformationSource
from cdm.base.staticdata.asset.common.AssetClassEnum import AssetClassEnum
