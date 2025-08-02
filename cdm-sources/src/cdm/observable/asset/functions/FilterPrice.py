# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.ArithmeticOperationEnum import ArithmeticOperationEnum
from cdm.observable.asset.PriceTypeEnum import PriceTypeEnum
from cdm.observable.asset.PriceSchedule import PriceSchedule
from cdm.observable.asset.PriceExpressionEnum import PriceExpressionEnum

__all__ = ['FilterPrice']


@replaceable
def FilterPrice(prices: list[PriceSchedule] | None, priceType: PriceTypeEnum, arithmeticOperators: list[ArithmeticOperationEnum] | None, priceExpression: PriceExpressionEnum | None) -> PriceSchedule:
    """
    Filter list of prices based on price type.
    
    Parameters 
    ----------
    prices : PriceSchedule
    List of prices to filter.
    
    priceType : PriceTypeEnum
    The price type to filter by: asset price, cash price, exchange rate etc.
    
    arithmeticOperators : ArithmeticOperationEnum
    Optionally filter based on the type of operator, e.g. if price is specified as a spread or a multiplier. Several operators can be passed as arguments (e.g. [ Add, Subtract ]).
    
    priceExpression : PriceExpressionEnum
    Optionally filter by type of price expression: percentage of notional, par value fraction
    
    Returns
    -------
    price : PriceSchedule
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return contains(rosetta_resolve_attr(self, "arithmeticOperators"), rosetta_resolve_attr(item, "arithmeticOperator"))
    
    def _else_fn0():
        return True
    
    def _then_fn0():
        return all_elements(rosetta_resolve_attr(item, "priceExpression"), "=", rosetta_resolve_attr(self, "priceExpression"))
    
    def _else_fn0():
        return True
    
    price =  (lambda item: get_only_element(item))((lambda item: rosetta_filter(item, lambda item: if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "priceExpression")), _then_fn0, _else_fn0)))((lambda item: rosetta_filter(item, lambda item: if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(self, "arithmeticOperators")), _then_fn0, _else_fn0)))(rosetta_filter(rosetta_resolve_attr(self, "prices"), lambda item: all_elements(rosetta_resolve_attr(item, "priceType"), "=", rosetta_resolve_attr(self, "priceType"))))))
    
    
    return price

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
