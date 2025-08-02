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

__all__ = ['ReplaceTradeLot']


@replaceable
def ReplaceTradeLot(tradeLots: list[TradeLot] | None, newTradeLot: TradeLot) -> TradeLot:
    """
    Replace TradeLot in with matching TradeLot->lotIdentifier.
    
    Parameters 
    ----------
    tradeLots : TradeLot
    Input list of TradeLots.
    
    newTradeLot : TradeLot
    The TradeLot to replace a matching TradeLot in the list.
    
    Returns
    -------
    mergedTradeLots : TradeLot
    
    """
    self = inspect.currentframe()
    
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "newTradeLot")
    
    def _else_fn0():
        return item
    
    mergedTradeLots = map(lambda item: if_cond_fn((all_elements(rosetta_resolve_attr(item, "lotIdentifier"), "=", rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeLot"), "lotIdentifier")) or ((not rosetta_attr_exists(rosetta_resolve_attr(item, "lotIdentifier"))) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "newTradeLot"), "lotIdentifier"))))), _then_fn0, _else_fn0), rosetta_resolve_attr(self, "tradeLots"))
    
    
    return mergedTradeLots

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
