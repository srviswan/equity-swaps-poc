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

__all__ = ['Money']

from cdm.base.math.Quantity import Quantity

class Money(Quantity):
    """
    Defines a monetary amount in a specified currency.
    """
    
    @rosetta_condition
    def condition_0_CurrencyUnitExists(self):
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"))

import cdm 
