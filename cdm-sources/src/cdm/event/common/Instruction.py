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

__all__ = ['Instruction']


class Instruction(BaseDataClass):
    """
    Instruction to a function that will be used to perform a business event
    """
    primitiveInstruction: Optional[cdm.event.common.PrimitiveInstruction.PrimitiveInstruction] = Field(None, description="Specifies the primitive instructions that will be used to call primitive event functions.")
    """
    Specifies the primitive instructions that will be used to call primitive event functions.
    """
    before: Optional[AttributeWithReference | cdm.event.common.TradeState.TradeState] = Field(None, description="Specifies the trade state that will be acted on by the primitive event functions.")
    """
    Specifies the trade state that will be acted on by the primitive event functions.
    """
    
    @rosetta_condition
    def condition_0_ExclusiveSplitPrimitive(self):
        """
        A split primitive is exclusive and cannot be combined with other primitives. Instead, the primitive instructions to be applied to each branch of the split must be specified as breakdowns in the split instruction itself.
        """
        item = self
        def _then_fn0():
            return self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "split"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "split")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_NewTrade(self):
        """
        There must be no before trade state if the primitive instructions contain an execution, and vice versa. An instruction only handles 1 trade at a time.
        """
        item = self
        def _then_fn0():
            return (not rosetta_attr_exists(rosetta_resolve_attr(self, "before")))
        
        def _else_fn0():
            return True
        
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution"))
        
        def _else_fn0():
            return True
        
        return (if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution")), _then_fn0, _else_fn0) and if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(self, "before"))), _then_fn0, _else_fn0))

import cdm 
import cdm.event.common.PrimitiveInstruction
import cdm.event.common.TradeState
