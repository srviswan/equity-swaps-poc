# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.functions.UpdateIndexTransitionPriceAndRateOption import UpdateIndexTransitionPriceAndRateOption
from cdm.event.common.functions.FindMatchingIndexTransitionInstruction import FindMatchingIndexTransitionInstruction
from cdm.observable.asset.PriceQuantity import PriceQuantity
from cdm.event.common.TradeState import TradeState

__all__ = ['UpdateSpreadAdjustmentAndRateOptions']


@replaceable
def UpdateSpreadAdjustmentAndRateOptions(tradeState: TradeState, instructions: list[PriceQuantity]) -> TradeState:
    """
    For each of the trade state's price quantity, find a matching price quantity instruction, and call the update function.
    
    Parameters 
    ----------
    tradeState : TradeState
    Specifies the trade to be updated.
    
    instructions : PriceQuantity
    List of PriceQuantity from the IndexTransitionInstruction (e.g. one for each floating rate leg).
    
    Returns
    -------
    updatedTradeState : TradeState
    
    """
    self = inspect.currentframe()
    
    
    updatedTradeState =  rosetta_resolve_attr(self, "tradeState")
    updatedTradeState = _get_rosetta_object('TradeState', 'trade', _get_rosetta_object('Trade', 'tradeLot', _get_rosetta_object('TradeLot', 'priceQuantity', map(lambda item: UpdateIndexTransitionPriceAndRateOption(item, FindMatchingIndexTransitionInstruction(rosetta_resolve_attr(self, "instructions"), item)), rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "priceQuantity")))))
    
    
    return updatedTradeState

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
