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

__all__ = ['Basket']

from cdm.base.staticdata.asset.common.AssetBase import AssetBase

class Basket(AssetBase):
    """
    Defines a custom basket by referencing an identifier and its constituents.
    """
    basketConstituent: List[AttributeWithMeta[cdm.observable.asset.BasketConstituent.BasketConstituent] | cdm.observable.asset.BasketConstituent.BasketConstituent] = Field([], description="Identifies the constituents of the basket")
    """
    Identifies the constituents of the basket
    """
    @rosetta_condition
    def cardinality_basketConstituent(self):
        return check_cardinality(self.basketConstituent, 1, None)
    

import cdm 
import cdm.observable.asset.BasketConstituent
