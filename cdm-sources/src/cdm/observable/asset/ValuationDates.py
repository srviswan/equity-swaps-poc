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

__all__ = ['ValuationDates']


class ValuationDates(BaseDataClass):
    """
    Defines how and when a performance type option or performance type swap is to be valued, including initial, interim and final valuation dates.
    """
    initialValuationDate: Optional[cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDates] = Field(None, description="Specifies the initial valuation dates of the underlyer.")
    """
    Specifies the initial valuation dates of the underlyer.
    """
    interimValuationDate: Optional[cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDates] = Field(None, description="Specifies the interim valuation dates of the underlyer.")
    """
    Specifies the interim valuation dates of the underlyer.
    """
    finalValuationDate: cdm.observable.asset.PerformanceValuationDates.PerformanceValuationDates = Field(..., description="Specifies the final valuation dates of the underlyer.")
    """
    Specifies the final valuation dates of the underlyer.
    """

import cdm 
import cdm.observable.asset.PerformanceValuationDates
