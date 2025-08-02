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

__all__ = ['Exposure']


class Exposure(BaseDataClass):
    """
    Represents the current mark to market value or IM calculation value of the trade portfolio as recorded by the principle (in base currency).
    """
    tradePortfolio: AttributeWithReference | cdm.event.position.PortfolioState.PortfolioState = Field(..., description="Represents a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state.")
    """
    Represents a Portfolio that describes all the positions held at a given time, in various states which can be either traded, settled, etc., with lineage information to the previous state.
    """
    aggregateValue: cdm.observable.asset.Money.Money = Field(..., description="Represents the aggregate value of the portfolio in base currency.")
    """
    Represents the aggregate value of the portfolio in base currency.
    """
    calculationDateTime: Optional[datetime.datetime] = Field(None, description="Indicates the date when the exposure is calculated if different from valuation date.")
    """
    Indicates the date when the exposure is calculated if different from valuation date.
    """
    valuationDateTime: datetime.datetime = Field(..., description="Indicates the valuation date of the exposure underlying the calculation.")
    """
    Indicates the valuation date of the exposure underlying the calculation.
    """

import cdm 
import cdm.event.position.PortfolioState
import cdm.observable.asset.Money
