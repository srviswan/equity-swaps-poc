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

__all__ = ['PaymentDiscounting']


class PaymentDiscounting(BaseDataClass):
    """
    This class corresponds to the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.
    """
    discountFactor: Optional[Decimal] = Field(None, description="The value representing the discount factor used to calculate the present value of the cash flow.")
    """
    The value representing the discount factor used to calculate the present value of the cash flow.
    """
    presentValueAmount: Optional[cdm.observable.asset.Money.Money] = Field(None, description="The amount representing the present value of the forecast payment.")
    """
    The amount representing the present value of the forecast payment.
    """

import cdm 
import cdm.observable.asset.Money
