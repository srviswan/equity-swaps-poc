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

__all__ = ['Measure']

from cdm.base.math.MeasureBase import MeasureBase

class Measure(MeasureBase):
    """
    Defines a concrete measure as a number associated to a unit. It extends MeasureBase by requiring the value attribute to be present. A measure may be unit-less so the unit attribute is still optional.
    """
    
    @rosetta_condition
    def condition_0_ValueExists(self):
        """
        The value attribute must be present in a concrete measure.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "value"))

import cdm 
