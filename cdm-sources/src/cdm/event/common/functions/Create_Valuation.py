# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.ValuationInstruction import ValuationInstruction
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_Valuation']


@replaceable
def Create_Valuation(instruction: ValuationInstruction, before: TradeState) -> TradeState:
    """
    Function specification to incorporate a new assessment of the valuation in the valuation history of a given trade state.
    
    Parameters 
    ----------
    instruction : ValuationInstruction
    
    before : TradeState
    Specifies the trade to be updated.
    
    Returns
    -------
    after : TradeState
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return []
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "valuationHistory")
    
    beforeValuationHistory = if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "replace"), "=", True), _then_fn0, _else_fn0)
    after =  rosetta_resolve_attr(self, "before")
    after = _get_rosetta_object('TradeState', 'valuationHistory', rosetta_resolve_attr(self, "beforeValuationHistory"))
    after.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, after), 'valuationHistory'), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "valuation"))
    
    
    return after

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
