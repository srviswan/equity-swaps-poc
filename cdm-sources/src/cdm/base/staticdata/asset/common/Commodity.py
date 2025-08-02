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

__all__ = ['Commodity']

from cdm.base.staticdata.asset.common.AssetBase import AssetBase

class Commodity(AssetBase):
    """
    Identifies a specific commodity by referencing a product identifier or by a product definition.
    """
    commodityProductDefinition: Optional[cdm.base.staticdata.asset.common.CommodityProductDefinition.CommodityProductDefinition] = Field(None, description="Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.")
    """
    Specifies the commodity underlier in the event that no ISDA Commodity Reference Benchmark exists.
    """
    priceQuoteType: cdm.observable.asset.QuotationSideEnum.QuotationSideEnum = Field(..., description="Describes the required quote type of the underlying price that will be observed. Example values include 'Bid, 'Ask', 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).")
    """
    Describes the required quote type of the underlying price that will be observed. Example values include 'Bid, 'Ask', 'Settlement' (for a futures contract) and 'WeightedAverage' (for some published prices and indices).
    """
    deliveryDateReference: Optional[cdm.base.staticdata.asset.common.DeliveryDateParameters.DeliveryDateParameters] = Field(None, description="Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.")
    """
    Specifies the parameters for identifying the relevant contract date when the commodity reference price is a futures contract.
    """
    description: Optional[str] = Field(None, description="Provides additional information about the commodity underlier.")
    """
    Provides additional information about the commodity underlier.
    """
    
    @rosetta_condition
    def condition_0_OrdinalExists(self):
        """
        Requires that, if multiple classification elements are present, they contain an  ordinal so that they can be sorted.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomy"), "value"), "classification"), "ordinal"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomy"), "value"), "classification")), ">", 1), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_ValueSource(self):
        """
        Requires that value and source are present when product taxonomy is present
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomy"), "source")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "taxonomy"), "value")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "taxonomy")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.CommodityProductDefinition
import cdm.observable.asset.QuotationSideEnum
import cdm.base.staticdata.asset.common.DeliveryDateParameters
