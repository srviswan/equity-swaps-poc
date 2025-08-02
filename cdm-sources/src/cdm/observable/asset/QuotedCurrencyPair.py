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

__all__ = ['QuotedCurrencyPair']


class QuotedCurrencyPair(BaseDataClass):
    """
    A class that describes the composition of a rate that has been quoted or is to be quoted. This includes the two currencies and the quotation relationship between the two currencies and is used as a building block throughout the FX specification.
    """
    currency1: AttributeWithMeta[str] | str = Field(..., description="The first currency specified when a pair of currencies is to be evaluated.")
    """
    The first currency specified when a pair of currencies is to be evaluated.
    """
    currency2: AttributeWithMeta[str] | str = Field(..., description="The second currency specified when a pair of currencies is to be evaluated.")
    """
    The second currency specified when a pair of currencies is to be evaluated.
    """
    quoteBasis: cdm.observable.asset.QuoteBasisEnum.QuoteBasisEnum = Field(..., description="The method by which the exchange rate is quoted.")
    """
    The method by which the exchange rate is quoted.
    """

import cdm 
import cdm.observable.asset.QuoteBasisEnum
