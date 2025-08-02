# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.Transfer import Transfer

__all__ = ['FilterCashTransfers']


@replaceable
def FilterCashTransfers(transfers: list[Transfer] | None) -> Transfer:
    """
    
    Parameters 
    ----------
    transfers : Transfer
    
    Returns
    -------
    cashTransfers : Transfer
    
    """
    self = inspect.currentframe()
    
    
    cashTransfers = rosetta_filter(rosetta_resolve_attr(self, "transfers"), lambda item: rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "quantity"), "unit"), "currency")))
    
    
    return cashTransfers

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
