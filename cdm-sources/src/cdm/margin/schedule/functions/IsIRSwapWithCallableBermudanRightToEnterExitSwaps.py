# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.product.template.OptionExerciseStyleEnum import OptionExerciseStyleEnum
from cdm.product.template.EconomicTerms import EconomicTerms

__all__ = ['IsIRSwapWithCallableBermudanRightToEnterExitSwaps']


@replaceable
def IsIRSwapWithCallableBermudanRightToEnterExitSwaps(economicTerms: EconomicTerms) -> bool:
    """
    Identifies a product as an IR swap with bermudan/callable right to enter/exit swaps.
    
    Parameters 
    ----------
    economicTerms : EconomicTerms
    
    Returns
    -------
    is_Product : boolean
    
    """
    self = inspect.currentframe()
    
    
    is_Product =  (Qualify_BaseProduct_IRSwap(rosetta_resolve_attr(self, "economicTerms")) and all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "economicTerms"), "terminationProvision"), "earlyTerminationProvision"), "optionalEarlyTermination"), "exerciseTerms"), "style"), "=", rosetta_resolve_attr(OptionExerciseStyleEnum, "BERMUDA")))
    
    
    return is_Product

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
