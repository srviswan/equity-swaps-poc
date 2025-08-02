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

__all__ = ['VolatilityCapFloor']


class VolatilityCapFloor(BaseDataClass):
    """
    Contains volatility-based barriers. Volatility Cap needs to be specified in accordance with the ISDA 2011 Equity Derivatives Definitions.
    """
    applicable: bool = Field(..., description="Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.")
    """
    Indicates whether the volatility cap is applicable in accordance with the ISDA 2011 Equity Derivatives Definitions. Setting the element 'applicable' to 'False' - means No Volatility Cap and no 'totalVolatilityCap' or 'volatilityCapFactor' should be provided. Setting the element 'applicable' to 'True' - means Volatility Cap election, then 'totalVolatilityCap' or 'volatilityCapFactor' should be provided, otherwise it defaults to volatilityCapFactor=2.5.
    """
    totalVolatilityCap: Optional[Decimal] = Field(None, description="Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.")
    """
    Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. This means the Volatility Cap Amount election is a number.
    """
    volatilityCapFactor: Optional[Decimal] = Field(None, description="Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. The Calculated VolCapAmt can be optionally provided.")
    """
    Volatility Cap Amount in accordance with the ISDA 2011 Equity Derivatives Definitions. The Calculated VolCapAmt can be optionally provided.
    """
    
    @rosetta_condition
    def condition_0_CapFloorApplicability(self):
        """
        Caps/floors can and must be specified if applicable is set to true. If false, barriers cannot be established
        """
        item = self
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "totalVolatilityCap")) or rosetta_attr_exists(rosetta_resolve_attr(self, "volatilityCapFactor")))
        
        def _else_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "totalVolatilityCap"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "volatilityCapFactor"))))
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "applicable"), "=", True), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_PositiveCaps(self):
        """
        Barriers must be set to positive values
        """
        item = self
        def _then_fn1():
            return all_elements(rosetta_resolve_attr(self, "volatilityCapFactor"), ">=", 0)
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "totalVolatilityCap"), ">=", 0) and if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "volatilityCapFactor")), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "totalVolatilityCap")), _then_fn0, _else_fn0)

import cdm 
