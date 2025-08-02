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

__all__ = ['PriceReturnTerms']


class PriceReturnTerms(BaseDataClass):
    returnType: cdm.product.asset.ReturnTypeEnum.ReturnTypeEnum = Field(..., description="The type of return associated with the equity swap.")
    """
    The type of return associated with the equity swap.
    """
    conversionFactor: Optional[Decimal] = Field(None, description="Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.")
    """
    Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.
    """
    performance: Optional[str] = Field(None, description="Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.")
    """
    Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.
    """

import cdm 
import cdm.product.asset.ReturnTypeEnum
