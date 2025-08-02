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

__all__ = ['QuantityMultiplier']


class QuantityMultiplier(BaseDataClass):
    """
     Class to specify a mechanism for a quantity to be set as a multiplier to another (reference) quantity, based on a price observation. At the moment this class only supports FX or Equity-linked notional and re-uses existing building blocks for those 2 cases, until such time when component can be made more generic. This captures the case of resetting cross-currency swaps and resetting equity swaps.
    """
    fxLinkedNotionalSchedule: Optional[cdm.product.common.schedule.FxLinkedNotionalSchedule.FxLinkedNotionalSchedule] = Field(None, description="Multiplier specified as an FX-linked schedule, e.g. for a resetting cross-currency swap..")
    """
    Multiplier specified as an FX-linked schedule, e.g. for a resetting cross-currency swap..
    """
    multiplierValue: Optional[Decimal] = Field(None, description="")
    
    @rosetta_condition
    def condition_0_(self):
        item = self
        return self.check_one_of_constraint('fxLinkedNotionalSchedule', 'multiplierValue', necessity=True)

import cdm 
import cdm.product.common.schedule.FxLinkedNotionalSchedule
