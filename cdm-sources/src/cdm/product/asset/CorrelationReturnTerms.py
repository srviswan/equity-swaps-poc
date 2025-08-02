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

__all__ = ['CorrelationReturnTerms']

from cdm.product.asset.ReturnTermsBase import ReturnTermsBase

class CorrelationReturnTerms(ReturnTermsBase):
    correlationStrikePrice: cdm.observable.asset.Price.Price = Field(..., description="Correlation Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.")
    """
    Correlation Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
    """
    boundedCorrelation: Optional[cdm.base.math.NumberRange.NumberRange] = Field(None, description="Describes correlation bounds, which form a cap and a floor on the realized correlation.")
    """
    Describes correlation bounds, which form a cap and a floor on the realized correlation.
    """
    numberOfDataSeries: Optional[int] = Field(None, description="Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.")
    """
    Number of data series, normal market practice is that correlation data sets are drawn from geographic market areas, such as America, Europe and Asia Pacific, each of these geographic areas will have its own data series to avoid contagion.
    """
    
    @rosetta_condition
    def condition_0_PositiveNumberOfDataSeries(self):
        """
        The number of data series must be positive
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "numberOfDataSeries"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "numberOfDataSeries")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_CorrelationValue(self):
        """
        The correlation strike price is a decimal with allowed values only between 1 and -1
        """
        item = self
        return (all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "correlationStrikePrice"), "value"), ">", -1) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "correlationStrikePrice"), "value"), "<", 1))

import cdm 
import cdm.observable.asset.Price
import cdm.base.math.NumberRange
