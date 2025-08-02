# pylint: disable=line-too-long, invalid-name, missing-function-docstring, missing-module-docstring, superfluous-parens
# pylint: disable=wrong-import-position, unused-import, unused-wildcard-import, wildcard-import, wrong-import-order, missing-class-docstring
from __future__ import annotations
import sys
import datetime
import inspect
from decimal import Decimal
from rosetta.runtime.utils import *
from rosetta.runtime.func_proxy import replaceable, create_module_attr_guardian
from cdm.legaldocumentation.common.ClosedStateEnum import ClosedStateEnum
from cdm.event.common.functions.Create_Reset import Create_Reset
from cdm.event.common.functions.Create_IndexTransitionTermsChange import Create_IndexTransitionTermsChange
from cdm.event.common.functions.Create_Observation import Create_Observation
from cdm.event.common.functions.Create_PartyChange import Create_PartyChange
from cdm.legaldocumentation.common.ClosedState import ClosedState
from cdm.event.common.functions.Create_TermsChange import Create_TermsChange
from cdm.event.common.TradeState import TradeState
from cdm.event.common.functions.Create_ContractFormation import Create_ContractFormation
from cdm.event.common.functions.Create_StockSplit import Create_StockSplit
from cdm.event.common.PrimitiveInstruction import PrimitiveInstruction
from cdm.event.common.functions.Create_Valuation import Create_Valuation
from cdm.event.common.functions.Create_Transfer import Create_Transfer

__all__ = ['Create_TradeState']


@replaceable
def Create_TradeState(primitiveInstruction: PrimitiveInstruction | None, before: TradeState | None) -> TradeState:
    """
    Creates a single trade state by applying primitive instructions to an existing trade state (optional in case an execution instruction is included).
        The primitive instructions are applied in the following order:
            Always first:
                - execution, if it exists, otherwise a before state must be provided
            The following 3 can be executed in any order, because they touch separate components of the trade:
                - quantity change
                - terms change
                - party change
            Always last:
                - contract formation, otherwise the contract could be invalid.
    
    Parameters 
    ----------
    primitiveInstruction : PrimitiveInstruction
    The set of primitive instructions to apply to the trade.
    
    before : TradeState
    The original trade on which the primitive instructions are applied
    
    Returns
    -------
    after : TradeState
    
    """
    _pre_registry = {}
    self = inspect.currentframe()
    
    # conditions
    
    @rosetta_local_condition(_pre_registry)
    def condition_0_NoSplit(self):
        """
        The primitive instruction cannot contain a split, as this function is designed to return a single trade state.
        """
        return (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "split")))
    # Execute all registered conditions
    execute_local_conditions(_pre_registry, 'Pre-condition')
    
    def _then_fn0():
        return rosetta_resolve_attr(self, "before")
    
    def _else_fn0():
        return Create_Execution(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution"))
    
    def _then_fn1():
        return rosetta_resolve_attr(self, "execution")
    
    def _else_fn1():
        return Create_QuantityChange(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "quantityChange"), rosetta_resolve_attr(self, "execution"))
    
    def _then_fn2():
        return rosetta_resolve_attr(self, "quantityChange")
    
    def _else_fn2():
        return Create_TermsChange(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "termsChange"), rosetta_resolve_attr(self, "quantityChange"))
    
    def _then_fn3():
        return rosetta_resolve_attr(self, "termsChange")
    
    def _else_fn3():
        return Create_PartyChange(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "partyChange"), "counterparty"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "partyChange"), "ancillaryParty"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "partyChange"), "partyRole"), rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "partyChange"), "tradeId"), rosetta_resolve_attr(self, "termsChange"))
    
    def _then_fn4():
        return rosetta_resolve_attr(self, "partyChange")
    
    def _else_fn4():
        return Create_ContractFormation(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "contractFormation"), rosetta_resolve_attr(self, "partyChange"))
    
    def _then_fn5():
        return rosetta_resolve_attr(self, "contractFormation")
    
    def _else_fn5():
        return Create_Transfer(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "transfer"), rosetta_resolve_attr(self, "contractFormation"))
    
    def _then_fn6():
        return rosetta_resolve_attr(self, "transfer")
    
    def _else_fn6():
        return Create_Reset(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "reset"), rosetta_resolve_attr(self, "transfer"))
    
    def _then_fn7():
        return rosetta_resolve_attr(self, "reset")
    
    def _else_fn7():
        return Create_IndexTransitionTermsChange(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "indexTransition"), rosetta_resolve_attr(self, "reset"))
    
    def _then_fn8():
        return rosetta_resolve_attr(self, "indexTransition")
    
    def _else_fn8():
        return Create_Observation(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "observation"), rosetta_resolve_attr(self, "indexTransition"))
    
    def _then_fn9():
        return rosetta_resolve_attr(self, "observation")
    
    def _else_fn9():
        return Create_Valuation(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "valuation"), rosetta_resolve_attr(self, "observation"))
    
    def _then_fn10():
        return rosetta_resolve_attr(self, "valuation")
    
    def _else_fn10():
        return Create_StockSplit(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "stockSplit"), rosetta_resolve_attr(self, "valuation"))
    
    def _then_fn11():
        return ClosedState(state=rosetta_resolve_attr(ClosedStateEnum, "TERMINATED"), activityDate=[])
    
    def _else_fn11():
        return True
    
    execution = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "execution"))), _then_fn0, _else_fn0)
    quantityChange = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "quantityChange"))), _then_fn1, _else_fn1)
    termsChange = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "termsChange"))), _then_fn2, _else_fn2)
    partyChange = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "partyChange"))), _then_fn3, _else_fn3)
    contractFormation = if_cond_fn((rosetta_attr_exists(rosetta_resolve_attr(self, "primitiveInstruction")) and (not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "contractFormation")))), _then_fn4, _else_fn4)
    transfer = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "transfer"))), _then_fn5, _else_fn5)
    reset = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "reset"))), _then_fn6, _else_fn6)
    indexTransition = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "indexTransition"))), _then_fn7, _else_fn7)
    observation = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "observation"))), _then_fn8, _else_fn8)
    valuation = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "valuation"))), _then_fn9, _else_fn9)
    stockSplit = if_cond_fn((not rosetta_attr_exists(rosetta_resolve_attr(rosetta_resolve_attr(self, "primitiveInstruction"), "stockSplit"))), _then_fn10, _else_fn10)
    after =  rosetta_resolve_attr(self, "stockSplit")
    after = _get_rosetta_object('TradeState', 'state', _get_rosetta_object('State', 'closedState', if_cond_fn(all_elements(rosetta_resolve_attr(rosetta_resolve_attr(rosetta_resolve_attr(self, "contractFormation"), "state"), "positionState"), "=", rosetta_resolve_attr(PositionStatusEnum, "CLOSED")), _then_fn1, _else_fn1)))
    
    
    return after

sys.modules[__name__].__class__ = create_module_attr_guardian(sys.modules[__name__].__class__)
