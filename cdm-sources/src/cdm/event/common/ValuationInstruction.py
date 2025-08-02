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

__all__ = ['ValuationInstruction']


class ValuationInstruction(BaseDataClass):
    """
    Specifies inputs needed to process a valuation.
    """
    valuation: List[cdm.event.common.Valuation.Valuation] = Field([], description="Contains all information related to a valuation.")
    """
    Contains all information related to a valuation.
    """
    @rosetta_condition
    def cardinality_valuation(self):
        return check_cardinality(self.valuation, 1, None)
    
    replace: bool = Field(..., description="Specifies whether the previous valuation tracks in the valuation history are removed (True) or kept (False).")
    """
    Specifies whether the previous valuation tracks in the valuation history are removed (True) or kept (False).
    """

import cdm 
import cdm.event.common.Valuation
