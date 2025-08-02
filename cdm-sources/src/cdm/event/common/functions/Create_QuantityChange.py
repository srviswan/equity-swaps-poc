# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.TradeLot import TradeLot
from cdm.product.template.functions.ReplaceTradeLot import ReplaceTradeLot
from cdm.event.common.QuantityChangeInstruction import QuantityChangeInstruction
from cdm.product.common.settlement.functions.UpdateAmountForEachMatchingQuantity import UpdateAmountForEachMatchingQuantity
from cdm.product.template.functions.AddTradeLot import AddTradeLot
from cdm.event.common.TradeState import TradeState
from cdm.product.template.functions.FilterTradeLot import FilterTradeLot

__all__ = ['Create_QuantityChange']


@replaceable
def Create_QuantityChange(instruction: QuantityChangeInstruction, tradeState: TradeState) -> TradeState:
    """
    A specification of the inputs, outputs and constraints when calculating the after state of a Quantity Change Primitive Event
    
    Parameters 
    ----------
    instruction : QuantityChangeInstruction
    
    tradeState : TradeState
    
    Returns
    -------
    quantityChange : TradeState
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_CashPriceOnly(self):
        """
        Only termination where the termination price is specified as a cash price is supported for now.
        """
        def _then_fn0():
            return all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "change"), "price"), "priceType"), "=", rosetta_resolve_attr(PriceTypeEnum, "CASH_PRICE"))
        
        def _else_fn0():
            return True
        
        return if_cond_fn((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "direction"), "=", rosetta_resolve_attr(QuantityChangeDirectionEnum, "DECREASE")) and rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "change"), "price"))), _then_fn0, _else_fn0)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn0():
        return FilterTradeLot(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "lotIdentifier"))
    
    def _else_fn0():
        return get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"))
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "change")
    
    def _else_fn1():
        return UpdateAmountForEachMatchingQuantity(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeLot"), "priceQuantity"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "change"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "direction"))
    
    def _then_fn2():
        return rosetta_resolve_attr(AddTradeLot(rosetta_resolve_attr(self, "trade"), TradeLot(lotIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "lotIdentifier"), priceQuantity=rosetta_resolve_attr(self, "newPriceQuantity"))), "tradeLot")
    
    def _else_fn2():
        return ReplaceTradeLot(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"), TradeLot(lotIdentifier=rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "lotIdentifier"), priceQuantity=rosetta_resolve_attr(self, "newPriceQuantity")))
    
    def _then_fn3():
        return rosetta_resolve_attr(PositionStatusEnum, "CLOSED")
    
    def _else_fn3():
        return True
    
    trade = rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade")
    tradeLotExists = rosetta_attr_exists(FilterTradeLot(rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "tradeLot"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "lotIdentifier")))
    tradeLot = if_cond_fn(rosetta_resolve_attr(self, "tradeLotExists"), _then_fn0, _else_fn0)
    newPriceQuantity = if_cond_fn((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "direction"), "=", rosetta_resolve_attr(QuantityChangeDirectionEnum, "INCREASE")) and all_elements(rosetta_resolve_attr(self, "tradeLotExists"), "=", False)), _then_fn1, _else_fn1)
    newTradeLots = if_cond_fn((all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "direction"), "=", rosetta_resolve_attr(QuantityChangeDirectionEnum, "INCREASE")) and all_elements(rosetta_resolve_attr(self, "tradeLotExists"), "=", False)), _then_fn2, _else_fn2)
    quantityChange =  rosetta_resolve_attr(self, "tradeState")
    quantityChange = _get_rosetta_object('TradeState', 'trade', _get_rosetta_object('Trade', 'product', rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "product")))
    quantityChange = set_rosetta_attr(rosetta_resolve_attr(self, 'quantityChange'), 'trade->tradeLot', rosetta_resolve_attr(self, "newTradeLots"))
    quantityChange = set_rosetta_attr(rosetta_resolve_attr(self, 'quantityChange'), 'trade->counterparty', rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "counterparty"))
    quantityChange = set_rosetta_attr(rosetta_resolve_attr(self, 'quantityChange'), 'trade->ancillaryParty', rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "ancillaryParty"))
    quantityChange = set_rosetta_attr(rosetta_resolve_attr(self, 'quantityChange'), 'trade->adjustment', rosetta_resolve_attr(rosetta_resolve_attr(self, "trade"), "adjustment"))
    quantityChange = set_rosetta_attr(rosetta_resolve_attr(self, 'quantityChange'), 'state->positionState', if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeLots"), "priceQuantity"), "quantity"), "value"), "=", 0), _then_fn6, _else_fn6))
    
    
    return quantityChange

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
