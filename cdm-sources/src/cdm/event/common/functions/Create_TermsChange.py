# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.TermsChangeInstruction import TermsChangeInstruction
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_TermsChange']


@replaceable
def Create_TermsChange(termsChange: TermsChangeInstruction, before: TradeState) -> TradeState:
    """
    A specification of the inputs, outputs and constraints when calculating the after tradeState based Terms Change Primitive Instruction.
    
    Parameters 
    ----------
    termsChange : TermsChangeInstruction
    Instructions to be used as an input to the function
    
    before : TradeState
    current trade to be ammended
    
    Returns
    -------
    tradeState : TradeState
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "termsChange"), "product")
    
    def _else_fn0():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "trade"), "product")
    
    def _then_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "termsChange"), "ancillaryParty")
    
    def _else_fn1():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "trade"), "ancillaryParty")
    
    def _then_fn2():
        return rosetta_resolve_attr(rosetta_resolve_attr(self, "termsChange"), "adjustment")
    
    def _else_fn2():
        return rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "before"), "trade"), "adjustment")
    
    newProduct = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "termsChange"), "product")), _then_fn0, _else_fn0)
    newAncillaryParty = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "termsChange"), "ancillaryParty")), _then_fn1, _else_fn1)
    newAdjustment = if_cond_fn(rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "termsChange"), "adjustment")), _then_fn2, _else_fn2)
    tradeState =  rosetta_resolve_attr(self, "before")
    tradeState = _get_rosetta_object('TradeState', 'trade', _get_rosetta_object('Trade', 'product', rosetta_resolve_attr(self, "newProduct")))
    tradeState = set_rosetta_attr(rosetta_resolve_attr(self, 'tradeState'), 'trade->tradeLot', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot"))
    tradeState = set_rosetta_attr(rosetta_resolve_attr(self, 'tradeState'), 'trade->counterparty', rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "counterparty"))
    tradeState = set_rosetta_attr(rosetta_resolve_attr(self, 'tradeState'), 'trade->ancillaryParty', rosetta_resolve_attr(self, "newAncillaryParty"))
    tradeState = set_rosetta_attr(rosetta_resolve_attr(self, 'tradeState'), 'trade->adjustment', rosetta_resolve_attr(self, "newAdjustment"))
    
    
    return tradeState

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
