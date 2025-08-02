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

__all__ = ['ExerciseInstruction']


class ExerciseInstruction(BaseDataClass):
    """
    Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
    """
    exerciseQuantity: cdm.event.common.PrimitiveInstruction.PrimitiveInstruction = Field(..., description="Contains instructions for exercising the option including a quantity change, and optionally a transfer.")
    """
    Contains instructions for exercising the option including a quantity change, and optionally a transfer.
    """
    exerciseOption: Optional[AttributeWithReference | cdm.product.template.OptionPayout.OptionPayout] = Field(None, description="Specifies the Option Payout being exercised on the trade.")
    """
    Specifies the Option Payout being exercised on the trade.
    """
    exerciseDate: Optional[cdm.base.datetime.AdjustableOrAdjustedDate.AdjustableOrAdjustedDate] = Field(None, description="Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).")
    """
    Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).
    """
    exerciseTime: Optional[cdm.base.datetime.BusinessCenterTime.BusinessCenterTime] = Field(None, description="Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). ")
    """
    Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). 
    """
    replacementTradeIdentifier: List[cdm.event.common.TradeIdentifier.TradeIdentifier] = Field([], description="Specifies the trade identifier to apply to the replacement trade for physical exercise.")
    """
    Specifies the trade identifier to apply to the replacement trade for physical exercise.
    """

import cdm 
import cdm.event.common.PrimitiveInstruction
import cdm.product.template.OptionPayout
import cdm.base.datetime.AdjustableOrAdjustedDate
import cdm.base.datetime.BusinessCenterTime
import cdm.event.common.TradeIdentifier
