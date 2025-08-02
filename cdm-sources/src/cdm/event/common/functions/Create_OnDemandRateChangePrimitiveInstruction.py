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
from cdm.event.common.functions.Create_OnDemandRateChangePriceChangeInstruction import Create_OnDemandRateChangePriceChangeInstruction
from cdm.event.common.functions.Create_OnDemandRateChangeTermsChangeInstruction import Create_OnDemandRateChangeTermsChangeInstruction
from cdm.event.common.TradeState import TradeState
from cdm.base.datetime.AdjustableOrRelativeDate import AdjustableOrRelativeDate

__all__ = ['Create_OnDemandRateChangePrimitiveInstruction']


@replaceable
def Create_OnDemandRateChangePrimitiveInstruction(tradeState: TradeState, effectiveDate: AdjustableOrRelativeDate, agreedRate: Decimal) -> PrimitiveInstruction:
    """
    Creates a full primitive instruction for an on-demand rate change event. A rate change consists in closing the original trade and opening a new one with the same details as the original one, but with a new rate (price) and effective date. The business event logic checks that there is only 1 rate price in the original trade to be updated.
    
    Parameters 
    ----------
    tradeState : TradeState
    The original trade to be modified with new rate.
    
    effectiveDate : AdjustableOrRelativeDate
    The date to close and open a new position.
    
    agreedRate : number
    The new rate agreed between the parties.
    
    Returns
    -------
    instruction : PrimitiveInstruction
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_SingleTradeLot(self):
        """
        Rate change only works for a trade with a single trade lot.
        """
        return all_elements(rosetta_count(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "=", 1)
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    instruction = _get_rosetta_object('PrimitiveInstruction', 'split', _get_rosetta_object('SplitInstruction', 'breakdown', [Create_TerminationInstruction(rosetta_resolve_attr(self, "tradeState"))]))
    instruction.add_rosetta_attr(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, instruction), 'split'), 'breakdown'), [PrimitiveInstruction(quantityChange=Create_OnDemandRateChangePriceChangeInstruction(rosetta_resolve_attr(get_only_element(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "tradeLot")), "priceQuantity"), rosetta_resolve_attr(self, "agreedRate")), termsChange=Create_OnDemandRateChangeTermsChangeInstruction(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "tradeState"), "trade"), "product"), rosetta_resolve_attr(self, "effectiveDate")))])
    
    
    return instruction

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
