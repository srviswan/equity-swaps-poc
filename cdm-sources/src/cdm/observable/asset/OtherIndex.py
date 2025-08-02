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

__all__ = ['OtherIndex']

from cdm.observable.asset.IndexBase import IndexBase

class OtherIndex(IndexBase):
    """
    Specification of a user-defined index that does not meet the criteria of other Index data types.
    """
    description: Optional[str] = Field(None, description="A description that defines the OtherIndex.")
    """
    A description that defines the OtherIndex.
    """
    
    @rosetta_condition
    def condition_0_AssetClassRequired(self):
        """
        The asset class must be explicitly set.
        """
        item = self
        return rosetta_attr_exists(rosetta_resolve_attr(self, "assetClass"))

import cdm 
