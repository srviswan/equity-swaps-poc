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

__all__ = ['VarianceReturnTerms']

from cdm.product.asset.ReturnTermsBase import ReturnTermsBase

class VarianceReturnTerms(ReturnTermsBase):
    varianceStrikePrice: Optional[cdm.observable.asset.Price.Price] = Field(None, description="Variance Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.")
    """
    Variance Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
    """
    volatilityStrikePrice: Optional[cdm.observable.asset.Price.Price] = Field(None, description="Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.")
    """
    Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
    """
    varianceCapFloor: Optional[cdm.product.asset.VarianceCapFloor.VarianceCapFloor] = Field(None, description="Contains possible barriers for variance products, both variance-based and underlier price based")
    """
    Contains possible barriers for variance products, both variance-based and underlier price based
    """
    volatilityCapFloor: Optional[cdm.product.asset.VolatilityCapFloor.VolatilityCapFloor] = Field(None, description="Contains containing volatility-based barriers")
    """
    Contains containing volatility-based barriers
    """
    vegaNotionalAmount: Optional[cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] = Field(None, description="Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.")
    """
    Vega Notional represents the approximate gain/loss at maturity for a 1% difference between RVol (realised vol) and KVol (strike vol). It does not necessarily represent the Vega Risk of the trade.
    """
    exchangeTradedContractNearest: Optional[AttributeWithAddress[cdm.observable.asset.Observable.Observable] | cdm.observable.asset.Observable.Observable] = Field(None, description="Specification of the exchange traded contract nearest.")
    """
    Specification of the exchange traded contract nearest.
    """
    
    @rosetta_condition
    def condition_0_Positive_VegaNotionalAmount(self):
        """
        When the optional vegaNotionalAmount is present in the varianceReturnTerms, it needs to have a positive value.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "vegaNotionalAmount"), "value"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "vegaNotionalAmount"), "value")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_UnderlierMustBeListedDerivative(self):
        """
        If an exchange traded contract nearest is specified, it must have a listed derivative as underlier.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "exchangeTradedContractNearest"), "Asset"), "Instrument"), "ListedDerivative"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "exchangeTradedContractNearest")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_ReferenceContract(self):
        """
        If futurePriceValuation is true, an exchange traded contract is used as a reference, therefore such contract must be specified in exchangeTradedContractNearest
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "exchangeTradedContractNearest"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "valuationTerms"), "futuresPriceValuation"), "=", True), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_StrikePriceMustExist(self):
        """
        The strike price must be present, but it can be expressed in either variance or volatility terms
        """
        item = self
        return self.check_one_of_constraint('volatilityStrikePrice', 'varianceStrikePrice', necessity=True)
    
    @rosetta_condition
    def condition_4_NonNegativeStrikePrice(self):
        """
        The strike price must have a positive value
        """
        item = self
        def _then_fn1():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "varianceStrikePrice"), "value"), ">=", 0)
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "volatilityStrikePrice"), "value"), ">=", 0) and if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "varianceStrikePrice"), "value")), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "volatilityStrikePrice"), "value")), _then_fn0, _else_fn0)

import cdm 
import cdm.observable.asset.Price
import cdm.product.asset.VarianceCapFloor
import cdm.product.asset.VolatilityCapFloor
import cdm.base.math.NonNegativeQuantitySchedule
import cdm.observable.asset.Observable
