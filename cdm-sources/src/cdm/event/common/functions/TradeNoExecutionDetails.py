# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.Trade import Trade
from cdm.event.common.functions.EmptyExecutionDetails import EmptyExecutionDetails

__all__ = ['TradeNoExecutionDetails']


@replaceable
def TradeNoExecutionDetails(trade: Trade) -> Trade:
    """
    
    Parameters 
    ----------
    trade : Trade
    
    Returns
    -------
    newTrade : Trade
    
    """
    self = inspect.currentframe()
    
    
    newTrade =  rosetta_resolve_attr(self, "trade")
    newTrade = _get_rosetta_object('Trade', 'executionDetails', EmptyExecutionDetails())
    
    
    return newTrade

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
