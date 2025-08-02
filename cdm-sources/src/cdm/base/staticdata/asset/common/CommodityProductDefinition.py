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

__all__ = ['CommodityProductDefinition']


class CommodityProductDefinition(BaseDataClass):
    """
    Specifies the commodity underlier in the event that no ISDA Commodity Reference Price exists.
    """
    referenceFramework: cdm.base.staticdata.asset.common.CommodityReferenceFramework.CommodityReferenceFramework = Field(..., description="Specifies the type of commodity.")
    """
    Specifies the type of commodity.
    """
    priceSource: Optional[cdm.base.staticdata.asset.common.PriceSource.PriceSource] = Field(None, description="Specifies a publication that provides the commodity price, including, where applicable the details of where in the publication the price is published. Applicable when the commodity reference price is not a futures contract")
    """
    Specifies a publication that provides the commodity price, including, where applicable the details of where in the publication the price is published.  Applicable when the commodity reference price is not a futures contract
    """
    commodityInfoPublisher: Optional[cdm.base.staticdata.asset.common.CommodityInformationPublisherEnum.CommodityInformationPublisherEnum] = Field(None, description="Specifies the publication where the commodity prices can be found.")
    """
    Specifies the publication where the commodity prices can be found.
    """
    exchangeId: AttributeWithMeta[str] | str = Field(..., description=" Identifies the exchange from which the reference price should be sourced, using the scheme at the following url: http://www.fpml.org/coding-scheme/external/exchange-id-MIC-1-0")
    """
     Identifies the exchange from which the reference price should be sourced, using the scheme at the following url: http://www.fpml.org/coding-scheme/external/exchange-id-MIC-1-0
    """
    
    @rosetta_condition
    def condition_0_CommodityProductDefinitionChoice(self):
        """
        Requires the definition of either delivery date parameters or non-exchange price source.
        """
        item = self
        return self.check_one_of_constraint('exchangeId', 'priceSource', necessity=False)

import cdm 
import cdm.base.staticdata.asset.common.CommodityReferenceFramework
import cdm.base.staticdata.asset.common.PriceSource
import cdm.base.staticdata.asset.common.CommodityInformationPublisherEnum
