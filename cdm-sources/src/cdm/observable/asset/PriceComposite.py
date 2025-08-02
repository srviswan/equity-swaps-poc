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

__all__ = ['PriceComposite']


class PriceComposite(BaseDataClass):
    """
    Defines the inputs required to calculate a price as a simple composite of 2 other values. The inputs consist of 2 numbers and a simple arithmetic operator. This generic data type applies to a variety of use cases where a price is obtained by simple composition, e.g. dirty = clean + accrued (Bond), forward rate = spot rate + forward point (FX) etc.
    """
    baseValue: Decimal = Field(..., description="The 1st value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). This 1st operand is called 'baseValue' as it refers to the price anchor in the arithmetic operation: e.g. the clean price (Bond) or the spot rate (FX).")
    """
    The 1st value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). This 1st operand is called 'baseValue' as it refers to the price anchor in the arithmetic operation: e.g. the clean price (Bond) or the spot rate (FX).
    """
    operand: Decimal = Field(..., description="The 2nd value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). The 2nd operand is called 'operand' to distinguish it from the 1st one which is the price anchor.")
    """
    The 2nd value in the arithmetic operation, which may be non-commutative in some cases: Subtract, Divide). The 2nd operand is called 'operand' to distinguish it from the 1st one which is the price anchor.
    """
    arithmeticOperator: cdm.base.math.ArithmeticOperationEnum.ArithmeticOperationEnum = Field(..., description="Specifies the arithmetic operator via an enumeration.")
    """
    Specifies the arithmetic operator via an enumeration.
    """
    operandType: Optional[cdm.observable.asset.PriceOperandEnum.PriceOperandEnum] = Field(None, description="Optionally qualifies the type of operand: e.g. accrued or forward point.")
    """
    Optionally qualifies the type of operand: e.g. accrued or forward point.
    """
    
    @rosetta_condition
    def condition_0_ArithmeticOperator(self):
        """
        If operand type is accrued or forward point, then operator must be either add or subtract.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "arithmeticOperator"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "ADD")) or all_elements(rosetta_resolve_attr(self, "arithmeticOperator"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "SUBTRACT")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((all_elements(rosetta_resolve_attr(self, "operandType"), "=", rosetta_resolve_attr(PriceOperandEnum, "FORWARD_POINT")) or all_elements(rosetta_resolve_attr(self, "operandType"), "=", rosetta_resolve_attr(PriceOperandEnum, "ACCRUED_INTEREST"))), _then_fn0, _else_fn0)

import cdm 
import cdm.base.math.ArithmeticOperationEnum
import cdm.observable.asset.PriceOperandEnum
from cdm.observable.asset.PriceOperandEnum import PriceOperandEnum
from cdm.base.math.ArithmeticOperationEnum import ArithmeticOperationEnum
