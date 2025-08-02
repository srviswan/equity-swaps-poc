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

__all__ = ['TransferInstruction']


class TransferInstruction(BaseDataClass):
    """
    Defines the payout on which to create a Transfer along with all necessary resets.
    """
    transferState: List[cdm.event.common.TransferState.TransferState] = Field([], description="Specifies the terms and state of a transfers.")
    """
    Specifies the terms and state of a transfers.
    """

import cdm 
import cdm.event.common.TransferState
