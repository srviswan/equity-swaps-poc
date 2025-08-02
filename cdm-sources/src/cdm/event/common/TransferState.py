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

__all__ = ['TransferState']


class TransferState(BaseDataClass):
    """
    Defines the fundamental financial information associated with a Transfer event. Each TransferState specifies where a Transfer is in its life-cycle. TransferState is a root type and as such, can be created independently to any other CDM data type, but can also be used as part of the CDM Event Model.
    """
    transfer: cdm.event.common.Transfer.Transfer = Field(..., description="Represents the Transfer that has been effected by a business or life-cycle event.")
    """
    Represents the Transfer that has been effected by a business or life-cycle event.
    """
    transferStatus: Optional[cdm.event.common.TransferStatusEnum.TransferStatusEnum] = Field(None, description="Represents the State of the Transfer through its life-cycle.")
    """
    Represents the State of the Transfer through its life-cycle.
    """

import cdm 
import cdm.event.common.Transfer
import cdm.event.common.TransferStatusEnum
