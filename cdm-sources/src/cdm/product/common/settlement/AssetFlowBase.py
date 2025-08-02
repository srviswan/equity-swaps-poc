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

__all__ = ['AssetFlowBase']


class AssetFlowBase(BaseDataClass):
    """
    Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).
    """
    quantity: cdm.base.math.NonNegativeQuantity.NonNegativeQuantity = Field(..., description="Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.")
    """
    Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.
    """
    asset: cdm.base.staticdata.asset.common.Asset.Asset = Field(..., description="Represents the object that is subject to the transfer, it could be an asset or a reference.")
    """
    Represents the object that is subject to the transfer, it could be an asset or a reference.
    """
    settlementDate: cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDate = Field(..., description="Represents the date on which the transfer to due.")
    """
    Represents the date on which the transfer to due.
    """
    
    @rosetta_condition
    def condition_0_QuantityUnitExists(self):
        """
        Aligns the type of unit and the type of asset.
        """
        item = self
        def _then_fn2():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "financialUnit"))
        
        def _else_fn2():
            return True
        
        def _then_fn1():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "capacityUnit"))
        
        def _else_fn1():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "asset"), "Instrument")), _then_fn2, _else_fn2)
        
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "currency"))
        
        def _else_fn0():
            return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "asset"), "Commodity")), _then_fn1, _else_fn1)
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "asset"), "Cash")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.math.NonNegativeQuantity
import cdm.base.staticdata.asset.common.Asset
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate
