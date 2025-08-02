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

__all__ = ['PrimitiveInstruction']


class PrimitiveInstruction(BaseDataClass):
    """
    A Primitive Instruction describes the inputs required to pass into the corresponding PrimitiveEvent function.
    """
    contractFormation: Optional[cdm.event.common.ContractFormationInstruction.ContractFormationInstruction] = Field(None, description="Specifies instructions describing an contract formation primitive event.")
    """
    Specifies instructions describing an contract formation primitive event.
    """
    execution: Optional[cdm.event.common.ExecutionInstruction.ExecutionInstruction] = Field(None, description="Specifies instructions describing an execution primitive event.")
    """
    Specifies instructions describing an execution primitive event.
    """
    exercise: Optional[cdm.event.common.ExerciseInstruction.ExerciseInstruction] = Field(None, description="Specifies instructions describing an exercise primitive event.")
    """
    Specifies instructions describing an exercise primitive event.
    """
    partyChange: Optional[cdm.event.common.PartyChangeInstruction.PartyChangeInstruction] = Field(None, description="Specifies instructions describing a party change primitive event.")
    """
    Specifies instructions describing a party change primitive event.
    """
    quantityChange: Optional[cdm.event.common.QuantityChangeInstruction.QuantityChangeInstruction] = Field(None, description="Specifies instructions describing an quantity change primitive event.")
    """
    Specifies instructions describing an quantity change primitive event.
    """
    reset: Optional[cdm.event.common.ResetInstruction.ResetInstruction] = Field(None, description="Specifies instructions describing a reset event.")
    """
    Specifies instructions describing a reset event.
    """
    split: Optional[cdm.event.common.SplitInstruction.SplitInstruction] = Field(None, description="Specifies instructions to split a trade into multiple branches.")
    """
    Specifies instructions to split a trade into multiple branches.
    """
    termsChange: Optional[cdm.event.common.TermsChangeInstruction.TermsChangeInstruction] = Field(None, description="Specifies instructions describing a terms change primitive event.")
    """
    Specifies instructions describing a terms change primitive event.
    """
    transfer: Optional[cdm.event.common.TransferInstruction.TransferInstruction] = Field(None, description="Specifies instructions describing a transfer primitive event.")
    """
    Specifies instructions describing a transfer primitive event.
    """
    indexTransition: Optional[cdm.event.common.IndexTransitionInstruction.IndexTransitionInstruction] = Field(None, description="Specifies inputs needed to process a Index Transition business event.")
    """
    Specifies inputs needed to process a Index Transition business event.
    """
    stockSplit: Optional[cdm.event.common.StockSplitInstruction.StockSplitInstruction] = Field(None, description="Specifies inputs needed to process a Stock Split business event.")
    """
    Specifies inputs needed to process a Stock Split business event.
    """
    observation: Optional[cdm.event.common.ObservationInstruction.ObservationInstruction] = Field(None, description="Specifies inputs needed to process an observation.")
    """
    Specifies inputs needed to process an observation.
    """
    valuation: Optional[cdm.event.common.ValuationInstruction.ValuationInstruction] = Field(None, description="Specifies inputs needed to process an update of a valuation.")
    """
    Specifies inputs needed to process an update of a valuation.
    """

import cdm 
import cdm.event.common.ContractFormationInstruction
import cdm.event.common.ExecutionInstruction
import cdm.event.common.ExerciseInstruction
import cdm.event.common.PartyChangeInstruction
import cdm.event.common.QuantityChangeInstruction
import cdm.event.common.ResetInstruction
import cdm.event.common.SplitInstruction
import cdm.event.common.TermsChangeInstruction
import cdm.event.common.TransferInstruction
import cdm.event.common.IndexTransitionInstruction
import cdm.event.common.StockSplitInstruction
import cdm.event.common.ObservationInstruction
import cdm.event.common.ValuationInstruction
