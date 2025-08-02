# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.math.functions.FilterQuantityByFinancialUnit import FilterQuantityByFinancialUnit
from cdm.event.common.functions.Create_TradeState import Create_TradeState
from cdm.base.math.QuantityChangeDirectionEnum import QuantityChangeDirectionEnum
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.StockSplitInstruction import StockSplitInstruction
from cdm.event.common.TradeState import TradeState
from cdm.base.math.NonNegativeQuantitySchedule import NonNegativeQuantitySchedule
from cdm.observable.asset.Price import Price
from cdm.base.math.UnitType import UnitType
from cdm.base.math.FinancialUnitEnum import FinancialUnitEnum

__all__ = ['Create_StockSplit']


@replaceable
def Create_StockSplit(stockSplitInstruction: StockSplitInstruction, before: TradeState) -> TradeState:
    """
    Function specification to create the fully-formed business event which represents the impact of a stock split (or a reverse stock split) on an Equity Derivatives contract on a certain date.
    
    Parameters 
    ----------
    stockSplitInstruction : StockSplitInstruction
    
    before : TradeState
    
    Returns
    -------
    after : TradeState
    
    """
    self = inspect.currentframe()
    
    
    preSplitNumberOfShares = rosetta_resolve_attr(get_only_element(FilterQuantityByFinancialUnit(rosetta_resolve_attr(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "trade"), "tradeLot")), "priceQuantity"), "quantity"), rosetta_resolve_attr(FinancialUnitEnum, "SHARE"))), "value")
    postSplitNumberOfShares = NonNegativeQuantitySchedule(value=(rosetta_resolve_attr(self, "preSplitNumberOfShares") * rosetta_resolve_attr(rosetta_resolve_attr(self, "stockSplitInstruction"), "adjustmentRatio")), unit=UnitType(financialUnit=rosetta_resolve_attr(FinancialUnitEnum, "SHARE")))
    preSplitPrice = (lambda item: get_only_element(item))(rosetta_filter(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "trade"), "tradeLot"), "priceQuantity"), "price"), lambda item: all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "perUnitOf"), "financialUnit"), "=", rosetta_resolve_attr(FinancialUnitEnum, "SHARE"))))
    postSplitPrice = Price(value=(rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "value") / rosetta_resolve_attr(rosetta_resolve_attr(self, "stockSplitInstruction"), "adjustmentRatio")), unit=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "unit"), perUnitOf=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "perUnitOf"), priceType=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "priceType"), priceExpression=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "priceExpression"), composite=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "composite"), arithmeticOperator=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "arithmeticOperator"), cashPrice=rosetta_resolve_attr(rosetta_resolve_attr(self, "preSplitPrice"), "cashPrice"), datedValue=[])
    postSplitPriceQuantity = PriceQuantity(price=rosetta_resolve_attr(self, "postSplitPrice"), quantity=rosetta_resolve_attr(self, "postSplitNumberOfShares"))
    quantityChangeInstruction = QuantityChangeInstruction(change=rosetta_resolve_attr(self, "postSplitPriceQuantity"), direction=rosetta_resolve_attr(QuantityChangeDirectionEnum, "REPLACE"), lotIdentifier=[])
    primitiveInstruction = PrimitiveInstruction(quantityChange=rosetta_resolve_attr(self, "quantityChangeInstruction"))
    after =  Create_TradeState(rosetta_resolve_attr(self, "primitiveInstruction"), rosetta_resolve_attr(self, "before"))
    
    
    return after

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
