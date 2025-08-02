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

__all__ = ['BillingRecord']


class BillingRecord(BaseDataClass):
    """
    Specifies individual records within a billing invoice.
    """
    tradeState: AttributeWithReference | cdm.event.common.TradeState.TradeState = Field(..., description="The trade for the individual billing record.")
    """
    The trade for the individual billing record.
    """
    recordTransfer: cdm.event.common.Transfer.Transfer = Field(..., description="The settlement terms for the billing record")
    """
    The settlement terms for the billing record
    """
    recordStartDate: datetime.date = Field(..., description="The starting date of the period described by this record")
    """
    The starting date of the period described by this record
    """
    recordEndDate: datetime.date = Field(..., description="The ending date of the period described by this record")
    """
    The ending date of the period described by this record
    """
    minimumFee: Optional[cdm.observable.asset.Money.Money] = Field(None, description="Indicates the minimum fee amount applied to the billing record, if any.")
    """
    Indicates the minimum fee amount applied to the billing record, if any.
    """

import cdm 
import cdm.event.common.TradeState
import cdm.event.common.Transfer
import cdm.observable.asset.Money
