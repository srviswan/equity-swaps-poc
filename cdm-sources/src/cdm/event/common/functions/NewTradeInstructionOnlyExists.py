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

__all__ = ['NewTradeInstructionOnlyExists']


@replaceable
def NewTradeInstructionOnlyExists(primitiveInstruction: PrimitiveInstruction) -> bool:
    """
    
    Parameters 
    ----------
    primitiveInstruction : PrimitiveInstruction
    
    Returns
    -------
    result : boolean
    
    """
    self = inspect.currentframe()
    
    
    result =  (self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution")) or self.check_one_of_constraint(self, rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution")))
    
    
    return result

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
