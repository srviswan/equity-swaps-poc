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

__all__ = ['Cash']

from cdm.base.staticdata.asset.common.AssetBase import AssetBase

class Cash(AssetBase):
    """
    An Asset that consists solely of a monetary holding in a currency. The currency of the Cash asset is held in the string Identifier (from AssetBase) and the AssetIdTypeEnum must be set to define that a CurrencyCode is set.  The function SetCashCurrency can be used to create (or update) a Cash object and the function GetCashCurrency can be used to retrieve the currency of a Cash object.
    """
    
    @rosetta_condition
    def condition_0_CurrencyExists(self):
        """
        There must be one and only one currency code and it must be valid (ie in the enumerated list).
        """
        item = self
        return (all_elements(rosetta_count(AssetIdentifierByType(rosetta_resolve_attr(self, "identifier"), rosetta_resolve_attr(AssetIdTypeEnum, "CURRENCY_CODE"))), "=", 1) and rosetta_attr_exists(CurrencyCodeEnum(rosetta_resolve_attr(AssetIdentifierByType(rosetta_resolve_attr(self, "identifier"), rosetta_resolve_attr(AssetIdTypeEnum, "CURRENCY_CODE")), "identifier")[0])))
    
    @rosetta_condition
    def condition_1_NoTaxonomy(self):
        """
        Taxonomy is not applicable for a Cash asset.
        """
        item = self
        return (not rosetta_attr_exists(rosetta_resolve_attr(self, "taxonomy")))
    
    @rosetta_condition
    def condition_2_NoExchange(self):
        """
        Cash cannot be a listed Asset.
        """
        item = self
        return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "exchange"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "isExchangeListed"))))

import cdm 
from cdm.base.staticdata.asset.common.functions.AssetIdentifierByType import AssetIdentifierByType
from cdm.base.staticdata.asset.common.AssetIdTypeEnum import AssetIdTypeEnum
