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

__all__ = ['BasketConstituent']

from cdm.observable.asset.Observable import Observable

class BasketConstituent(Observable):
    """
    Identifies the constituents of the basket
    """
    quantity: List[AttributeWithAddress[cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] | cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] = Field([], description="Specifies a quantity schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->quantity that this quantity is referencing.")
    """
    Specifies a quantity schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->quantity that this quantity is referencing.
    """
    initialValuationPrice: List[AttributeWithAddress[cdm.observable.asset.PriceSchedule.PriceSchedule] | cdm.observable.asset.PriceSchedule.PriceSchedule] = Field([], description="Specifies an initial price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.")
    """
    Specifies an initial price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
    """
    interimValuationPrice: List[AttributeWithAddress[cdm.observable.asset.PriceSchedule.PriceSchedule] | cdm.observable.asset.PriceSchedule.PriceSchedule] = Field([], description="Specifies an interim price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.")
    """
    Specifies an interim price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
    """
    finalValuationPrice: List[AttributeWithAddress[cdm.observable.asset.PriceSchedule.PriceSchedule] | cdm.observable.asset.PriceSchedule.PriceSchedule] = Field([], description="Specifies a final price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.")
    """
    Specifies a final price schedule to be associated to an individual underlier that is a basket constituent. The multiple cardinality is aligned to the one of the PriceQuantity->price that this price is referencing.
    """
    
    @rosetta_condition
    def condition_0_BasketsOfBaskets(self):
        """
        To prevent endless looping, baskets of baskets are not supported.
        """
        item = self
        return (not rosetta_attr_exists(rosetta_resolve_attr(self, "Basket")))

import cdm 
import cdm.base.math.NonNegativeQuantitySchedule
import cdm.observable.asset.PriceSchedule
