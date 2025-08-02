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

__all__ = ['CreditLimitUtilisationPosition']


class CreditLimitUtilisationPosition(BaseDataClass):
    shortPosition: Optional[Decimal] = Field(None, description="Credit limit utilisation attributable to short positions.")
    """
    Credit limit utilisation attributable to short positions.
    """
    longPosition: Optional[Decimal] = Field(None, description="Credit limit utilisation attributable to long positions.")
    """
    Credit limit utilisation attributable to long positions.
    """
    rosetta_attr_global: Optional[Decimal] = Field(None, description="Global credit limit utilisation amount, agnostic of long/short position direction.")
    """
    Global credit limit utilisation amount, agnostic of long/short position direction.
    """

import cdm 
