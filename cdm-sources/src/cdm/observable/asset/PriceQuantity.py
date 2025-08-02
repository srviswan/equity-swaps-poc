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

__all__ = ['PriceQuantity']


class PriceQuantity(BaseDataClass):
    """
    Defines a settlement as an exchange between two parties of a specified quantity of an asset (the quantity) against a specified quantity of another asset (the price). The settlement is optional and can be either cash or physical. The quantity can additionally be specified in terms of one or more currency amounts. In the case of non-cash products, the settlement of the price/quantity would not be specified here and instead would be delegated to the product mechanics, as parameterised by the price/quantity values.
    """
    price: List[AttributeWithMeta[cdm.observable.asset.PriceSchedule.PriceSchedule] | cdm.observable.asset.PriceSchedule.PriceSchedule] = Field([], description="Specifies a price to be used for trade amounts and other purposes.")
    """
    Specifies a price to be used for trade amounts and other purposes.
    """
    quantity: List[AttributeWithMeta[cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] | cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantitySchedule] = Field([], description="Specifies a quantity to be associated with an event, for example a trade amount.")
    """
    Specifies a quantity to be associated with an event, for example a trade amount.
    """
    observable: Optional[AttributeWithMeta[cdm.observable.asset.Observable.Observable] | cdm.observable.asset.Observable.Observable] = Field(None, description="Specifies the object to be observed for a price, it could be an asset or an index. The cardinality is optional as some quantity / price cases have no observable (e.g. a fixed rate in a given currency).")
    """
    Specifies the object to be observed for a price, it could be an asset or an index. The cardinality is optional as some quantity / price cases have no observable (e.g. a fixed rate in a given currency).
    """
    effectiveDate: Optional[cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDate] = Field(None, description="Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.")
    """
    Specifies the date at which the price and quantity become effective. This day may be subject to adjustment in accordance with a business day convention, or could be specified as relative to a trade date, for instance. Optional cardinality, as the effective date is usually specified in the product definition, so it may only need to be specified as part of the PriceQuantity in an increase/decrease scenario for an existing trade.
    """
    
    @rosetta_condition
    def condition_0_NonCurrencyQuantities(self):
        """
        There should be at most one quantity which is not a currency, except for commodities where there may be two.
        """
        item = self
        return (all_elements((rosetta_count(rosetta_resolve_attr(self, "quantity")) - rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "currency"))), "<=", 1) or ((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "observable"), "Asset"), "Commodity")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "capacityUnit"))) and all_elements((rosetta_count(rosetta_resolve_attr(self, "quantity")) - rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "currency"))), "<=", 2)))
    
    @rosetta_condition
    def condition_1_ArithmeticOperator(self):
        """
        When observable is InterestRateIndex, and price exists, then price should have an arithmetic operator.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "price"), "arithmeticOperator"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "observable"), "Index"), "InterestRateIndex")) and rosetta_attr_exists(rosetta_resolve_attr(self, "price"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_InterestRateObservable(self):
        """
        When the observable is an interest rate index, the price type must be interest rate and the arithmetic operator must be specified.
        """
        item = self
        return InterestRateObservableCondition(item)

import cdm 
import cdm.observable.asset.PriceSchedule
import cdm.base.math.NonNegativeQuantitySchedule
import cdm.observable.asset.Observable
import cdm.base.datetime.AdjustableOrRelativeDate
from cdm.observable.asset.functions.InterestRateObservableCondition import InterestRateObservableCondition
