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

__all__ = ['FxRate']


class FxRate(BaseDataClass):
    """
    A class describing the rate of a currency conversion: pair of currency, quotation mode and exchange rate.
    """
    quotedCurrencyPair: cdm.observable.asset.QuotedCurrencyPair.QuotedCurrencyPair = Field(..., description="Defines the two currencies for an FX trade and the quotation relationship between the two currencies.")
    """
    Defines the two currencies for an FX trade and the quotation relationship between the two currencies.
    """
    rate: Optional[Decimal] = Field(None, description="The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.")
    """
    The rate of exchange between the two currencies of the leg of a deal. Must be specified with a quote basis.
    """

import cdm 
import cdm.observable.asset.QuotedCurrencyPair
