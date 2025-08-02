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

__all__ = ['Othr']


class Othr(BaseDataClass):
    finInstrmGnlAttrbts: cdm.regulation.FinInstrmGnlAttrbts.FinInstrmGnlAttrbts = Field(..., description="")
    derivInstrmAttrbts: cdm.regulation.DerivInstrmAttrbts.DerivInstrmAttrbts = Field(..., description="")
    id: str = Field(..., description="")
    schmeNm: cdm.regulation.SchmeNm.SchmeNm = Field(..., description="")

import cdm 
import cdm.regulation.FinInstrmGnlAttrbts
import cdm.regulation.DerivInstrmAttrbts
import cdm.regulation.SchmeNm
