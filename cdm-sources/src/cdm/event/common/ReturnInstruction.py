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

__all__ = ['ReturnInstruction']


class ReturnInstruction(BaseDataClass):
    """
    Specifies the information required to create the return of a Security Finance Transaction.
    """
    quantity: List[cdm.base.math.Quantity.Quantity] = Field([], description="Specifies the quantity of shares and cash to be returned in a partial return event.")
    """
    Specifies the quantity of shares and cash to be returned in a partial return event.
    """
    @rosetta_condition
    def cardinality_quantity(self):
        return check_cardinality(self.quantity, 1, None)
    

import cdm 
import cdm.base.math.Quantity
