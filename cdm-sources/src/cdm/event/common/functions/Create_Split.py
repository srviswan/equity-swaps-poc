# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_Split']


@replaceable
def Create_Split(breakdown: list[PrimitiveInstruction], originalTrade: TradeState) -> TradeState:
    """
    Defines the logic for splitting a trade into separate copies. The split instruction contains a breakdown into N set of primitive instructions. Each set contains the primitive instructions to be applied to each post-split trade, eventually producing N trades. The split function underpins a number of business events such as clearing or allocation.
    
    Parameters 
    ----------
    breakdown : PrimitiveInstruction
    Each primitive instruction contains the set of instructions to be applied to each post-split trade.
    
    originalTrade : TradeState
    The original trade to be split, which must be of single cardinality.
    
    Returns
    -------
    splitTrade : TradeState
    
    """
    self = inspect.currentframe()
    
    
    splitTrade = map(lambda item: Create_TradeState(item, rosetta_resolve_attr(self, "originalTrade")), rosetta_resolve_attr(self, "breakdown"))
    
    
    return splitTrade

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
