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

__all__ = ['CashflowType']


class CashflowType(BaseDataClass):
    """
    Characterises the type of cashflow, which can result from either a scheduled or a non-scheduled lifecycle event.
    """
    cashflowType: Optional[cdm.product.common.settlement.ScheduledTransferEnum.ScheduledTransferEnum] = Field(None, description="Type of cashflow corresponding to a scheduled event.")
    """
    Type of cashflow corresponding to a scheduled event.
    """
    cashPrice: Optional[cdm.observable.asset.CashPrice.CashPrice] = Field(None, description="Type of cashflow corresponding to a non-scheduled event, where a price must be agreed between the parties.")
    """
    Type of cashflow corresponding to a non-scheduled event, where a price must be agreed between the parties.
    """
    priceExpression: Optional[cdm.observable.asset.PriceExpressionEnum.PriceExpressionEnum] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_(self):
        """
        A cashflow is either specified as a type of scheduled cashflow, or as a price agreed between parties in case of a non-scheduled cashflow.
        """
        item = self
        return self.check_one_of_constraint('cashflowType', 'cashPrice', necessity=True)

import cdm 
import cdm.product.common.settlement.ScheduledTransferEnum
import cdm.observable.asset.CashPrice
import cdm.observable.asset.PriceExpressionEnum
