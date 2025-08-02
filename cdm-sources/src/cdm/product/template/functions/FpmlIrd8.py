# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.base.staticdata.party.Account import Account
from cdm.event.common.Trade import Trade

__all__ = ['FpmlIrd8']


@replaceable
def FpmlIrd8(trade: Trade, accounts: list[Account] | None) -> bool:
    """
    FpML validation rule ird-8 - If the same party is specified as the payer and receiver, then different accounts must be specified.
    
    Parameters 
    ----------
    trade : Trade
    
    accounts : Account
    
    Returns
    -------
    success : boolean
    
    """
    self = inspect.currentframe()
    
    
    success = rosetta_resolve_attr(self, "success")
    
    
    return success

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
