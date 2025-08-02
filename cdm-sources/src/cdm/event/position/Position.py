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

__all__ = ['Position']


class Position(BaseDataClass):
    """
    A Position describes how much of a given Product is being held and constitutes the atomic element of a Portfolio.
    """
    priceQuantity: List[cdm.observable.asset.PriceQuantity.PriceQuantity] = Field([], description="Position with many price quantities.")
    """
    Position with many price quantities.
    """
    @rosetta_condition
    def cardinality_priceQuantity(self):
        return check_cardinality(self.priceQuantity, 1, None)
    
    product: cdm.product.template.Product.Product = Field(..., description="The product underlying the position.")
    """
    The product underlying the position.
    """
    cashBalance: Optional[cdm.observable.asset.Money.Money] = Field(None, description="The aggregate cost of proceeds")
    """
    The aggregate cost of proceeds
    """
    tradeReference: Optional[AttributeWithReference | cdm.event.common.TradeState.TradeState] = Field(None, description="Reference to the Contract, in case product is contractual and the contract has been formed")
    """
    Reference to the Contract, in case product is contractual and the contract has been formed
    """

import cdm 
import cdm.observable.asset.PriceQuantity
import cdm.product.template.Product
import cdm.observable.asset.Money
import cdm.event.common.TradeState
