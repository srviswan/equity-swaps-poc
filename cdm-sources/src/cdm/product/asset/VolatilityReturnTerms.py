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

__all__ = ['VolatilityReturnTerms']

from cdm.product.asset.ReturnTermsBase import ReturnTermsBase

class VolatilityReturnTerms(ReturnTermsBase):
    volatilityStrikePrice: cdm.observable.asset.Price.Price = Field(..., description="Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.")
    """
    Volatility Strike Price in accordance with the ISDA 2011 Equity Derivatives Definitions.
    """
    volatilityCapFloor: Optional[cdm.product.asset.VolatilityCapFloor.VolatilityCapFloor] = Field(None, description="Contains volatility-based barriers")
    """
    Contains volatility-based barriers
    """
    exchangeTradedContractNearest: Optional[cdm.base.staticdata.asset.common.ListedDerivative.ListedDerivative] = Field(None, description="Specification of the exchange traded contract nearest.")
    """
    Specification of the exchange traded contract nearest.
    """

import cdm 
import cdm.observable.asset.Price
import cdm.product.asset.VolatilityCapFloor
import cdm.base.staticdata.asset.common.ListedDerivative
