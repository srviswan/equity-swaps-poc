# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.observable.asset.Price import Price
from cdm.observable.asset.PriceSchedule import PriceSchedule

__all__ = ['ResolveEquityInitialPrice']


@replaceable
def ResolveEquityInitialPrice(price: list[PriceSchedule] | None) -> PriceSchedule:
    """
    To be replaced by full resolve price function implementation.
    
    Parameters 
    ----------
    price : PriceSchedule
    
    Returns
    -------
    initialPrice : PriceSchedule
    
    """
    self = inspect.currentframe()
    
    
    initialPrice =  (lambda item: get_only_element(item))((lambda item: map(lambda item: Price(value=rosetta_resolve_attr(item, "value"), unit=rosetta_resolve_attr(item, "unit"), perUnitOf=rosetta_resolve_attr(item, "perUnitOf"), priceType=rosetta_resolve_attr(item, "priceType"), priceExpression=rosetta_resolve_attr(item, "priceExpression"), composite=rosetta_resolve_attr(item, "composite"), arithmeticOperator=rosetta_resolve_attr(item, "arithmeticOperator"), cashPrice=rosetta_resolve_attr(item, "cashPrice"), datedValue=[]), item))(rosetta_filter(rosetta_resolve_attr(self, "price"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "perUnitOf"), "financialUnit"), "=", rosetta_resolve_attr(FinancialUnitEnum, "SHARE")))))
    
    
    return initialPrice

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
