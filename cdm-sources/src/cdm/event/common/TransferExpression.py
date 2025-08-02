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

__all__ = ['TransferExpression']


class TransferExpression(BaseDataClass):
    """
    Specifies a transfer expression (cash price, performance amount, scheduled payment amount, etc.) to define the nature of the transfer amount and its source.
    """
    priceTransfer: Optional[cdm.observable.asset.FeeTypeEnum.FeeTypeEnum] = Field(None, description="Specifies a transfer amount exchanged as a price or fee for entering into a Business Event, e.g. Premium, Termination fee, Novation fee.")
    """
    Specifies a transfer amount exchanged as a price or fee for entering into a Business Event, e.g. Premium, Termination fee, Novation fee.
    """
    scheduledTransfer: Optional[cdm.event.common.ScheduledTransfer.ScheduledTransfer] = Field(None, description="Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event")
    """
    Specifies a transfer created from a scheduled or contingent event on a contract, e.g. Exercise, Performance, Credit Event
    """
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('priceTransfer', 'scheduledTransfer', necessity=True)

import cdm 
import cdm.observable.asset.FeeTypeEnum
import cdm.event.common.ScheduledTransfer
