# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.TradeState import TradeState

__all__ = ['ResolveCashSettlementDate']


@replaceable
def ResolveCashSettlementDate(tradeState: TradeState) -> datetime.date:
    """
    A product agnostic function that resolves the settlement date of the payout for the period in question
    
    Parameters 
    ----------
    tradeState : TradeState
    
    Returns
    -------
    date : date
    
    """
    self = inspect.currentframe()
    
    
    date = rosetta_resolve_attr(self, "date")
    
    
    return date

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
