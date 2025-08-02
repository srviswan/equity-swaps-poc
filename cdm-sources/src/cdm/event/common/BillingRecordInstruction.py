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

__all__ = ['BillingRecordInstruction']


class BillingRecordInstruction(BaseDataClass):
    """
    Specifies the instructions for creation of a billing record.
    """
    tradeState: AttributeWithReference | cdm.event.common.TradeState.TradeState = Field(..., description="The trade for the individual billing record.")
    """
    The trade for the individual billing record.
    """
    observation: List[cdm.observable.event.Observation.Observation] = Field([], description="The observations used to calculate the billing amount.")
    """
    The observations used to calculate the billing amount.
    """
    @rosetta_condition
    def cardinality_observation(self):
        return check_cardinality(self.observation, 1, None)
    
    recordStartDate: datetime.date = Field(..., description="The starting date of the period described by this record")
    """
    The starting date of the period described by this record
    """
    recordEndDate: datetime.date = Field(..., description="The ending date of the period described by this record")
    """
    The ending date of the period described by this record
    """
    settlementDate: datetime.date = Field(..., description="The date for settlement of the transfer.")
    """
    The date for settlement of the transfer.
    """

import cdm 
import cdm.event.common.TradeState
import cdm.observable.event.Observation
