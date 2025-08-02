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

__all__ = ['PaymentDetail']


class PaymentDetail(BaseDataClass):
    paymentDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="")
    paymentRule: cdm.product.common.settlement.PaymentRule.PaymentRule = Field(..., description="The calculation rule.")
    """
    The calculation rule.
    """
    paymentAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="A fixed payment amount.")
    """
    A fixed payment amount.
    """

import cdm 
import cdm.base.datetime.AdjustableOrRelativeDate
import cdm.product.common.settlement.PaymentRule
import cdm.observable.asset.Money
