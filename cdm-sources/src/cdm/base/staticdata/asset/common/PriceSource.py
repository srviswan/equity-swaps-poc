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

__all__ = ['PriceSource']


class PriceSource(BaseDataClass):
    """
    Specifies a publication that provides the commodity price, including, where applicable, the details of where in the publication the price is published.
    """
    pricePublisher: AttributeWithMeta[str] | str = Field(..., description="Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg. Commodity publishers can be found at this URL: http://www.fpml.org/coding-scheme/commodity-information-provider>")
    """
    Defines a publication in which the price can be found. (e.g Gas Daily, Platts Bloomberg. Commodity publishers can be found at this URL:  http://www.fpml.org/coding-scheme/commodity-information-provider>
    """
    priceSourceLocation: Optional[str] = Field(None, description="Specifies the location of the price which may be a specific page, electornic screen name, or a code (e.g. a RIC code) where the price can be found.")
    """
    Specifies the location of the price which may be a specific page, electornic screen name, or a code (e.g. a RIC code) where the price can be found.
    """
    priceSourceHeading: Optional[str] = Field(None, description="Specifies the heading or field name for the price on a given page or screen, where applicable.")
    """
    Specifies the heading or field name for the price  on a given page or screen, where applicable.
    """
    priceSourceTime: Optional[datetime.time] = Field(None, description="Specifies the time at which the price should be observed.")
    """
    Specifies the time at which the price should be observed.
    """
    
    @rosetta_condition
    def condition_0_PriceSourceHeading(self):
        """
        Requires that if a priceSourceHeading is specified, then a priceSourceLocation must be speficified
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "priceSourceLocation"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "priceSourceHeading")), _then_fn0, _else_fn0)

import cdm 
