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

__all__ = ['MarginCallResponse']

from cdm.event.common.MarginCallBase import MarginCallBase

class MarginCallResponse(MarginCallBase):
    """
    Represents common attributes required for a Margin Call Response under a legal agreement such as a credit support document or equivalent.
    """
    marginCallResponseAction: List[cdm.event.common.MarginCallResponseAction.MarginCallResponseAction] = Field([], description="Specifies the margin call action details, including collateral to be moved and direction.")
    """
    Specifies the margin call action details, including collateral to be moved and direction.
    """
    @rosetta_condition
    def cardinality_marginCallResponseAction(self):
        return check_cardinality(self.marginCallResponseAction, 1, None)
    
    marginResponseType: cdm.event.common.MarginCallResponseTypeEnum.MarginCallResponseTypeEnum = Field(..., description="Indicates the response type, such as, is the margin call response a 'full' 'part' agreement or 'dispute'.")
    """
    Indicates the response type, such as, is the margin call response a 'full' 'part' agreement or 'dispute'.
    """
    agreedAmountBaseCurrency: cdm.observable.asset.Money.Money = Field(..., description="Indicates the amount that posting entity agrees to remit in response to margin call (in base currency).")
    """
    Indicates the amount that posting entity agrees to remit in response to margin call (in base currency).
    """

import cdm 
import cdm.event.common.MarginCallResponseAction
import cdm.event.common.MarginCallResponseTypeEnum
import cdm.observable.asset.Money
