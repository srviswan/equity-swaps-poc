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

__all__ = ['Tx']


class Tx(BaseDataClass):
    newTx: cdm.regulation.New.New = Field(..., description="")
    tradDt: str = Field(..., description="")
    tradgCpcty: str = Field(..., description="")
    qty: cdm.regulation.Qty.Qty = Field(..., description="")
    pric: cdm.regulation.Pric.Pric = Field(..., description="")
    tradVn: str = Field(..., description="")
    ctryOfBrnch: str = Field(..., description="")

import cdm 
import cdm.regulation.New
import cdm.regulation.Qty
import cdm.regulation.Pric
