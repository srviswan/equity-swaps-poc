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

__all__ = ['MoneyBound']


class MoneyBound(BaseDataClass):
    """
    The money bound is defined as a money amount and whether the bound is inclusive.
    """
    money: cdm.observable.asset.Money.Money = Field(..., description="The money amount to be used as the bound, e.g. 1,000 USD.")
    """
    The money amount to be used as the bound, e.g. 1,000 USD.
    """
    inclusive: bool = Field(..., description="Whether the money amount bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.")
    """
    Whether the money amount bound is inclusive, e.g. for a lower bound, false would indicate greater than, whereas true would indicate greater than or equal to.
    """

import cdm 
import cdm.observable.asset.Money
