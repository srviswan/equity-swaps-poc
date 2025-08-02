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

__all__ = ['ReturnTermsBase']


class ReturnTermsBase(BaseDataClass):
    """
    Contains all common elements in variance, volatility and correlation return Terms.
    """
    valuationTerms: cdm.product.asset.ValuationTerms.ValuationTerms = Field(..., description="Contains all non-date valuation information.")
    """
    Contains all non-date valuation information.
    """
    annualizationFactor: Optional[int] = Field(None, description="This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.")
    """
    This specifies the numerator of an annualization factor. Frequently this number is equal to the number of observations of prices in a year e.g. 252.
    """
    dividendApplicability: Optional[cdm.observable.asset.DividendApplicability.DividendApplicability] = Field(None, description="The parameters which define whether dividends are applicable")
    """
    The parameters which define whether dividends are applicable
    """
    equityUnderlierProvisions: Optional[cdm.product.asset.EquityUnderlierProvisions.EquityUnderlierProvisions] = Field(None, description="Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.")
    """
    Contains Equity Underlyer provisions regarding jurisdiction and fallbacks.
    """
    sharePriceDividendAdjustment: Optional[bool] = Field(None, description="Indicates whether the price of shares is adjusted for dividends or not.")
    """
    Indicates whether the price of shares is adjusted for dividends or not.
    """
    expectedN: int = Field(..., description="Expected number of trading days.")
    """
    Expected number of trading days.
    """
    initialLevel: Optional[Decimal] = Field(None, description="Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.")
    """
    Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
    """
    initialLevelSource: Optional[cdm.observable.common.DeterminationMethodEnum.DeterminationMethodEnum] = Field(None, description="In this context, this is AgreedInitialPrice - a specified Initial Index Level.")
    """
    In this context, this is AgreedInitialPrice - a specified Initial Index Level.
    """
    meanAdjustment: Optional[bool] = Field(None, description="Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation")
    """
    Specifies whether Mean Adjustment is applicable or not in the calculation of the Realized Volatility, Variance or Correlation
    """
    performance: Optional[str] = Field(None, description="Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.")
    """
    Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
    """
    
    @rosetta_condition
    def condition_0_InitialLevelOrInitialLevelSource(self):
        """
        At least one of initialLevel and initialLevelSource must be present, or both
        """
        item = self
        def _then_fn1():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "initialLevel"))
        
        def _else_fn1():
            return True
        
        def _then_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "initialLevelSource")) and if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "initialLevelSource"))), _then_fn1, _else_fn1))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "initialLevel"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_PositiveExpectedN(self):
        """
        The number of expected trading dates must be positive
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "expectedN"), ">", 0)

import cdm 
import cdm.product.asset.ValuationTerms
import cdm.observable.asset.DividendApplicability
import cdm.product.asset.EquityUnderlierProvisions
import cdm.observable.common.DeterminationMethodEnum
