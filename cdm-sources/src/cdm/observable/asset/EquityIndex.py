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

__all__ = ['EquityIndex']

from cdm.observable.asset.IndexBase import IndexBase

class EquityIndex(IndexBase):
    """
    Specification of an index based on equity securities, e.g. the S&P 500..
    """
    
    @rosetta_condition
    def condition_0_EquityAssetClass(self):
        """
        The asset class must be Equity.
        """
        item = self
        return all_elements(rosetta_resolve_attr(self, "assetClass"), "=", rosetta_resolve_attr(AssetClassEnum, "EQUITY"))

import cdm 
from cdm.base.staticdata.asset.common.AssetClassEnum import AssetClassEnum
