# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.event.common.IndexTransitionInstruction import IndexTransitionInstruction
from cdm.event.common.functions.UpdateSpreadAdjustmentAndRateOptions import UpdateSpreadAdjustmentAndRateOptions
from cdm.event.common.TradeState import TradeState

__all__ = ['Create_IndexTransitionTermsChange']


@replaceable
def Create_IndexTransitionTermsChange(instruction: IndexTransitionInstruction, tradeState: TradeState) -> TradeState:
    """
    Function specification to create a terms change that contains changes to the floating rate indexes and adds an adjustment spread to any existing spread.
    
    Parameters 
    ----------
    instruction : IndexTransitionInstruction
    Specifies the instructions containing the floating rate index, spread adjustment for each leg to be updated, and the effective date.
    
    tradeState : TradeState
    Specifies the trade to be updated.
    
    Returns
    -------
    termsChange : TradeState
    
    """
    self = inspect.currentframe()
    
    
    termsChange =  UpdateSpreadAdjustmentAndRateOptions(rosetta_resolve_attr(self, "tradeState"), rosetta_resolve_attr(rosetta_resolve_attr(self, "instruction"), "priceQuantity"))
    
    
    return termsChange

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
