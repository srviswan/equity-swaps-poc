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

__all__ = ['ListedDerivative']

from cdm.base.staticdata.asset.common.InstrumentBase import InstrumentBase

class ListedDerivative(InstrumentBase):
    """
    A securitized derivative on another asset.
    """
    deliveryTerm: Optional[str] = Field(None, description="Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.")
    """
    Also called contract month or delivery month. However, it's not always a month. It is usually expressed using a code, e.g. Z23 would be the Dec 2023 contract, (Z = December). For crude oil, the corresponding contract might be called CLZ23. Optional as this can be uniquely identified in the identifier.
    """
    optionType: Optional[cdm.base.staticdata.asset.common.PutCallEnum.PutCallEnum] = Field(None, description="The type of option, ie Put or Call. Left empty if it is a Future.")
    """
    The type of option, ie Put or Call. Left empty if it is a Future.
    """
    strike: Optional[Decimal] = Field(None, description="Specifies the strike of the option.")
    """
    Specifies the strike of the option.
    """
    
    @rosetta_condition
    def condition_0_Options(self):
        """
        Options must have a strike price.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(self, "strike"))
        
        def _else_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "strike")))
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "optionType")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.staticdata.asset.common.PutCallEnum
