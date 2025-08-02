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

__all__ = ['CalculateTransferInstruction']


class CalculateTransferInstruction(BaseDataClass):
    """
    Defines the tradeState or payout on which to create a Transfer along with all necessary resets.
    """
    tradeState: cdm.event.common.TradeState.TradeState = Field(..., description="")
    payout: AttributeWithReference | cdm.product.template.Payout.Payout = Field(..., description="")
    resets: List[cdm.event.common.Reset.Reset] = Field([], description="")
    payerReceiver: Optional[cdm.base.staticdata.party.PayerReceiver.PayerReceiver] = Field(None, description="")
    quantity: Optional[cdm.base.math.Quantity.Quantity] = Field(None, description="Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return")
    """
    Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
    """
    date: Optional[datetime.date] = Field(None, description="")

import cdm 
import cdm.event.common.TradeState
import cdm.product.template.Payout
import cdm.event.common.Reset
import cdm.base.staticdata.party.PayerReceiver
import cdm.base.math.Quantity
