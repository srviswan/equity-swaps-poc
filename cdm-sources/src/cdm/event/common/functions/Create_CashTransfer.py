# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.CalculateTransferInstruction import CalculateTransferInstruction
from cdm.event.common.functions.ResolveTransfer import ResolveTransfer
from cdm.event.common.Transfer import Transfer

__all__ = ['Create_CashTransfer']


@replaceable
def Create_CashTransfer(instruction: CalculateTransferInstruction) -> Transfer:
    """
    Defines how Transfer that represents an exchange of cash, should be constructed.
    
    Parameters 
    ----------
    instruction : CalculateTransferInstruction
    
    Returns
    -------
    transfer : Transfer
    
    """
    self = inspect.currentframe()
    
    
    transfer =  ResolveTransfer(rosetta_resolve_attr(self, "instruction"))
    
    
    return transfer

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
