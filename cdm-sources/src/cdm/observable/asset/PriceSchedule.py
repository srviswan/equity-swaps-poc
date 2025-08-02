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

__all__ = ['PriceSchedule']

from cdm.base.math.MeasureSchedule import MeasureSchedule

class PriceSchedule(MeasureSchedule):
    """
    Specifies the price of a financial instrument in a trade as a schedule of measures. A price generically expresses the value of an exchange as a ratio: it measures the amount of one thing needed to be exchanged for 1 unit of another thing (e.g. cash in a specific currency in exchange for a bond or share). This generic representation can be used to support any type of financial price beyond just cash price: e.g. an interest rate, a foreign exchange rate, etc. This data type is generically based on a schedule and can also be used to represent a price as a single value.
    """
    perUnitOf: Optional[cdm.base.math.UnitType.UnitType] = Field(None, description="Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).")
    """
    Provides an attribute to define the unit of the thing being priced. For example, {amount, unitOfAmount, PerUnitOfAmount} = [10, EUR, Shares] = (10.00 EUR/SHARE) * (300,000 SHARES) = EUR 3,000,000.00 (Shares cancel out in the calculation).
    """
    priceType: cdm.observable.asset.PriceTypeEnum.PriceTypeEnum = Field(..., description="Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.")
    """
    Specifies the price type as an enumeration: interest rate, exchange rate, asset price etc. This attribute is mandatory so that prices can always be clasiffied according to their type. The price type implies some constraints on the price's units.
    """
    priceExpression: Optional[cdm.observable.asset.PriceExpressionEnum.PriceExpressionEnum] = Field(None, description="(Optionally) Specifies whether the price is expressed in absolute or percentage terms.")
    """
    (Optionally) Specifies whether the price is expressed in absolute or percentage terms.
    """
    composite: Optional[cdm.observable.asset.PriceComposite.PriceComposite] = Field(None, description="(Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.")
    """
    (Optionally) Specifies the underlying price components if the price can be expressed as a composite: e.g. dirty price = clean price + accrued.
    """
    arithmeticOperator: Optional[cdm.base.math.ArithmeticOperationEnum.ArithmeticOperationEnum] = Field(None, description="(Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.")
    """
    (Optionally) When the price is to be understood as an operator to apply to an observable, i.e. a spread, multiplier or min/max.
    """
    cashPrice: Optional[cdm.observable.asset.CashPrice.CashPrice] = Field(None, description="(Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.")
    """
    (Optionally when the price type is cash) Additional attributes that further define a cash price, e.g. what type of fee it is.
    """
    
    @rosetta_condition
    def condition_0_UnitOfAmountExists(self):
        """
        Requires that a unit of amount must be specified for price unless price type is Variance, Volatility or Correlation.
        """
        item = self
        def _then_fn0():
            return ((not rosetta_attr_exists(rosetta_resolve_attr(self, "unit"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "perUnitOf"))))
        
        def _else_fn0():
            return (rosetta_attr_exists(rosetta_resolve_attr(self, "unit")) and rosetta_attr_exists(rosetta_resolve_attr(self, "perUnitOf")))
        
        return if_cond_fn(((all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "VARIANCE")) or all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "VOLATILITY"))) or all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "CORRELATION"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_1_PositiveAssetPrice(self):
        """
        Requires that per FpML rules, the FX rate must be a positive value.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "value"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "EXCHANGE_RATE")) or all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE"))) and (not rosetta_attr_exists(rosetta_resolve_attr(self, "arithmeticOperator")))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_2_PositiveSpotRate(self):
        """
        Requires that per FpML rules, the spot rate must be a positive value, for example for FX or Commodities.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "composite"), "baseValue"), ">", 0)
        
        def _else_fn0():
            return True
        
        return if_cond_fn(((all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "EXCHANGE_RATE")) or all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE"))) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "composite"), "baseValue"))), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_3_PositiveCashPrice(self):
        """
        Requires that any price expressed as a cash price and generating a cashflow must be positive
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "value"), ">", 0) or all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "datedValue"), "value"), ">", 0))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "CASH_PRICE")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_4_CurrencyUnitForInterestRate(self):
        """
        Requires that the unit of amount for an interest rate must be a currency.
        """
        item = self
        def _then_fn0():
            return rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "unit"), "currency"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_5_Choice(self):
        """
        The price can be specified mutually exclusively as a cashflow, an operator (e.g. a spread or multiplier), or a composite.
        """
        item = self
        return self.check_one_of_constraint('cashPrice', 'arithmeticOperator', 'composite', necessity=False)
    
    @rosetta_condition
    def condition_6_CashPrice(self):
        """
        If a cash price type is specified, the price type must be cash, otherwise it must be non-cash.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "CASH_PRICE"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "cashPrice")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_7_ArithmeticOperator(self):
        """
        Operator must not be subtract or divide.
        """
        item = self
        return (any_elements(rosetta_resolve_attr(self, "arithmeticOperator"), "<>", rosetta_resolve_attr(ArithmeticOperationEnum, "SUBTRACT")) and any_elements(rosetta_resolve_attr(self, "arithmeticOperator"), "<>", rosetta_resolve_attr(ArithmeticOperationEnum, "DIVIDE")))
    
    @rosetta_condition
    def condition_8_SpreadPrice(self):
        """
        A spread type can only be specified when the price type is an asset price or an interest rate.
        """
        item = self
        def _then_fn0():
            return (all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE")) or all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "INTEREST_RATE")))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(self, "arithmeticOperator"), "=", rosetta_resolve_attr(ArithmeticOperationEnum, "ADD")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_9_ForwardPoint(self):
        """
        If composite operand type is ForwardPoint then the price type must be ExchangeRate.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "EXCHANGE_RATE"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "composite"), "operandType"), "=", rosetta_resolve_attr(PriceOperandEnum, "FORWARD_POINT")), _then_fn0, _else_fn0)
    
    @rosetta_condition
    def condition_10_AccruedInterest(self):
        """
        If composite operand type is AccruedInterest then the price type must be AssetPrice.
        """
        item = self
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(self, "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "ASSET_PRICE"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "composite"), "operandType"), "=", rosetta_resolve_attr(PriceOperandEnum, "ACCRUED_INTEREST")), _then_fn0, _else_fn0)

import cdm 
import cdm.base.math.UnitType
import cdm.observable.asset.PriceTypeEnum
import cdm.observable.asset.PriceExpressionEnum
import cdm.observable.asset.PriceComposite
import cdm.base.math.ArithmeticOperationEnum
import cdm.observable.asset.CashPrice
from cdm.observable.asset.PriceTypeEnum import PriceTypeEnum
from cdm.base.math.ArithmeticOperationEnum import ArithmeticOperationEnum
from cdm.observable.asset.PriceOperandEnum import PriceOperandEnum
