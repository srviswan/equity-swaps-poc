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

__all__ = ['ForeignExchange']


class ForeignExchange(BaseDataClass):
    """
    From FpML: A type defining either a spot or forward FX transactions.
    """
    exchangedCurrency1: cdm.product.common.settlement.Cashflow.Cashflow = Field(..., description="This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.")
    """
    This is the first of the two currency flows that define a single leg of a standard foreign exchange transaction.
    """
    exchangedCurrency2: cdm.product.common.settlement.Cashflow.Cashflow = Field(..., description="This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.")
    """
    This is the second of the two currency flows that define a single leg of a standard foreign exchange transaction.
    """
    tenorPeriod: Optional[cdm.base.datetime.Period.Period] = Field(None, description="A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)")
    """
    A tenor expressed as a period type and multiplier (e.g. 1D, 1Y, etc.)
    """

import cdm 
import cdm.product.common.settlement.Cashflow
import cdm.base.datetime.Period
